package com.laill;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

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
 * @ClassName 类名：RSAUtils
 * @Description 功能说明：非对称加密RSA算法
 * 加密过程：甲方生成一对密钥，称为公钥和私钥，公钥向其他人公开，其他人得到该公钥
 * 对机密信息加密后再发送给甲方，甲方使用保存的私钥进行解密。公钥和私钥需要配对使用。
 *
 * <p>
 * TODO
 * </p>
 * ***********************************************************************
 * @date 创建日期：2019年10月26日
 */
public class RSAUtils {
    /**
     * 生成公钥私钥对
     *
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static KeyPair getKeyPair() throws NoSuchAlgorithmException {
        //获得生成密钥对的实例
        KeyPairGenerator rsa = KeyPairGenerator.getInstance("RSA");
        rsa.initialize(512);
        KeyPair keyPair = rsa.generateKeyPair();
        return keyPair;
    }

    /**
     * 获得公钥base64编码后
     *
     * @param keyPair
     * @return
     */
    public static String getPublicKey(KeyPair keyPair) {
        PublicKey aPublic = keyPair.getPublic();
        byte[] encoded = aPublic.getEncoded();
        return Base64Util.byte2base64(encoded);
    }

    /**
     * 获得私钥base64编码后
     *
     * @param keyPair
     * @return
     */
    public static String getPrivateKey(KeyPair keyPair) {
        PrivateKey aPrivate = keyPair.getPrivate();
        byte[] encoded = aPrivate.getEncoded();
        return Base64Util.byte2base64(encoded);
    }

    /**
     * 获得公钥对象
     *
     * @param pubStr
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static PublicKey string2PublicKey(String pubStr)
            throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] bytes = Base64Util.base642byte(pubStr);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(bytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        return publicKey;
    }

    /**
     * 获得私钥对象
     *
     * @param pubStr
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static PrivateKey string2PrivateKey(String pubStr)
            throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] bytes = Base64Util.base642byte(pubStr);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(bytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);

        return privateKey;
    }

    /**
     * 使用公钥加密
     *
     * @param content
     * @param publicKey
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static byte[] publicEncrypt(byte[] content, PublicKey publicKey)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] bytes = cipher.doFinal(content);
        return bytes;
    }

    /**
     * 使用私钥解密
     *
     * @param content
     * @param privateKey
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static byte[] privateDncrypt(byte[] content, PrivateKey privateKey)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] bytes = cipher.doFinal(content);
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        KeyPair keyPair = getKeyPair();
        String publicKey = getPublicKey(keyPair);
        PublicKey pubKey = string2PublicKey(publicKey);
        String s = Base64Util.byte2base64(publicEncrypt("56231".getBytes(), pubKey));
        System.out.println("12345经过RSA机密base64编码后："+s);
        String privateKey = getPrivateKey(keyPair);
        PrivateKey priKey = string2PrivateKey(privateKey);
        String s2 = new String(privateDncrypt(Base64Util.base642byte(s), priKey));
        System.out.println("解密后：" + s2);
    }
}
