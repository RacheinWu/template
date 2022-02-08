package com.rachein.demo.entity;

import lombok.Data;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/7 12:18
 */
@Data
public class Page {

    private Integer pageId;

    private String pageName;

    private String pageDescription;

    private String actionIds;
}
