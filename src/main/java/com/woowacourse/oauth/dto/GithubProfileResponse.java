package com.woowacourse.oauth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GithubProfileResponse {

    private String name;
    private String login;
    @JsonProperty("id")
    private String githubId;
    @JsonProperty("avatar_url")
    private String imageUrl;

    public GithubProfileResponse() {
    }

    public GithubProfileResponse(final String name, final String login, final String githubId, final String imageUrl) {
        this.name = name;
        this.login = login;
        this.githubId = githubId;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getGithubId() {
        return githubId;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
