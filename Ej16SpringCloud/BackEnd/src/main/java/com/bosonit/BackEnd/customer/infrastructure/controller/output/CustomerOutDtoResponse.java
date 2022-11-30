package com.bosonit.BackEnd.customer.infrastructure.controller.output;

import com.bosonit.BackEnd.customer.domain.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerOutDtoResponse {

    public static List<CustomerOutDto> mappingCustomerToCustomerOutDto(List<Customer> customers){
        List<CustomerOutDto> customerOutDtoList = new ArrayList<>();

        for (Customer c: customers) {
            customerOutDtoList.add(new CustomerOutDto(c));
        }
        return customerOutDtoList;
    }
}
