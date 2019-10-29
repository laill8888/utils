package com.laill.p4;

/**
 * @program: test
 * @description:
 * @author: laill
 * @create: 2018/11/28
 */
public  class OutClass {
    private int b=9;
    private static int c=6;

    /**
     * 静态内部类
     */
    private static class Inner1{
        private int a=2;
        private final static int d=5;
        private  static int y=99;
        public void method1(){
            OutClass outClass =new OutClass();
            System.out.println(outClass.b);
            //System.out.println(b);
            System.out.println(c);
            System.out.println("inner1 method1");
            OutClass.st();
        }
        static {
            System.out.println("lisi");
        }
        public static void method2(){
            System.out.println(c);
            System.out.println("inner1 method2");
            OutClass.st();
        }
    }

    /**
     * 非静态内部类
     */
    private  class Inner2{
        private int a=2;
        private final static int d=5;
        //private  static int y=99;
        public void method3(){
            System.out.println(a);
            System.out.println(d);
            OutClass outClass =new OutClass();
            System.out.println(outClass.b);
            System.out.println(b);
            System.out.println(c);
            System.out.println("inner2 method3");
            OutClass.this.ship();
        }
        public  int  getOutClass(){
            //
            return OutClass.this.b;
        }
//        static {
//            System.out.println("lisi");
//        }
        public  void method4(){
            System.out.println(c);
            OutClass.st();
            System.out.println("inner2 method4");
        }
    }
    public Inner1 getInner1(){
        return new Inner1();
    }
    public Inner2 getInner2(){
        return new Inner2();
    }
    public static void st(){
//        Inner2 inner2=new Inner2();
        Inner1 inner1=new Inner1();

        OutClass outClass =new OutClass();
        Inner2 inner2= outClass.getInner2();


        System.out.println("out class st");
    }

    private void ship(){
        Inner1 inner1=getInner1();
        inner1.method1();
        System.out.println(inner1.a);
        System.out.println(inner1.d);
        System.out.println(inner1.y);
        System.out.println(Inner1.y);
        Inner1 inner11=new Inner1();
    }

    /**
     * 局部内部类
     */
    public TInnerface juBuInnerclass(){
        class MethodInnerClass implements TInnerface{
            private int tt=899;
            public void methodInnerClassMethod(){
                System.out.println("局部内部类 methodInnerClassMethod");
            }
        }
        return new MethodInnerClass();
    }
//    public TInnerface juBuInnerclass2(){
//        class MethodInnerClass implements TInnerface{
//            private int tt=899;
//            @Override
//            public void methodInnerClassMethod(){
//                System.out.println("局部内部类 methodInnerClassMethod");
//            }
//        }
//        return new MethodInnerClass();
//    }

    /**
     * 匿名内部类 Anonymous inner class 异步asynchronous 同步Synchronize
     * @return
     */
    public TInnerface getInnerface(){
        return new TInnerface(){
            public void methodInnerClassMethod() {

            }
        };
    }

    /**
     * 匿名内部类
     * @return
     */
    public TInnerface getInnerface2(){
        return ()->new TInnerface(){
            @Override
            public void methodInnerClassMethod() {

            }
        };
    }

    /**
     * 匿名内部类
     * @return
     */
    public TInnerface getInnerface2(String str){
        return ()->new TInnerface(){
            private String string=str;
            @Override
            public void methodInnerClassMethod() {
                System.out.println(string);
            }
        };
    }

    public static void main(String[] args) {
        Inner1 inner111=new Inner1();

        //Inner2 inner22=new Inner2();

        OutClass outClass = new OutClass();
        outClass.ship();

        Inner1 inner1= outClass.getInner1();
        System.out.println(inner1.d);
        Inner1 inner2= outClass.getInner1();
        //OutClass.Inner1 inner3=new Inner1();
        Inner1.method2();

        //Inner2 inner21=new Inner2();
        Inner2 inner21= outClass.getInner2();
        inner21.method3();


        //非静态内部类在拥有外部类对象之前是不可能创建内部类对象的
        //OutClass.Inner2 inner22= outClass.new OutClass.Inner2();
        Inner2 inner22= outClass.new Inner2();

        //直接创建静态内部类的对象
        Inner1 inner11=new Inner1();

        //方法内部：局部内部类
        TInnerface tInnerface=outClass.juBuInnerclass();
        tInnerface.methodInnerClassMethod();
    }
}
