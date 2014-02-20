package com.bliu.sample.annotation;
import java.lang.reflect.Method;
import org.junit.Test;
public class TestAnnotation {
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
