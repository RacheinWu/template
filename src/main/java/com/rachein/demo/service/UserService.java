package com.rachein.demo.service;

import com.rachein.demo.dto.RegisterDTO;
import com.rachein.demo.entity.User;
import com.rachein.demo.qo.LoginQo;
import com.rachein.demo.vo.UserVo;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/7 14:01
 */
public interface UserService {

    User register(RegisterDTO registerDTO);

    void login(LoginQo loginQo);

    void cache(HttpServletResponse response, String token, UserVo userVo);

    UserVo getByToken(HttpServletResponse response, String token);

}
