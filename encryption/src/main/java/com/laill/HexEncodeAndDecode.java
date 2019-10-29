package com.laill;

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
 * @ClassName 类名：HexEncodeAndDecode
 * @Description 功能说明：十六进制编码和解码
 * 二进制数据与十六进制数据可以相互转化，每四位二进制数据对应一位十六进制
 * <p>
 * TODO
 * </p>
 * ***********************************************************************
 * @date 创建日期：2019年10月19日
 */
public class HexEncodeAndDecode {
    /**
     * 转成16进制
     *
     * @param bytes
     * @return
     */
    public static String bytes2hex(byte[] bytes) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            //是否为负数
            boolean negative = false;

            if (b < 0) {
                negative = true;
            }

            int inte = Math.abs(b);

            if (negative) {
                inte = inte | 0x80;
            }
            //负数转成正数(最高位的负号变成数值计算)，再转成十六进制
            String temp = Integer.toHexString(inte | 0xFF);
            if (temp.length() == 1) {
                stringBuilder.append("0");
            }
            stringBuilder.append(temp.toLowerCase());
        }
        return stringBuilder.toString();
    }

    /**
     * 16转换成2进制
     *
     * @param hex
     * @return
     */
    public static byte[] hex2bytes(String hex) {
        final byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length(); i++) {
            final String substring = hex.substring(i, i + 2);
            boolean negative = false;
            int inte = Integer.parseInt(substring, 16);
            if (inte > 127) {
                negative = true;
            }

            if (inte == 128) {
                inte = -128;
            } else if (negative) {
                inte = 0 - (inte & 0x7F);

            }
            byte b = (byte) inte;
            bytes[i / 2] = b;
        }

        return bytes;
    }
}
