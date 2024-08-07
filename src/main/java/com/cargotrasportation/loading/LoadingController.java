package com.cargotrasportation.loading;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/loading")
@Slf4j
@RequiredArgsConstructor
public class LoadingController {
    private final LoadingService loadingService;
    @PostMapping
    public Loading add(@RequestHeader(value = "User-Id") long userId,
                       @RequestParam long cargoId,
                       @RequestParam long transportId,
                       @RequestBody Loading loading) {
        log.info("POST-запрос на создание погрузки от пользователя {}" +
                " из груза {} на транспорте {}", userId, cargoId, transportId);
        return loadingService.addLoading(userId, loading, cargoId, transportId);
    }
}

