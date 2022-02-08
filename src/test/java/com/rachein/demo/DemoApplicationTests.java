package com.rachein.demo;

import com.rachein.demo.dto.RegisterDTO;
import com.rachein.demo.enums.LoginTypeEnum;
import com.rachein.demo.qo.LoginQo;
import com.rachein.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    UserService userService;

    @Test
    void register() {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setMobile("18924566928");
        registerDTO.setEmail("racheinwu@outlook.com");
        registerDTO.setPassword("wuyuanjian0");
        userService.register(registerDTO);

    }

    @Test
    void login() {
        LoginQo loginQo = new LoginQo();
        loginQo.setLoginType(LoginTypeEnum.EMAIL.getType());
        loginQo.setPassword("wuyuanjian0");
        loginQo.setUserInfo("racheinwu@outlook.com");
        userService.login(loginQo);
    }


}
