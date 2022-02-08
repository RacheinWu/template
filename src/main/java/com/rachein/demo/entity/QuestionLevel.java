package com.rachein.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/7 13:02
 */
@Data
public class QuestionLevel {

    @JsonProperty("id")
    private Integer questionLevelId;

    @JsonProperty("name")
    private String questionLevelName;

    @JsonProperty("description")
    private String questionLevelDescription;

}
