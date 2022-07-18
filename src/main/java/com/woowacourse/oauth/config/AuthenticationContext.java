package com.woowacourse.oauth.config;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class AuthenticationContext {

    private String principal;

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(final String principal) {
        this.principal = principal;
    }
}
