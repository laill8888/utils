package com.laill.p8;

import java.util.Iterator;

/**
 * @program: test
 * @description:
 * @author: laill
 * @create: 2018/12/16
 */
public class Iterableclass implements Iterable<String> {
    private String[] strings = ("and that is how " + "we know thw earth to be banana-shaped").split(" ");

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index<strings.length;
            }

            @Override
            public String next() {
                return strings[index++];
            }
        };
    }

    public static void main(String[] args) {
        Iterableclass strings = new Iterableclass();
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
