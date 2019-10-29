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
 * @ClassName 类名：DESUtils
 * @Description 功能说明：对称加密算法
 * 数据发送方使用密钥经过特殊的加密算法处理后，生成复杂的加密密文进行发送；
 * 数据接收方使用相同的密钥及相同的算法的逆算法对密文解密。
 * 常用的对称加密算法包括des、3des、aes算法。
 *
 * <p>
 * TODO
 * </p>
 * ***********************************************************************
 * @date 创建日期：2019年10月26日
 */
public class DESUtils {
    /**
     * 生成DES加密算法的密钥
     *
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String getKeyDES() throws NoSuchAlgorithmException {
        //获取密钥生成器的实例
        KeyGenerator des = KeyGenerator.getInstance("DES");
        //设置DES算法的密钥为56位
        des.init(56);
        //生成DES密钥
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
    public static SecretKey loadKeyDES(String base64Key) throws IOException {
        byte[] bytes = Base64Util.base642byte(base64Key);
        SecretKeySpec key = new SecretKeySpec(bytes, "DES");
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
    public static byte[] encryptDES(byte[] source, SecretKey key)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("DES");
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
    public static byte[] decryptDES(byte[] source, SecretKey key)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] bytes = cipher.doFinal(source);
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        SecretKey secretKey = loadKeyDES(getKeyDES());
        String s1 = Base64Util.byte2base64(encryptDES("12345".getBytes(), secretKey));
        System.out.println("12345经过DES加密算法base64编码后：" + s1);

        String s2= new String(decryptDES(Base64Util.base642byte(s1), secretKey));
        System.out.println("解密后：" + s2);

    }
}
