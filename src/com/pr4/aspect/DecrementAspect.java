package com.pr4.aspect;


public aspect DecrementAspect {

    pointcut incMethod(): execution(public int inc(int));

    int around(int number): incMethod() && args(number) {
        return proceed(number) - 1;
    }
}