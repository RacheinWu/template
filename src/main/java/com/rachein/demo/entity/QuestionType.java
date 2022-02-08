package com.rachein.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/7 13:04
 */
@Data
public class QuestionType {

    @JsonProperty("id")
    private Integer questionTypeId;

    @JsonProperty("name")
    private String questionTypeName;

    @JsonProperty("description")
    private String questionTypeDescription;

}
