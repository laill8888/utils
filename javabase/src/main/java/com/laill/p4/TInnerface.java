package com.laill.p4;

/**
 * @program: t7_04.test
 * @description:
 * @author: laill
 * @create: 2018/12/3
 */
public interface TInnerface {
    void methodInnerClassMethod();
     class InterfaceClass implements TInnerface{
         public void methodInnerClassMethod() {

         }
         public void say(){
             System.out.println("say say say ......");
         }

         public static void main(String[] args) {
             new InterfaceClass().say();
         }
     }
}
