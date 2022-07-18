package com.woowacourse.oauth.application;

public interface JwtTokenProvider {

    String createToken(final String subject);

    String extractSubject(final String token);
}
