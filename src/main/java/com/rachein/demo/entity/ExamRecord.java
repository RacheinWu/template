package com.rachein.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/7 12:10
 */
@Data
public class ExamRecord {

    private String examRecordId;

    private String examId;//参与的考试的id

    private String answerOptionIds;//考生作答地每个题目的选项(题目和题目之间用_分
    // 隔，题目有多个选项地话用-分隔),用于查看考试详情

    private String examJoinerId;//参与者，即user的id

    /**
     * 参加考试的日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date examJoinDate;
    /**
     * 考试耗时(秒)
     */
    private Integer examTimeCost;
    /**
     * 考试得分
     */
    private Integer examJoinScore;
    /**
     * 考试得分水平
     */
    private Integer examResultLevel;
}
