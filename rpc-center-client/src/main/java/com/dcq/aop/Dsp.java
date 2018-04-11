package com.dcq.aop;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Demo class
 *
 * @author chenqiudai
 * @date 10/04/2018
 */


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Dsp {
    String value() default "";
}
