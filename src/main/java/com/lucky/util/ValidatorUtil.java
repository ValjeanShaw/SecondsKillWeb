package com.lucky.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义校验工具类
 *
 * @author xiaoran
 * @date 2019/04/28
 */
public class ValidatorUtil {

    /**
     * 手机号码 正则  第一位为1,后面跟十位数字
     */
    private static final Pattern MOBILE_PATTERN = Pattern.compile("1\\d{10}");

    public static boolean isMobile(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }
        Matcher m = MOBILE_PATTERN.matcher(src);
        return m.matches();
    }

}
