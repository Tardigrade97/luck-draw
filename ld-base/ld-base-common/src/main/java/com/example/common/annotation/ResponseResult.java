package com.example.common.annotation;


import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

// 声明周期：运行时有效
@Retention(RetentionPolicy.RUNTIME)
// 指定使用范围。 ElementType.METHOD： 方法
// ElementType.TYPE ： 类、接口
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
@RestController
public @interface ResponseResult {
    boolean ignore() default false;
}
