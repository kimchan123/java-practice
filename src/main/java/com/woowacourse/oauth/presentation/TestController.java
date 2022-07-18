package com.woowacourse.oauth.presentation;

import com.woowacourse.oauth.config.HostOnly;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @HostOnly
    @PutMapping("/api/guest")
    public ResponseEntity<Void> guest() {
        return ResponseEntity.ok().build();
    }

    @HostOnly
    @GetMapping("/api/host")
    public ResponseEntity<Void> host() {
        return ResponseEntity.ok().build();
    }

    @HostOnly
    @GetMapping("/api/guest1")
    public ResponseEntity<Void> guest1() {
        return ResponseEntity.ok().build();
    }

    @HostOnly
    @GetMapping("/api/host1")
    public ResponseEntity<Void> host1() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/nothing")
    public ResponseEntity<Void> host2() {
        return ResponseEntity.ok().build();

    }
}
