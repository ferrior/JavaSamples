/**
 * 
 */
package com.bliu.sample.annotation;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author bliu
 * 
 */
public class TestAnnotation {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws NoSuchMethodException, SecurityException, ClassNotFoundException {
		Class<?> cls = Class.forName("com.bliu.sample.annotation.AnnotationSample");
		boolean flag = cls.isAnnotationPresent(SampleAnnotation1.class);
		if (flag) {
			System.out.println("判断类是annotation");
			SampleAnnotation1 annotation1 = cls.getAnnotation(SampleAnnotation1.class);
			System.out.println(annotation1.value());
		}

		Method method = cls.getMethod("sayHello");
		flag = method.isAnnotationPresent(SampleAnnotation2.class);
		if (flag) {
			System.out.println("判断方法也是annotation");
			SampleAnnotation2 annotation2 = method
					.getAnnotation(SampleAnnotation2.class);
			System.out.println(annotation2.description() + "/t"
					+ annotation2.isAnnotation());
		}
	}

}
