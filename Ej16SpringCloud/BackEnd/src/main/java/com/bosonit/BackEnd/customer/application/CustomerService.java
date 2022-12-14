package com.bosonit.BackEnd.customer.application;

import com.bosonit.BackEnd.customer.infrastructure.controller.output.CustomerOutDto;
import com.bosonit.BackEnd.customer.infrastructure.controller.input.CustomerInputDto;
import com.bosonit.BackEnd.exceptions.EntityNotFoundException;

import java.util.List;

public interface CustomerService {

    public CustomerOutDto addCustomer(CustomerInputDto customerInputDto)throws Exception;

    public CustomerOutDto getCustomerById(String id) throws EntityNotFoundException;

    public List<CustomerOutDto> getAllCustomers();

    public boolean deleteCustomerById(String id) throws Exception;

    public CustomerOutDto updateCustomer(CustomerInputDto customerInputDto, String id) throws Exception;

}
