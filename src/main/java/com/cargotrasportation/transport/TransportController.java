package com.cargotrasportation.transport;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/transport")
@Slf4j
@RequiredArgsConstructor
public class TransportController {
    private final TransportService transportService;

    @PostMapping
    public Transport add(@RequestBody Transport transport) {
        log.info("POST-запрос на создание транспорта {}", transport);
        return transportService.add(transport);
    }
}
