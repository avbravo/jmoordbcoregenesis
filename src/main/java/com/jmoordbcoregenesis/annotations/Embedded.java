package com.jmoordbcoregenesis.annotations ;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
*
* @author avbravo
*/


@Retention(RetentionPolicy.RUNTIME)

public @interface Embedded {

String name() default "";


}
