package com.cargotrasportation.common;

public class CantTransportGasOnAirplaneException extends RuntimeException {
    public CantTransportGasOnAirplaneException(String message) {
        super(message);
    }
}
