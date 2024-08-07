package com.cargotrasportation.cargo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CargoServiceImpl implements CargoService {
    private CargoRepository cargoRepository;

    @Override
    public Cargo addCargo(Cargo cargo) {
        return cargoRepository.save(cargo);
    }
}
