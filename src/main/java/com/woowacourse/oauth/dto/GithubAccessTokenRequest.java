package com.woowacourse.oauth.dto;

public class GithubAccessTokenRequest {

    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_url;

    private GithubAccessTokenRequest() {
    }

    public GithubAccessTokenRequest(final String client_id, final String client_secret, final String code,
                                    final String redirect_url) {
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.code = code;
        this.redirect_url = redirect_url;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public String getCode() {
        return code;
    }

    public String getRedirect_url() {
        return redirect_url;
    }
}
