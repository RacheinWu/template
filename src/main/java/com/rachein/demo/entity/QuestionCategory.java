package com.rachein.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/7 12:22
 */

@Data
public class QuestionCategory {


    @JsonProperty("id")
    private Integer questionCategoryId;

    @JsonProperty("name")
    private String questionCategoryName;

    @JsonProperty("description")
    private String questionCategoryDescription;

}
