package com.rachein.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import java.util.Date;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/7 11:48
 */

@Data

public class Exam {

    private String examId;
    private String examName;
    private String examAvatar;
    private String examDescription;
    private String examQuestionIds;
    private String examQuestionIdsRadio;
    private String examQuestionIdsCheck;
    private String examQuestionIdsJudge;
    private Integer examScore;
    private Integer examScoreRadio;
    private Integer examScoreCheck;
    private Integer examScoreJudge;
    private String examCreatorId;
    private Integer examTimeLimit;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date examStartDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date examEndDate;
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
