package com.doofy.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.alibaba.fastjson.JSONObject;
import org.bouncycastle.util.encoders.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DencryptUtil {

    public static void main(String[] args) throws Exception {
        final String key = "3231ad23d62a025e10a8320eda13a4ec3231ad23d62a025e";
        String telePhone = "你好&*woshioo+--";
        String threeDes = encryptBy3Des(telePhone, key);
        System.out.println(threeDes);
        byte[] bytes = decryptBy3Des(threeDes, key);
        System.out.println(new String(bytes));


    }
    public static String getParamString(JSONObject params) {
        StringBuilder sb = new StringBuilder();
        List<String> paramKeys = new ArrayList<>(params.keySet());
        Collections.sort(paramKeys);
        for (String paramKey : paramKeys) {
            sb.append(paramKey);
            sb.append("=");
            sb.append(params.getString(paramKey));
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    public static byte[] decryptBy3Des(String v, String k) {
        try {
            Cipher c = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            c.init(Cipher.DECRYPT_MODE, new SecretKeySpec(hexToBytes(k), "DESede"));
            return c.doFinal(Base64.decode(v));
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return new byte[0];
    }
    public static String encryptBy3Des(String value, String key) {
        try {
            Cipher c = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(hexToBytes(key), "DESede"));
            byte[] b = c.doFinal(value.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(b).replaceAll("\r", "").replaceAll("\n", "");
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return "";
    }
    public static byte[] hexToBytes(String hex) {
        hex = hex.length() % 2 != 0 ? "0" + hex : hex;
        byte[] b = new byte[hex.length() / 2];
        for (int i = 0; i < b.length; i++) {
            int index = i * 2;
            int v = Integer.parseInt(hex.substring(index, index + 2), 16);
            b[i] = (byte) v;
        }
        return b;
    }


}