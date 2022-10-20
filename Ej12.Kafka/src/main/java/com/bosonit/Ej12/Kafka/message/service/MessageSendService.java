package com.bosonit.Ej12.Kafka.message.service;

import com.bosonit.Ej12.Kafka.event.Event;
import com.bosonit.Ej12.Kafka.event.MessageCreatedEvent;
import com.bosonit.Ej12.Kafka.message.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageSendService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.message.name:messages}")
    private String topicMessage;

    public void send(Message message) {

        MessageCreatedEvent created = new MessageCreatedEvent();
        created.setAuthor(message.getAuthor());
        created.setText(message.getText());

        log.info("You´ve already uploaded a message in BD .... with author={}, text={}",
                created.getAuthor(),
                created.getText());


        this.producer.send(topicMessage, created);
    }
}
