package com.laill.p7;

/**
 * @program: test
 * @description:
 * @author: laill
 * @create: 2018/12/7
 */
public class WithInner {
    class Inner{
        public Inner(){
            System.out.println("WithInner Inner");
        }
    }

    public WithInner() {
        new Inner();
    }
}
