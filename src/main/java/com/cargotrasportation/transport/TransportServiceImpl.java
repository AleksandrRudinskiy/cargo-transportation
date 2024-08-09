package com.cargotrasportation.transport;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransportServiceImpl implements TransportService {
    private final TransportRepository transportRepository;

    @Override
    public Transport add(Transport transport) {
        if (transport.getType() == 1) {
            transport.setPermittedCargoTypes(List.of(2, 3));
        } else {
            transport.setPermittedCargoTypes(List.of(1, 2, 3));
        }
        return transportRepository.save(transport);
    }
}
