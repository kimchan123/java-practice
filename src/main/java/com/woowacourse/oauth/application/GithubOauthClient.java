package com.woowacourse.oauth.application;

import com.woowacourse.oauth.dto.GithubAccessTokenRequest;
import com.woowacourse.oauth.dto.GithubAccessTokenResponse;
import com.woowacourse.oauth.dto.GithubProfileResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GithubOauthClient {

    private final String clientId;
    private final String clientSecret;
    private final String tokenUrl;
    private final String profileUrl;
    private final RestTemplate restTemplate;

    public GithubOauthClient(@Value("${github.client.id}") final String clientId,
                             @Value("${github.client.secret}") final String clientSecret,
                             @Value("${github.url.token}") final String tokenUrl,
                             @Value("${github.url.profile}") final String profileUrl) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.tokenUrl = tokenUrl;
        this.profileUrl = profileUrl;
    }

    public String requestAccessToken(String code) {
        GithubAccessTokenRequest githubAccessTokenRequest = new GithubAccessTokenRequest(clientId, clientSecret, code,
                "http://localhost:3030");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity httpEntity = new HttpEntity(githubAccessTokenRequest, headers);

        RestTemplate restTemplate = new RestTemplate();
        GithubAccessTokenResponse githubAccessTokenResponse = restTemplate
                .exchange(tokenUrl, HttpMethod.POST, httpEntity, GithubAccessTokenResponse.class)
                .getBody();
        return githubAccessTokenResponse.getAccessToken();
    }

    public GithubProfileResponse requestGithubProfile(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);

        HttpEntity httpEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate
                .exchange(profileUrl, HttpMethod.GET, httpEntity, GithubProfileResponse.class)
                .getBody() ~;
    }
}
