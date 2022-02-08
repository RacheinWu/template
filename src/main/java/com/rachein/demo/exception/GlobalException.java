package com.rachein.demo.exception;

import lombok.Getter;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/7 13:23
 */
@Getter
public class GlobalException extends RuntimeException{

    private CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg) {
        super(codeMsg.toString());
        this.codeMsg = codeMsg;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }

}
