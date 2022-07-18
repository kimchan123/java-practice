package com.woowacourse.oauth.presentation;

import com.woowacourse.oauth.application.JwtTokenProvider;
import com.woowacourse.oauth.config.AuthenticationContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class HostInterceptor implements HandlerInterceptor {

    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationContext authenticationContext;

    public HostInterceptor(final JwtTokenProvider jwtTokenProvider,
                           final AuthenticationContext authenticationContext) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationContext = authenticationContext;
    }

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
            throws Exception {
        if (CorsUtils.isPreFlightRequest(request)) {
            return true;
        }

        return false;
    }
}
