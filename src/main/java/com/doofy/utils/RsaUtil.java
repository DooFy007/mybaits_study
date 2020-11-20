package com.doofy.utils;


import org.apache.commons.codec.binary.Base64;
import org.springframework.util.Base64Utils;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public class RsaUtil {
    public static final String SIGN_ALGORITHMS = "SHA256WithRSA";
    /**
     * 密钥长度 于原文长度对应 以及越长速度越慢
     */
    private final static int KEY_SIZE = 1024;

    /**
     * 随机生成密钥对
     */
    public static Map<String, String> genKeyPair() throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器
        keyPairGen.initialize(KEY_SIZE, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        // 得到私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        // 得到公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        String publicKeyString = Base64Utils.encodeToString(publicKey.getEncoded());
        // 得到私钥字符串
        String privateKeyString = Base64Utils.encodeToString(privateKey.getEncoded());
        // 将公钥和私钥保存到Map
         Map<String, String> keyMap = new HashMap<String, String>();
         keyMap.put("privateKey",privateKeyString);
         keyMap.put("publicKey",publicKeyString);
         return keyMap;
    }

    public static void main(String[] args) throws Exception {
        Map<String, String> map = genKeyPair();
        map.keySet().forEach(key-> System.out.println(key+":"+map.get(key)));
        String privateKey = map.get("privateKey");
        String publicKey=map.get("publicKey");
        String value="我是@￥）——++-*&dsaf";
        String sign = sign(value, privateKey);
        System.out.println(sign);
        boolean verify = verify(value, publicKey, sign);
        System.out.println(verify);
    }
    /**
     * 签名
     * @param value      明文
     * @param privateKey 私钥
     * @return
     * @throws Exception
     */
    public static String sign(String value, String privateKey) throws Exception {
        byte[] keyBytes = Base64Utils.decodeFromString(privateKey);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyf = KeyFactory.getInstance("RSA");
        PrivateKey priKey = keyf.generatePrivate(keySpec);
        Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
        signature.initSign(priKey);
        signature.update(value.getBytes("UTF-8"));
        byte[] signed = signature.sign();
        String result = Base64Utils.encodeToString(signed);
        return result;
    }

    /**
     * 验签
     * @param value     明文
     * @param publicKey 公钥
     * @param sign      密文
     * @return
     * @throws Exception
     */
    public static boolean verify(String value, String publicKey,String sign) throws Exception{
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec (keyBytes);
        KeyFactory keyf = KeyFactory.getInstance("RSA");
        PublicKey pubkey = keyf.generatePublic(keySpec);
        Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
        signature.initVerify(pubkey);
        signature.update(value.getBytes());
        boolean result = signature.verify(Base64.decodeBase64(sign.getBytes()));
        return result;
    }


}
