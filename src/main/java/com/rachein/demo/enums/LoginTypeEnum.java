package com.rachein.demo.enums;

import lombok.Getter;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/7 13:18
 * 用户账号类型的枚举
 */
@Getter
public enum  LoginTypeEnum {

    USERNAME(1, "用户名"),
    EMAIL(2, "邮箱");

    LoginTypeEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    private Integer type;
    private String name;
}
