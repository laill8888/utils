package com.laill.p8;

import java.util.LinkedList;

/**
 * 基于LinkedList 实现栈
 * @program: t7_04.test
 * @description:
 * @author: laill
 * @create: 2018/12/14
 */
public class Stack<T> {
    private LinkedList<T> linkedList=new LinkedList<T>();

    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

    public T peek(){
        return linkedList.getFirst();
    }

    public void push(T t){
        linkedList.addFirst(t);
    }

    /**
     * 出栈
     * @return
     */
    public T pop(){
        return linkedList.removeFirst();
    }
}
