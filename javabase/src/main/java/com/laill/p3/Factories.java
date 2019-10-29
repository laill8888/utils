package com.laill.p3;

/**
 * @program: test
 * @description:
 * @author: laill
 * @create: 2018/11/28
 *
 * 接口和工厂设计模式方法
 */
public class Factories {
    public static void serviceConsumer(ServiceFactory serviceFactory){
        Service service=serviceFactory.getService();
        service.method1();
        service.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(new Implemention1Factory());
        serviceConsumer(new Implemention2Factory());
    }
}
