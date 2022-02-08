package com.rachein.demo.entity;

import lombok.Data;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/7 13:05
 */
@Data
public class Role {

    private Integer roleId;

    private String roleName;

    private String roleDescription;

    private String roleDetail;

    /**
     * 角色所能访问的页面的主键集合(用-连接起来字符串)
     */
    private String rolePageIds;

}
