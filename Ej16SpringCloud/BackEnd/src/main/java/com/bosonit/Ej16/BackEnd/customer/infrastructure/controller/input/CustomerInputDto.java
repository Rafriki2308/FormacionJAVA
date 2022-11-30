package com.bosonit.Ej16.BackEnd.customer.infrastructure.controller.input;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerInputDto {

    private String name;
    private String surname;
    private Integer age;
    private String email;
    private Integer movilNumber;
}
