package com.rachein.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/7 12:18
 */
@Data
public class Question {

    private String questionId;
    private String questionName;
    private Integer questionScore;
    private String questionCreatorId;
    private Integer questionLevelId;
    private Integer questionTypeId;
    private Integer questionCategoryId;
    private String questionDescription;
    private String questionOptionIds;
    private String questionAnswerOptionIds;
    /**
     * 创建时间, 设计表时设置了自动插入当前时间，无需在Java代码中设置了
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间，设计表时设置了自动插入当前时间，无需在Java代码中设置了。
     * 同时@DynamicUpdate注解可以时间当数据库数据变化时自动更新，无需人工维护
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}
