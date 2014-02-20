/**
 * 
 */
package com.bliu.sample.annotation;

/**
 * @author bliu
 *
 */
@SampleAnnotation1("AnnotationSample")
public class AnnotationSample {

	/**
	 * 
	 */
	public AnnotationSample() {
		// TODO Auto-generated constructor stub
	}

    @SampleAnnotation2(description="this is annotation2",isAnnotation=true)  
    public void sayHello(){  
            System.out.println("hello world!");  
    } 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
