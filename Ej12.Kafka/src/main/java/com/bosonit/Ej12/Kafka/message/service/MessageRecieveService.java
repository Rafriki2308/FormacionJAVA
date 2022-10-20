package com.bosonit.Ej12.Kafka.message.service;

import com.bosonit.Ej12.Kafka.event.Event;
import com.bosonit.Ej12.Kafka.event.MessageCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageRecieveService {

    @KafkaListener(
            topics = "${topic.message.name:messages}",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "grupo1")
    public void consumer(Event<?> event) {

        MessageCreatedEvent messageCreatedEvent = (MessageCreatedEvent) event;
        log.info("Received Message created event .... with author={}, text={}",
                messageCreatedEvent.getAuthor(),
                messageCreatedEvent.getText());
    }
}
