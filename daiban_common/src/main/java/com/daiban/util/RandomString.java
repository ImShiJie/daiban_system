package com.daiban.util;

import java.util.Random;

/**
 * @program: daiban_System
 * @description: 生产随机字符串工具类
 * @author: 施
 * @create: 2020-02-13 14:57
 **/

public class RandomString {


    /**
     * @Description:    生产32位随机字符串
     * @Author:         vdi100
     * @CreateDate:     2019/4/23 14:47
     * @Version:        1.0
     */
    public static String getNum() {
        char[] chars = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        String nums = "";
        for(int i = 0; i < 32; i++){
            double id = Math.random()*36;
            int n = (int) id;
            nums += chars[n];
        }
        return nums;
    }
    /**
     * @Description:    生产指定位数随机字符串
     * @Author:         vdi100
     * @CreateDate:     2019/4/26 13:48
     * @Version:        1.0
     */
    public static String getRandomString(int length){
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < length; i++){
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
    /**
     * @Description:    生产指定位数随机字符串
     * @Author:         vdi100
     * @CreateDate:     2019/4/26 14:03
     * @Version:        1.0
     */
    public static String getRandomStr(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(3);// 随机生产小于3的数
            long result = 0;
            switch (number) {
                case 0:
                    result = Math.round(Math.random() * 25 + 65);
                    sb.append(String.valueOf((char) result));
                    break;
                case 1:
                    result = Math.round(Math.random() * 25 + 97);
                    sb.append(String.valueOf((char) result));
                    break;
                case 2:
                    sb.append(String.valueOf(new Random().nextInt(10)));
                    break;
            }
        }
        return sb.toString();

    }
}
