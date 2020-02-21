package com.daiban.oauth.controller;

import com.daiban.entiy.Result;
import com.daiban.entiy.StatusCode;
import com.daiban.oauth.service.AuthService;
import com.daiban.oauth.util.AuthToken;
import com.daiban.oauth.util.CookieUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/oauth")
public class AuthController {

    @Autowired
//    @Resource
    private AuthService authService;

    @Value("${auth.clientId}")
    private String clientId;

    @Value("${auth.clientSecret}")
    private String clientSecret;

    @Value("${auth.cookieDomain}")
    private String cookieDomain;

    @Value("${auth.cookieMaxAge}")
    private int cookieMaxAge;

    @RequestMapping("/toLogin")
    public String toLogin(@RequestParam(value = "FROM",required = false,defaultValue = "") String from, Model model){
        model.addAttribute("from",from);
        return "login";
    }


    /**
     * 用户名密码登录
     * @param username
     * @param password
     * @param response
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Result login(String username, String password, HttpServletResponse response){
        //校验参数
        if (StringUtils.isEmpty(username)){
            throw new RuntimeException("请输入用户名");
        }
        if (StringUtils.isEmpty(password)){
            throw new RuntimeException("请输入密码");
        }
        //申请令牌 authtoken
        AuthToken authToken = authService.login(username, password, clientId, clientSecret);

        //将jti的值存入cookie中
        this.saveJtiToCookie(authToken.getJti(),response);

        //返回结果
        return new Result(true, StatusCode.OK,"登录成功",authToken.getJti());
    }

    //将令牌的断标识jti存入到cookie中
    private void saveJtiToCookie(String jti, HttpServletResponse response) {
        CookieUtil.addCookie(response,cookieDomain,"/","uid",jti,cookieMaxAge,false);
    }

    /**
     * 手机号登录
     */


    /**
     * 第三方微信账号登录
     */
}
