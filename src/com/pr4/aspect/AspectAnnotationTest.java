package com.pr4.aspect;



import com.pr4.aspect.HelloService;

import com.pr4.aspect.IncrementService;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class AspectAnnotationTest {
	

    ApplicationContext context ;
    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("test-aspectj.xml");
    }
    @Test
    public void testAnnotationService() {
        HelloService helloService = (HelloService) context.getBean("helloService");
        assertTrue(helloService.sayHello().contains(HelloService.HELLO_FROM_HELLO_SERVICE));
        assertTrue(helloService.sayHello().length()>HelloService.HELLO_FROM_HELLO_SERVICE.length());
    }
    
    @Test
    public void testBeanAndAJService() {
        IncrementService service = context.getBean(IncrementService.class);
        int i = 10;
        assertEquals(i,service.inc(i));
    }
    @Test
    public void testAddAMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        IncrementService service = context.getBean(IncrementService.class);
        assertEquals(service.myCall("Hennesy"),"Cognac Hennesy");
    }

}