package com.transport;

import com.transport.model.Bus;
import com.transport.repository.BusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BusTrackingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusTrackingApplication.class, args);
    }

    @Bean
    public CommandLineRunner seedData(BusRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Bus("Bus 1", 13.4549, -16.5790));
                repo.save(new Bus("Bus 2", 13.4600, -16.5700));
                repo.save(new Bus("Bus 3", 13.4500, -16.5850));
            }
        };
    }
}


