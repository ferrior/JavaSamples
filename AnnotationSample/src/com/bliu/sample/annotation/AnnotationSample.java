
package com.bliu.sample.annotation;
@SampleAnnotation1("AnnotationSample")
public class AnnotationSample {
    @SampleAnnotation2(description="this is annotation2",isAnnotation=true)  
    public void sayHello(){  
            System.out.println("hello world!");  
    } 
}
