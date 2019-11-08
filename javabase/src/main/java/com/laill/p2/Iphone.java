package com.laill.p2;


import com.laill.p1.Mobile;

/**
 * @program: t7_04.test
 * @description:
 * @author: laill
 * @create: 2018/11/23
 */
public class Iphone extends Mobile {

    @Override
    public double discount(double d) {
        //return super.discount(d);
        return 50;
    }

    @Override
    public final boolean printBoolean(){
        return true;
    }

    public static void main(String[] args) {
        Iphone iphone = new Iphone();
        iphone.setPrice(5000.0);
        System.out.println(iphone.discount(0.8));
    }
}
