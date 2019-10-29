package com.laill;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author 创建人：laill
 * @version 版本号：V1.0
 * <p>
 * **************************修订记录***************************************
 * <p>
 * 2019年10月26日 laill 创建该类功能。
 * <p>
 * ***********************************************************************
 * </p>
 * @ClassName 类名：AESUtils
 * @Description 功能说明：对称加密AES算法
 * 对称加密算法最流行的算法之一
 * 强安全性、高性能，比DES更安全
 * <p>
 * TODO
 * </p>
 * ***********************************************************************
 * @date 创建日期：2019年10月26日
 */
public class AESUtils {
    /**
     * 生成密钥
     *
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String getKeyAES() throws NoSuchAlgorithmException {
        //获取密钥生成器的实例
        KeyGenerator des = KeyGenerator.getInstance("AES");
        //设置AES算法的密钥为128位,支持128、192、256
        des.init(128);
        //生成AES密钥
        SecretKey key = des.generateKey();
        //方便存储，将密钥进行base64编码
        String byte2base64 = Base64Util.byte2base64(key.getEncoded());
        return byte2base64;
    }

    /**
     * 将密钥base64字符串转换成secretkey对象
     *
     * @param base64Key
     * @return
     * @throws IOException
     */
    public static SecretKey loadKeyAES(String base64Key) throws IOException {
        byte[] bytes = Base64Util.base642byte(base64Key);
        SecretKeySpec key = new SecretKeySpec(bytes, "AES");
        return key;
    }

    /**
     * 加密
     *
     * @param source
     * @param key
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static byte[] encryptAES(byte[] source, SecretKey key)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] bytes = cipher.doFinal(source);
        return bytes;
    }

    /**
     * 解密
     *
     * @param source
     * @param key
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static byte[] decryptAES(byte[] source, SecretKey key)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] bytes = cipher.doFinal(source);
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        SecretKey secretKey = loadKeyAES(getKeyAES());
        String s1 = Base64Util.byte2base64(encryptAES("12345".getBytes(), secretKey));
        System.out.println("12345经过AES加密算法base64编码后：" + s1);

        String s2= new String(decryptAES(Base64Util.base642byte(s1), secretKey));
        System.out.println("解密后：" + s2);

    }
}
