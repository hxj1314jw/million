package com.million.server.common.annotation;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA
 * User: huangxj
 * DATE: 2018/1/29 10:40
 * Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface InsertLog {
}
