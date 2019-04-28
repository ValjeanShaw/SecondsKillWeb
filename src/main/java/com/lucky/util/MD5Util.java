package com.lucky.util;


import org.apache.commons.codec.digest.DigestUtils;

/**
 * md5 工具类
 *
 * @author: xiaoran
 * @date: 2019-04-22 20:38
 */
public class MD5Util {

    /**
     * 固定的盐
     */
    private static final String salt = "8je%r3td(6c$7>c";

    public static String md5(String string) {
        return DigestUtils.md5Hex(string);
    }

    /**
     * 固定盐加密方式，用于接口入参
     *
     * @param input
     * @return
     */
    public static String inputToFromPass(String input) {
        String string = "" + salt.charAt(4) + salt.charAt(7) + input + salt.charAt(9) + salt.charAt(1) + salt.charAt(6);
        return md5(string);
    }

    /**
     * 随机盐加密方式，用于数据库入库
     *
     * @param form
     * @param saltTemp
     * @return
     */
    public static String formToDbPass(String form, String saltTemp) {
        String string = "" + saltTemp.charAt(9) + saltTemp.charAt(3) + form + saltTemp.charAt(5) + saltTemp.charAt(0) + saltTemp.charAt(8);
        return md5(string);
    }

    /**
     * @param input
     * @param saltTemp
     * @return
     */
    public static String inputToDbPass(String input, String saltTemp) {
        return formToDbPass(inputToFromPass(input), saltTemp);
    }

    public static void main(String[] args) {
        System.out.println(inputToDbPass("12345", "9876543210"));
    }

}
