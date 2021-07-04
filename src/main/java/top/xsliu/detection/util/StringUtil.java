package top.xsliu.detection.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/2/11:27 下午
 */
public class StringUtil {

    public static boolean isBlank(String str){
        return str == null || str.isBlank() || str.isEmpty();
    }

    /**
     * 正则表达式判断是否是邮箱
     * @param str 待判断字符串
     */
    public static boolean isEmail(String str){
        String check = "^([a-z0-9A-Z]+[-|.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(str);
        return matcher.matches();
    }

    /**
     * 正则表达式判断是否是数字字符串
     * @param str 待判断字符串
     */
    public static boolean isNum(String str){
        String check = "^-?[0-9]+";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(str);
        return matcher.matches();
    }
}
