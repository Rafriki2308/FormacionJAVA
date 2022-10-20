package com.bosonit.Ej12.Kafka.message.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Message {

    private String author;
    private String text;
}
