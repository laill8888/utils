package com.laill.p6;

/**
 * @program: t7_04.test
 * @description:
 * @author: laill
 * @create: 2018/12/7
 */
public class InheritInner extends WithInner.Inner
{
    //指向外围类的秘密的引用必须被初始化
    public InheritInner(WithInner withInner,String s) {
        withInner.super(s);
    }

    public static void main(String[] args) {
        WithInner withInner = new WithInner();
        InheritInner inheritInner = new InheritInner(withInner,"rrt");

    }

}
