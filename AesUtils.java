package com.cqxxty.security.admin.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author aunix
 */
public class AesUtils {
    /**
     * 密码
     */
    private static final String KEY = "fz9@7iAC39BJM^6N";
    /**
     * 参数分别代表 算法名称/加密模式/数据填充方式
     */
    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";

    /**
     * 加密
     *
     * @param content    加密的字符串
     * @param encryptKey key值
     * @return 密文
     */
    public static String encrypt(String content, String encryptKey) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));
            byte[] b = cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
            // 采用base64算法进行转码,避免出现中文乱码
            return Base64.getEncoder().encodeToString(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

    /**
     * 解密
     *
     * @param encryptStr 解密的字符串
     * @param decryptKey 解密的key值
     * @return 明文
     */
    public static String decrypt(String encryptStr, String decryptKey) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
            // 采用base64算法进行转码,避免出现中文乱码
            byte[] encryptBytes = Base64.getDecoder().decode(encryptStr);
            byte[] decryptBytes = cipher.doFinal(encryptBytes);
            return new String(decryptBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptStr;
    }

    public static String encrypt(String content) {
        return encrypt(content, KEY);
    }

    public static String decrypt(String encryptStr) {
        return decrypt(encryptStr, KEY);
    }

}
