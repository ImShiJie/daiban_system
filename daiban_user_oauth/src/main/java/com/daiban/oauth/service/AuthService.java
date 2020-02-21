package com.daiban.oauth.service;


import com.daiban.oauth.util.AuthToken;

public interface AuthService {

    AuthToken login(String username, String password, String clientId, String clientSecret);
}
