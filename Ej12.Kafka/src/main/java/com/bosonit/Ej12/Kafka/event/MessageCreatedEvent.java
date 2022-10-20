package com.bosonit.Ej12.Kafka.event;

import com.bosonit.Ej12.Kafka.message.domain.Message;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MessageCreatedEvent extends Event<Message> {

}
