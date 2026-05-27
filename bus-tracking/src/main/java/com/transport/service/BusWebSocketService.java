package com.transport.service;

import com.transport.dto.BusUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class BusWebSocketService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void sendBusUpdate(BusUpdateDTO update) {
        messagingTemplate.convertAndSend("/topic/buses", update);
    }
}