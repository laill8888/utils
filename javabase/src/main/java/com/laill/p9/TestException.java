package com.laill.p9;

import java.util.HashMap;

/**
 * @program: t7_04.test
 * @description:
 * @author: laill
 * @create: 2018/12/18
 */
public class TestException {
    public static void main(String[] args) {
        HashMap<String, String> objectObjectHashMap = new HashMap<>();

        if(objectObjectHashMap.get("fdfd")==null){
            throw new NullPointerException("fdgfgf");
        }
    }

    public void method() throws MyException {
        HashMap<String, String> objectObjectHashMap = new HashMap<>();
        boolean s=objectObjectHashMap.get("fdfd").contains("34434");
        throw new MyException();
    }
}
