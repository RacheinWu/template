package com.rachein.demo.entity;

import lombok.Data;

/**
 * @Description : 前端的操作
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/7 11:42
 */

@Data

public class Action {

    private Integer actionId;

    private String actionName;

    private String actionDescription;

    private Boolean defaultCheck;

}
