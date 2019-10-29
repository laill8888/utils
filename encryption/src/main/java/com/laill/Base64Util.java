package com.laill;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

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
 * @ClassName 类名：Base64Util
 * @Description 功能说明：base64编码和解码
 * 是一种编码，不能认为是一种加密算法
 * 基于64个可打印字符来表示二进制数据的方法
 *
 * <p>
 * TODO
 * </p>
 * ***********************************************************************
 * @date 创建日期：2019年10月19日
 */
public class Base64Util {
    public static String byte2base64(byte[] bytes){
        BASE64Encoder base64Encoder=new BASE64Encoder();
        return base64Encoder.encode(bytes);
    }
    public static byte[] base642byte(String base64) throws IOException {
        final BASE64Decoder base64Decoder = new BASE64Decoder();
        return base64Decoder.decodeBuffer(base64);
    }
}
