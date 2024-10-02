package io.github.zhyshko.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping
    public ResponseEntity<String> welcome(@RequestParam(value = "name") String name) {
        return ResponseEntity.ofNullable("Hello, "+name);
    }

}
