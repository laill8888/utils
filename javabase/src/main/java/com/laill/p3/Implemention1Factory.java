package com.laill.p3;

/**
 * @program: test
 * @description:
 * @author: laill
 * @create: 2018/11/28
 */
public class Implemention1Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Implemention1();
    }
}
