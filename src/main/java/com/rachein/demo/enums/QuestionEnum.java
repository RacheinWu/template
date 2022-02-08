package com.rachein.demo.enums;

import lombok.Getter;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/7 13:19
 */
@Getter
public enum  QuestionEnum {

    /**
     * 问题类型
     */
    RADIO(1, "xx"),
    CHECK(2, "多选题"),
    JUDGE(3, "判断题");


    QuestionEnum(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    private Integer id;
    private String role;

}
