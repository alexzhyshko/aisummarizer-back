package io.github.zhyshko.controller;

import io.github.zhyshko.exception.NotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1")
public class BaseController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundError(NotFoundException nfe) {
        return ResponseEntity.of(ProblemDetail
                .forStatusAndDetail(HttpStatusCode.valueOf(404), nfe.getMessage())).build();
    }

}
