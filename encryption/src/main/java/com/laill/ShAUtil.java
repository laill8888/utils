package com.laill;

import java.security.MessageDigest;

/**
 * @author 创建人：laill
 * @version 版本号：V1.0
 *          <p>
 *          **************************修订记录***************************************
 *          <p>
 *          2019年10月19日 laill 创建该类功能。
 *          <p>
 *          ***********************************************************************
 *          </p>
 * @ClassName 类名：ShAUtil
 * @Description 功能说明：安全散列算法
 * sha-1基于md4算法的，一种信息摘要算法的实现，摘要信息的长度为160位，运算速度比MD5慢，但更安全。
 * <p>
 * TODO
 * </p>
 * ***********************************************************************
 * @date 创建日期：2019年10月19日
 */
public class ShAUtil {
    public final static String SHA1(String content) {
        //用于加密的字符
        char[] md5String = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            //使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中
            byte[] btInput = content.getBytes();

            //信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。
            MessageDigest mdInst = MessageDigest.getInstance("SHA-1");

            //MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要
            mdInst.update(btInput);

            // 摘要更新之后，通过调用digest（）执行哈希计算，获得密文
            byte[] md = mdInst.digest();

            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = md5String[byte0 >>> 4 & 0xf];
                str[k++] = md5String[byte0 & 0xf];
            }

            //返回经过加密后的字符串
            return new String(str);

        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(ShAUtil.SHA1("123456"));
    }
}
