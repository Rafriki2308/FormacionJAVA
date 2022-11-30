package com.bosonit.Ej16.BackEnd.customer.application;

import com.bosonit.Ej16.BackEnd.customer.domain.Customer;
import com.bosonit.Ej16.BackEnd.customer.infrastructure.controller.input.CustomerInputDto;
import com.bosonit.Ej16.BackEnd.customer.infrastructure.controller.output.CustomerOutDto;
import com.bosonit.Ej16.BackEnd.customer.infrastructure.controller.output.CustomerOutDtoResponse;
import com.bosonit.Ej16.BackEnd.customer.infrastructure.repository.CustomerRepository;
import com.bosonit.Ej16.BackEnd.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private final CustomerRepository customerRepo;

    @Autowired
    private final CustomerOutDtoResponse customerOutDtoRes;

    @Override
    public CustomerOutDto addCustomer(CustomerInputDto customerInputDto){
        return new CustomerOutDto(customerRepo.save(new Customer(customerInputDto)));
    }

    @Override
    public CustomerOutDto getCustomerById(String id) throws EntityNotFoundException {
        if(customerRepo.existsById(Long.parseLong(id))) {
            return new CustomerOutDto(customerRepo.getReferenceById(Long.parseLong(id)));
        }
        throw new EntityNotFoundException("Customer doesn't exists");
    }

    @Override
    public List<CustomerOutDto> getAllCustomers() {
        return customerOutDtoRes.mappingCustomerToCustomerOutDto(customerRepo.findAll());
    }

    @Override
    public boolean deleteCustomerById(String id) throws EntityNotFoundException{

        if(customerRepo.existsById(Long.parseLong(id))) {
            customerRepo.deleteById(Long.parseLong(id));
            return true;
        }
        throw new EntityNotFoundException("Customer doesn't exists");
    }

    @Override
    public CustomerOutDto updateCustomer(CustomerInputDto customerInputDto, String id) throws EntityNotFoundException {

        if(customerRepo.existsById(Long.parseLong(id))) {

            return new CustomerOutDto(customerRepo.save(new Customer(customerInputDto, Long.parseLong(id))));
        }
        throw new EntityNotFoundException("Customer doesn't exists");
    }
}
