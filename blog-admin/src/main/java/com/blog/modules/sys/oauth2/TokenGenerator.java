package com.blog.modules.sys.oauth2;



import java.security.MessageDigest;
import java.util.UUID;

/**
 * @author:艾宾如
 * @createDate:2023/6/8
 * @description:
 **/
public class TokenGenerator {
    public static String generateValue() {
        return generateValue(UUID.randomUUID().toString());
    }

    private static final char[] hexCode = "0123456789abcdef".toCharArray();

    public static String toHexString(byte[] data) {
        if (data == null) {
            return null;
        }
        StringBuilder r = new StringBuilder(data.length * 2);
        for (byte b : data) {
            r.append(hexCode[(b>>4) & 0xf]);
            r.append(hexCode[(b & 0xf)]);
        }
        return r.toString();
    }

    public static String generateValue(String param) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(param.getBytes());
            byte[] memessageDitest = algorithm.digest();
            return toHexString(memessageDitest);
        } catch (Exception e) {
            return "";
            //throw new RRException("生成Token失败", e);
        }
    }
}
