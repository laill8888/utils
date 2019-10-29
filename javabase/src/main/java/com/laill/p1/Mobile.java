package com.laill.p1;

/**
 * @program: test2
 * @description:
 * @author: laill
 * @create: 2018/9/23
 */
public  class Mobile {
    private Double price;
    private String name;

    protected  boolean printBoolean(){
        return true;
    }

    public double discount(double d){
        return this.price*d;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}