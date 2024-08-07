package com.cargotrasportation.common;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(CantTransportGasOnAirplaneException.class)
    public ResponseEntity<Map<String, String>> handleCantTransportGasOnAirplaneException(
            final CantTransportGasOnAirplaneException e) {
        log.error("409 Ошибка валидации: {}", e.getMessage());
        return new ResponseEntity<>(
                Map.of("error", "Нельзя газ перевозить самолетами!",
                        "errorMessage", e.getMessage()),
                HttpStatus.CONFLICT
        );
    }
}