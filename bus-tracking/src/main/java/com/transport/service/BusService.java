package com.transport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.dto.BusUpdateDTO;
import com.transport.model.Bus;
import com.transport.repository.BusRepository;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private BusWebSocketService webSocketService;

    public void updateBus(BusUpdateDTO dto) {

        Bus bus = busRepository.findByNumberPlate(dto.getNumberPlate())
                .orElseThrow(() -> new RuntimeException("Bus not found: " + dto.getNumberPlate()));

        bus.setLatitude(dto.getLatitude());
        bus.setLongitude(dto.getLongitude());
        bus.setSpeed(dto.getSpeed());
        bus.setStatus(dto.getStatus());

        busRepository.save(bus);

        webSocketService.sendBusUpdate(dto);
    }
}