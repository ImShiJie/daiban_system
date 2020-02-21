package com.daiban.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

/**
 * @program: daiban_System
 * @description: 生成令牌与解析令牌工具类
 * @author: 施
 * @create: 2020-02-13 19:43
 **/

public class JwtUtil {

    //默认有效期
    public static final Long JWT_TTL = 3600000L; //60 * 60 *1000 一个小时

    //jwt令牌信息,就是秘钥
    public static final String JWT_KEY = "daiban";


    /**
     * 创建令牌
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJWT(String id,String subject,Long ttlMillis){
        //指定算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        //当前系统时间
        long nowMillis = System.currentTimeMillis();
        //令牌签发时间
        Date now = new Date(nowMillis);

        //如果令牌有效期为null，则默认设置有效期1小时
        if (ttlMillis == null){
            ttlMillis = JwtUtil.JWT_TTL;
        }

        //令牌过期时间设置
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);

        //生成秘钥
        SecretKey secretKey = generalKey();

        //封装jwt令牌信息
        JwtBuilder builder = Jwts.builder()
                .setId(id)                  //唯一的ID
                .setSubject(subject)        //主题 可以是JSON数据
                .setIssuer("admin")         //签发者
                .setIssuedAt(now)           //签发时间
                .signWith(signatureAlgorithm,secretKey) //签发算法以及秘钥
                .setExpiration(expDate);    //设置过期时间
        return builder.compact();
    }

    /**
     * 生成加密 SecretKey
     * @return
     */
    public static SecretKey generalKey(){
        byte[] encodeKey = Base64.getEncoder().encode(JwtUtil.JWT_KEY.getBytes());
        SecretKey key = new SecretKeySpec(encodeKey, 0, encodeKey.length, "AES");
        return key;
    }

    /**
     * 解析令牌数据
     * @param jwt
     * @return
     */
    public static Claims parseJWT(String jwt){
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
