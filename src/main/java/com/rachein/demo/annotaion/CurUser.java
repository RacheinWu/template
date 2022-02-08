package com.rachein.demo.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/8 10:51
 *
 *  *  range -> controller
 *
 */
@Target({ElementType.PARAMETER})//作用于参数上
@Retention(RetentionPolicy.RUNTIME)
public @interface CurUser {
}
