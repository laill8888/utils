package com.laill.p10;

/**
 * @program: test
 * @description:
 * @author: laill
 * @create: 2018/12/24
 * show in explorer
 * reset
 */
public class TestString {
    public static void main(String[] args) {
//        String result = "";
//        for (int i = 0; i < 25; i++) {
//            result+=i;
//        }
//        System.out.println(result);
//        List<TestString> list = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            list.add(new TestString());
//        }
//        System.out.println(list);

//        Pattern pattern = Pattern.compile("-?\\d+(count)");
//        Matcher matcher=pattern.matcher("-56count");
//        matcher.find();
//        //while (matcher.find()) {
//            System.out.println(matcher.group(0)+","+matcher.start());
//        //}
//
//        String string = ".my name is lihua,i am 11 years old.i like playing basketball";
//
//        String  stihuan=string.replaceAll("\\d+", "替换");
//        System.out.println(string);
//        System.out.println(stihuan);
//
//        String stihuan2 = string.replaceAll("[a-z&&[l]]", "替换");
//        System.out.println(stihuan2);
//
//        String stihuan3=string.replaceAll("\\w","替换");
//        System.out.println(stihuan3);
//
//        String stihuan4=string.replaceAll("^\\W","替换");
//        System.out.println(stihuan4);

//        int index = 0;
//        Pattern pattern1 = Pattern.compile(args[1]);
//        Matcher matcher1 = pattern1.matcher("");
//
//        for (String s : args) {
//            matcher1.reset(s);
//            while (matcher1.find()) {
//                System.out.println(index++ +":"+matcher1.group()+":"+matcher1.start());
//            }
//
//        }


        MyString sb = new MyString();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sbBuilder = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        sb.append(1);
                        sbBuilder.append("1");
                        stringBuffer.append("1");
                        System.out.println(sb.getNum() + "-" + sbBuilder.length() + "-" + stringBuffer.length());
                    }
                }
            }).start();
        }
    }


    @Override
    public String toString() {
        return super.toString();
    }
}

class MyString {
    private Integer num = 0;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public synchronized void append(Integer num) {
        this.num = this.num + num;
    }
}
