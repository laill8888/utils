package com.laill.p5;

/**
 * @program: test
 * @description:
 * @author: laill
 * @create: 2018/12/7
 */
public class Callee1 implements Incrementable {
    private int i=0;
    @Override
    public void increment() {
        i++;
        System.out.println("********Callee1*******"+i);
    }
}
