package com.cargotrasportation.loading;

import com.cargotrasportation.cargo.Cargo;
import com.cargotrasportation.cargo.CargoRepository;
import com.cargotrasportation.common.CantTransportGasOnAirplaneException;
import com.cargotrasportation.transport.Transport;
import com.cargotrasportation.transport.TransportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class LoadingServiceImpl implements LoadingService {
    private LoadingRepository loadingRepository;
    private TransportRepository transportRepository;
    private CargoRepository cargoRepository;

    @Override
    public Loading addLoading(long userId, Loading loading, long cargoId, long transportId) {
        // проверить наличие в БД пользователя, груза, транспорта
        Cargo cargo = cargoRepository.findById(cargoId).get();
        Transport transport = transportRepository.findById(transportId).get();
        if (!transport.getPermittedCargoTypes().contains(cargo.getType())) {
            throw new CantTransportGasOnAirplaneException("Нельзя газ перевозить в самолете!");
        }
        return loadingRepository.save(loading);
    }
}
