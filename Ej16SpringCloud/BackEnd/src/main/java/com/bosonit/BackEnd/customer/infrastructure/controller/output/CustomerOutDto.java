package com.bosonit.BackEnd.customer.infrastructure.controller.output;

import com.bosonit.BackEnd.customer.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerOutDto {

    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private Integer movilNumber;


    public CustomerOutDto(Customer customer){
        setId(customer.getIdCustomer());
        setName(customer.getName());
        setSurname(customer.getSurname());
        setAge(customer.getAge());
        setEmail(customer.getEmail());
        setMovilNumber(customer.getMovilNumber());
    }
}
