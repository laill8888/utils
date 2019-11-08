package com.laill.p5;

/**
 * @program: t7_04.test
 * @description:
 * @author: laill
 * @create: 2018/12/7
 */
public class MyIncrement {
    public void increment(){
        System.out.println("other operation");
    }

    static void f(MyIncrement myIncrement) {
        myIncrement.increment();
    }
}
