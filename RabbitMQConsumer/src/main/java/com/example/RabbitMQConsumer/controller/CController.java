package com.example.RabbitMQConsumer.controller;

import com.example.RabbitMQConsumer.service.MessageConsumer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CController {

    private final MessageConsumer messageConsumer;


    public CController(MessageConsumer messageConsumer) {
        this.messageConsumer = messageConsumer;
    }

    @GetMapping("/consume")
    public ResponseEntity<List<String>> consumeMessage() {
//        messageConsumer.listenMessage("Received");
        return ResponseEntity.ok(messageConsumer.getMessagesList());
    }
}
