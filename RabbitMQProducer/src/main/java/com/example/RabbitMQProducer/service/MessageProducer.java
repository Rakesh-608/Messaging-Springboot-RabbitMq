package com.example.RabbitMQProducer.service;

import com.example.RabbitMQProducer.config.RabbitMQConfig;
import com.example.RabbitMQProducer.dto.MessageDto;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MessageProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Queue queue;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME, messageConverter = "receiverJackson2MessageConverter")
    public void sendMessage(MessageDto message) {
        rabbitTemplate.convertAndSend(queue.getName(), message);
        System.out.println("Sent message: " + message);
    }
}
