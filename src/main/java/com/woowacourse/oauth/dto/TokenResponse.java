package com.woowacourse.oauth.dto;

public class TokenResponse {

    private String token;

    private TokenResponse() {
    }

    public TokenResponse(final String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
