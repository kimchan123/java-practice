package com.woowacourse.oauth.presentation;

import com.woowacourse.oauth.application.OauthService;
import com.woowacourse.oauth.dto.TokenRequest;
import com.woowacourse.oauth.dto.TokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OauthController {

    private final OauthService oauthService;

    public OauthController(final OauthService oauthService) {
        this.oauthService = oauthService;
    }

    @PostMapping("/api/login")
    public ResponseEntity<TokenResponse> login(@RequestBody final TokenRequest tokenRequest) {
        return ResponseEntity.ok(oauthService.createToken(tokenRequest));
    }
}
