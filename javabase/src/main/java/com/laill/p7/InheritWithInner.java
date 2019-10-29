package com.laill.p7;

/**
 * @program: test
 * @description:
 * @author: laill
 * @create: 2018/12/7
 */
public class InheritWithInner extends WithInner {
    private int a=9;
    private static int b=99;
    private final static int c=999;
    class Inner{
        public Inner(){
            System.out.println("InheritWithInner Inner");
        }
    }

    public  void method(){
        int ff=0;
        final  int gg=89;
        final class tclass{
            public void m(){
                System.out.println(a);
                System.out.println(b);
                System.out.println(c);
                System.out.println(ff);
                System.out.println(gg);
            }
        }
    }

    public static void main(String[] args) {
        new InheritWithInner();
    }
}
