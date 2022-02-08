package com.rachein.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/7 13:06
 */
@Data
@TableName("t_user")
public class User {

    @TableId("user_id")
    private String userId;

    @TableField("user_username")
    private String username;

    @TableField("user_nickname")
    private String userNickname;

    @TableField("user_password")
    private String password;

    @TableField("user_roleId")
    private String userRoleId;

    @TableField("user_description")
    private String userDescription;

    @TableField("user_mail")
    private String userEmail;

    @TableField("user_phone")
    private String userPhone;

    @TableField("user_avatar_url")
    private String avatar;

    private String gender;

    private String salt;

    /**
     * 创建时间, 设计表时设置了自动插入当前时间，无需在Java代码中设置了
     */
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间，设计表时设置了自动插入当前时间，无需在Java代码中设置了。
     */
    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}
