package com.woowacourse.oauth.application;

import com.woowacourse.oauth.dto.GithubProfileResponse;
import com.woowacourse.oauth.dto.TokenRequest;
import com.woowacourse.oauth.dto.TokenResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class OauthService {

    private final JwtTokenProvider jwtTokenProvider;
    private final GithubOauthClient githubOauthClient;

    public OauthService(final JwtTokenProvider jwtTokenProvider,
                        final GithubOauthClient githubOauthClient) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.githubOauthClient = githubOauthClient;
    }

    public TokenResponse createToken(final TokenRequest tokenRequest) {
        String accessToken = githubOauthClient.requestAccessToken(tokenRequest.getCode());
        GithubProfileResponse githubProfileResponse = githubOauthClient.requestGithubProfile(accessToken);
        String token = jwtTokenProvider.createToken(githubProfileResponse.getGithubId());
        return new TokenResponse(token);
    }
}

