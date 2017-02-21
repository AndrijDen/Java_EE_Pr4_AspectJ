package com.pr4.aspect;

import org.springframework.stereotype.Service;

@Service("greetingService")
public class HelloService {

    public static final String HELLO_FROM_HELLO_SERVICE = "Hello from Greeting Service";

    public String sayHello() {
		return HELLO_FROM_HELLO_SERVICE;
	}

}
