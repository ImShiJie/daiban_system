package com.daiban;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;

/**
 * @program: daiban_System
 * @description:
 * @author: 施
 * @create: 2020-02-13 17:34
 **/

public class JjwtTest {

    /**
     * 创建令牌
     */
    @Test
    public void testCreateToken() {

        //自定义载荷
        HashMap<String,Object> userInfo = new HashMap<>();
        userInfo.put("hello","你好");
        userInfo.put("world","世界");

        //构建Jwt令牌的对象
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("888")               //设置唯一编号
                .setIssuer("黑马训练营")    //颁发者
                .setIssuedAt(new Date())    //颁发时间
                .setExpiration(new Date(System.currentTimeMillis()+60000))  //过期时间设置
                .addClaims(userInfo)        //添加自定义载荷
                .setSubject("JWT令牌测试")  //主题信息
                .signWith(SignatureAlgorithm.HS256,"itcast");//1、签名算法  2、秘钥(盐)
        String compact = jwtBuilder.compact();//获取令牌信息
        System.out.println(compact);
    }

    @Test
    public void parseToken(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJpc3MiOiLpu5Hpqazorq3nu4PokKUiLCJpYXQiOjE1ODE1OTIyMjMsImV4cCI6MTU4MTU5MjI4Mywid29ybGQiOiLkuJbnlYwiLCJoZWxsbyI6IuS9oOWlvSIsInN1YiI6IkpXVOS7pOeJjOa1i-ivlSJ9.yPXl-9Jbq2h19of4UtVQMmoWIfQ89YRikDsRxpDzItE";
        Claims itcast = Jwts.parser()
                .setSigningKey("itcast")  //秘钥(盐)
                .parseClaimsJws(token)    //要解析的令牌对象
                .getBody();//获取解析后的数据
        System.out.println(itcast);
    }

}
