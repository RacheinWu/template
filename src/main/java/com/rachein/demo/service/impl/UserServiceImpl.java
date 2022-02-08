package com.rachein.demo.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.rachein.demo.dto.RegisterDTO;
import com.rachein.demo.entity.User;
import com.rachein.demo.enums.LoginTypeEnum;
import com.rachein.demo.exception.CodeMsg;
import com.rachein.demo.exception.GlobalException;
import com.rachein.demo.mapper.UserMapper;
import com.rachein.demo.qo.LoginQo;
import com.rachein.demo.redis.RedisService;
import com.rachein.demo.redis.mine.UserKey;
import com.rachein.demo.service.UserService;
import com.rachein.demo.utils.DateUtil;
import com.rachein.demo.utils.MD5Util;
import com.rachein.demo.utils.UUIDUtil;
import com.rachein.demo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Objects;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/7 14:11
 */
@Service
public class UserServiceImpl implements UserService {

    @Value("${user.default.avatar}")
    //默认头像
    private String defaultAvatar;

    @Value("${user.default.username}")
    //默认名称
    private String defaultUsername;

    @Value("${user.default.description}")
    //默认描述
    private String defaultDescription;

    //TOKEN的前缀声明
    public static final String TOKEN_PREFIX = "ACCESS-TOKEN";


    @Autowired
    RedisService redisService;

    @Autowired
    UserMapper userMapper;

    @Override
    public User register(RegisterDTO registerDTO) {
        //创建一个新的user对象
        User user = new User();
        //查重:
        //********************************************************************************************************
        User c1 = userMapper.selectOne(new QueryWrapper<User>().eq("user_phone", registerDTO.getMobile()));
        if (!Objects.isNull(c1))
            throw new GlobalException(CodeMsg.PHONE_EXITED);
        c1 = userMapper.selectOne(new QueryWrapper<User>().eq("user_mail",registerDTO.getEmail()));
        if (!Objects.isNull(c1))
            throw new GlobalException(CodeMsg.MAIL_EXITED);
        //*********************************************************************************************************
        //设置手机号 *UNIQUE
        user.setUserPhone(registerDTO.getMobile());
        //设置 id
        user.setUserId(IdUtil.simpleUUID());
        //设置登录账号名,默认为 user_ + 手机号 *UNIQUE
        user.setUsername(defaultUsername + "_" + registerDTO.getMobile());
        //设置名称 默认与登录账号一致
        user.setUserNickname(user.getUsername());
        //设置salt
        String salt = UUIDUtil.uuid().substring(0, 8);
        user.setSalt(salt);
        //设置密码 使用DB5 加盐进行加密
        String formPass = MD5Util.inputPassToDbPass(registerDTO.getPassword(), salt);
        user.setPassword(formPass);
        //设置默认头像
        user.setAvatar(defaultAvatar);
        //设置邮箱 *UNIQUE
        user.setUserEmail(registerDTO.getEmail());

        //设置描述信息 默认为xxx
        user.setUserDescription(defaultDescription);
        //设置性别
        user.setGender("未设置");
        //设置分组
        user.setUserRoleId("1");
        System.out.println(user);
        userMapper.insert(user);

        return user;
    }

    @Override
    public void login(LoginQo loginQo) {
        Integer loginType = loginQo.getLoginType();
        String password = loginQo.getPassword();
        String info = loginQo.getUserInfo();
        User user;
        //登录方式
        QueryWrapper<User> wrapper;
        if (LoginTypeEnum.USERNAME.getType().equals(loginType)) {
            wrapper = new QueryWrapper<User>().eq("user_username", info);
        } else  {
            wrapper = new QueryWrapper<User>().eq("user_mail", info);
        }
        if (!Objects.isNull(wrapper)) {
            user = userMapper.selectOne(wrapper);
            if (!Objects.isNull(user)) {
                //获取数据库中的密码(加密后)
                String passDB = user.getPassword();
                //获取salt
                String salt = user.getSalt();
                //1.先对loginQo的密码进行加密处理
                String formPass = MD5Util.inputPassToDbPass(password, salt);
                //2.对比两者密码是否匹配
                if (passDB.equals(formPass)) {
                    //账户匹配成功
                    //1.更新登录时间：
                    user.setUpdateTime(new Date());
                    //2.更新数据库
                    userMapper.updateById(user);
                    //3.生成token
                    String token = UUIDUtil.uuid();
                    System.out.println(token);
                    //4.存储到redis和cookie
                }
                else
                    //密码错误
                    throw new GlobalException(CodeMsg.PASSWORD_ERROR);
            } else {
                //账号不存在
                throw new GlobalException(CodeMsg.ACCOUNT_NOT_EXITED);
            }
        }

    }

    @Override
    /**
     * 缓存到redis和cookie中，替代JWT
     */
    public void cache(HttpServletResponse response, String token, UserVo userVo) {
        if (token == null) return;
        //存储到redis中
        redisService.set(UserKey.TOKEN, token, userVo);
        //创建Cookie
        Cookie cookie = new Cookie(TOKEN_PREFIX, token);
        //设置cookie的生命周期(和redis设置的周期一致)
        cookie.setMaxAge(UserKey.TOKEN.expireSeconds());
        //设置使用范围
        cookie.setPath("/");
        //将cookie打包给response进行传输
        response.addCookie(cookie);
    }

    @Override
    /**
     * 通过token 获取redis中的存储对象
     */
    public UserVo getByToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) return null;
        //取出
        UserVo userVo = redisService.get(UserKey.TOKEN, token, UserVo.class);
        //延长生命周期
        if (!Objects.isNull(userVo)) cache(response, token, userVo);
        return userVo;
    }


}
