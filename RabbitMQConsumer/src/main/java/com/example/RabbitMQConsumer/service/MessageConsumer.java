package com.example.RabbitMQConsumer.service;

import com.example.RabbitMQConsumer.config.RabbitMQConfig;
import com.example.RabbitMQConsumer.dto.MessageDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageConsumer {

    private List<String> messagesList=new ArrayList<>();

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME, messageConverter = "receiverJackson2MessageConverter")
    public void listenMessage(MessageDto dto) {
//        System.out.println("Received message: " + message);
        messagesList.add(dto.message());
    }

    public List<String> getMessagesList() {
        return messagesList;
    }
}
