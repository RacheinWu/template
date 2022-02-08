package com.rachein.demo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rachein.demo.exception.CodeMsg;
import lombok.Data;

import java.util.Objects;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/7 13:55
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)//避免返回NULL字段
public class ResultVo<T> {

    private Integer code;
    private String msg = "";
    private T data;

    public ResultVo() {}

    private ResultVo(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ResultVo(CodeMsg codeMsg) {
        if (!Objects.isNull(codeMsg)) {
            this.code = codeMsg.getCode();
            this.msg = codeMsg.getMsg();
        }

    }


    public static <T> ResultVo<T> success(T data) {return new ResultVo<T>(CodeMsg.SUCCESS.getCode(), CodeMsg.SUCCESS.getMsg(), data);}

    public static <T> ResultVo<T> error(CodeMsg codeMsg) {return new ResultVo<>(codeMsg);}

}
