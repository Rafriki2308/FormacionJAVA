package com.bosonit.Ej12.Kafka.message.infraestructure.controller;

import com.bosonit.Ej12.Kafka.message.domain.Message;
import com.bosonit.Ej12.Kafka.message.service.MessageSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    MessageSendService messageService;

    @PostMapping
    public void send(@RequestBody Message message) {
        messageService.send(message);
    }
}
