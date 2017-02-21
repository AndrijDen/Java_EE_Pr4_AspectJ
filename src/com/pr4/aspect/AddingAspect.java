package com.pr4.aspect;

public aspect AddingAspect {
    public String com.pr4.aspect.IncrementService.myCall(String name) {
        return "Cognac " + name;
    }
}	