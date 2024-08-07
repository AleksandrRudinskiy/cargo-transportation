package com.cargotrasportation.cargo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cargos")
@Slf4j
@RequiredArgsConstructor
public class CargoController {
    private CargoService cargoService;
    @PostMapping
    public Cargo add(@RequestHeader(value = "User-Id") long userId,
                              @RequestBody Cargo cargo) {
        log.info("POST-запрос на создание груза {}", cargo);
        return cargoService.addCargo(cargo);
    }
}
