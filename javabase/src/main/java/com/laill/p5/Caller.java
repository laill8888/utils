package com.laill.p5;

/**
 * @program: test
 * @description:
 * @author: laill
 * @create: 2018/12/7
 */
public class Caller {
    private Incrementable callbackreference;

    public Caller(Incrementable callbackreference) {
        this.callbackreference = callbackreference;
    }
    public void go(){
        callbackreference.increment();
    }
}
