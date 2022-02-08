package com.rachein.demo.qo;

import lombok.Data;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/7 13:41
 */
@Data
public class LoginQo {
    /**
     * 1表示用户名，2表示邮箱
     */
    private Integer loginType;
    /**
     * 用户名/邮箱的字符串
     */
    private String userInfo;
    /**
     * 用户密码
     */
    private String password;

}
