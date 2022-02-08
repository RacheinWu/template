package com.rachein.demo.dto;

import lombok.Data;

/**
 * @Description : 注册接口参数
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/7 11:40
 */

@Data
public class RegisterDTO {

    private String email;
    private String password;
    private String mobile;

//    private String captcha;//验证码

}
