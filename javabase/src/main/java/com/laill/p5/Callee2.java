package com.laill.p5;

/**
 * @program: t7_04.test
 * @description:
 * @author: laill
 * @create: 2018/12/7
 */
public class Callee2 extends MyIncrement{
    private int i=0;

    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println("***Callee2****"+i);
    }
    private class Closure implements Incrementable{
        @Override
        public void increment() {
            Callee2.this.increment();
        }
        public void increment2(){

        }
    }
    Incrementable getCallbackReference(){
        return new Closure();
    }
}
