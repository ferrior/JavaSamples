package com.bliu.sample.annotation;
import java.lang.annotation.*;    
@Target(ElementType.TYPE)  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public @interface SampleAnnotation1 {
	String value();  
}
