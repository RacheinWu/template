package com.rachein.demo.controller;

import com.rachein.demo.dto.RegisterDTO;
import com.rachein.demo.entity.User;
import com.rachein.demo.qo.LoginQo;
import com.rachein.demo.service.UserService;
import com.rachein.demo.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/7 13:43
 */
@RestController
@Api(tags = "User APIs")
@RequestMapping("user")
public class userController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ApiOperation("注册")
    ResultVo<User> register(@RequestBody RegisterDTO registerDTO) {
        userService.register(registerDTO);
        return null;
    }

    @PostMapping("/login")
    @ApiOperation("根据用户名或邮箱登录,登录成功返回token")
    ResultVo<String> login(@RequestBody LoginQo loginQo) {
        ResultVo<String> resultVO;
        userService.login(loginQo);
        return null;
    }



}
