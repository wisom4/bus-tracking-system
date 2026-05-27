package com.transport.controller;

import com.transport.model.BusLocation;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class BusLocationController {

    @MessageMapping("/bus.update")   // /app/bus.update
    @SendTo("/topic/bus-location")   // frontend subscribes here
    public BusLocation sendLocation(BusLocation location) {
        return location; // broadcast to all clients
    }
}