package com.rachein.demo.enums;

import lombok.Getter;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/7 13:22
 */
@Getter
public enum  RoleEnum {

    /**
     * 用户角色，和数据库里面的role表相对应
     */
    ADMIN(1, "管理员"),
    TEACHER(2, "教师"),
    STUDENT(3, "学生");


    RoleEnum(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    private Integer id;
    private String role;

}
