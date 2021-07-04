package top.xsliu.detection.util;

import java.util.Random;
import java.util.UUID;

/**
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/3/2:36 下午
 */
public class RandomUtil {
    public static String randomString(){
        return UUID.randomUUID().toString();
    }

    public static int randomInt(){
        return Math.abs(new Random(System.currentTimeMillis()).nextInt());
    }

    public static int randomInt(int bound){
        return Math.abs(new Random().nextInt(bound));
    }
}
