package com.bosonit.Ej12.Kafka.event;

import lombok.Data;

@Data
public abstract class Event<T> {

    private String author;
    private String text;


}
