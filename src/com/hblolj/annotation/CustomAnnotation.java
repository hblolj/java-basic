package com.hblolj.annotation;

import java.lang.annotation.*;

/**
 * Create With hblolj.
 * Data : 2019/3/4
 * Time : 16:34
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CustomAnnotation {

    String name() default "default-name";
}
