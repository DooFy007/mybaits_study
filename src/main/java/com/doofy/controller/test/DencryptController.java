package com.doofy.controller.test;

import com.alibaba.fastjson.JSONObject;
import com.doofy.utils.DencryptUtil;
import com.doofy.utils.RsaUtil;
import com.doofy.utils.ThreeDes_key;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "加密签名模块")
@RestController
@RequestMapping("/dencrypt")
@Slf4j
public class DencryptController {
    @ApiOperation(value = "生成加密密钥",notes = "对称加密密钥")
    @GetMapping("/getKey")
    public String getKey(){
        return ThreeDes_key.generateHexString(48);
    }
    @ApiOperation(value = "加密",notes = "3des加密")
    @GetMapping("/encrypt")
    public String encrypt(String srcValue,String key){
        return DencryptUtil.encryptBy3Des(srcValue,key);
    }
    @ApiOperation(value = "解密",notes = "3des解密")
    @GetMapping("/decrypt")
    public String decrypt(String encryptValue,String key){
        return new String(DencryptUtil.decryptBy3Des(encryptValue,key));
    }
    @ApiOperation(value = "生成密钥对",notes = "生成rsa的公钥，私钥")
    @GetMapping("/getKeyPair")
    public Map getKeyPair(){
        Map<String, String> map=new HashMap<>();
        try {
            map = RsaUtil.genKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return map;
    }
    @ApiOperation(value = "签名",notes = "使用私钥对请求报文签名")
    @GetMapping("/sign")
    public String sign(String requestBody,String privateKey){
        try {
            return RsaUtil.sign(requestBody, privateKey);
        } catch (Exception e) {
            throw new RuntimeException("签名失败..");
        }
    }
    @ApiOperation(value = "验签",notes = "使用公钥对请求报文验签")
    @GetMapping("/verify")
    public boolean verify(String sign,String requestBody,String publicKey){
        try {
            return RsaUtil.verify(requestBody,publicKey,sign);
        } catch (Exception e) {
            throw new RuntimeException("验签失败..");
        }
    }

}
