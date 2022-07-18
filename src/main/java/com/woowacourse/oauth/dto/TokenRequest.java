package com.woowacourse.oauth.dto;

public class TokenRequest {

    private String code;
    private String spacePassword;
    private String slackUrl;

    private TokenRequest() {
    }

    public TokenRequest(final String code, final String spacePassword, final String slackUrl) {
        this.code = code;
        this.spacePassword = spacePassword;
        this.slackUrl = slackUrl;
    }

    public String getCode() {
        return code;
    }

    public String getSpacePassword() {
        return spacePassword;
    }

    public String getSlackUrl() {
        return slackUrl;
    }
}
