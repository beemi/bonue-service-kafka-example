package com.jaitechltd.bonus.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
@Slf4j
public class ControllerErrorAdvice {

    @ExceptionHandler(DuplicateBonusException.class)
    public ResponseEntity<?> handle(final DuplicateBonusException e) {
        log.error("Duplicate bonus -", e);
        return ResponseEntity.badRequest().body(new ErrorResponse(List.of(e.getMessage())));
    }

    public record ErrorResponse(List<String> errors) {
    }
}
