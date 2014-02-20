package com.bliu.sample.annotation;
import java.lang.annotation.*;     
@Target(ElementType.METHOD)  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public @interface SampleAnnotation2 {
	String description();
	boolean isAnnotation();
}
