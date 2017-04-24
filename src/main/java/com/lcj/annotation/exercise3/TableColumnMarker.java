
package com.lcj.annotation.exercise3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TableColumnMarker
{
    int index();
    
    String name();
    
    String ckName() default "";
}
