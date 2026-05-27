package com.transport.service;

import com.transport.model.Bus;
import com.transport.repository.BusRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class GpsSimulationService {

    private final BusRepository repository;

    public GpsSimulationService(BusRepository repository) {
        this.repository = repository;
    }

    @Scheduled(fixedRate = 5000)
    public void simulateMovement() {

        List<Bus> buses = repository.findAll();

        Random random = new Random();

        for (Bus bus : buses) {

            bus.setLatitude(
                bus.getLatitude() +
                (random.nextDouble() - 0.5) / 1000
            );

            bus.setLongitude(
                bus.getLongitude() +
                (random.nextDouble() - 0.5) / 1000
            );

            repository.save(bus);
        }
    }
}