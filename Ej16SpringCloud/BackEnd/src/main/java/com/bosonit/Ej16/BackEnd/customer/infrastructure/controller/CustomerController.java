package com.bosonit.Ej16.BackEnd.customer.infrastructure.controller;

import com.bosonit.Ej16.BackEnd.customer.application.CustomerServiceImp;
import com.bosonit.Ej16.BackEnd.customer.infrastructure.controller.input.CustomerInputDto;
import com.bosonit.Ej16.BackEnd.customer.infrastructure.controller.output.CustomerOutDto;
import com.bosonit.Ej16.BackEnd.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImp customerImp;

    @PostMapping("")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerInputDto customerInputDto) {
        try {
            CustomerOutDto customerOutDto = customerImp.addCustomer(customerInputDto);
            return new ResponseEntity<>(customerOutDto, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("Email already existed");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerOutDto>> getAllCustomers(){
        return new ResponseEntity<>(customerImp.getAllCustomers(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable String id){
        try {
            return new ResponseEntity<>(customerImp.getCustomerById(id),HttpStatus.FOUND);
        }catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body("Customer doesn't exists");
        }
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<?> updateCustomerById(@RequestBody CustomerInputDto customerInputDto
            ,@PathVariable String id ){
        try {
            return new ResponseEntity<>(customerImp.updateCustomer(customerInputDto,id), HttpStatus.CREATED);
        }catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body("Customer doesn't exists");
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable String id){
        try {
            if(customerImp.deleteCustomerById(id)){
               return ResponseEntity.ok().body("Customer has been deleted");
            }
        }catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body("Customer doesn't exists");
        }
        return ResponseEntity.badRequest().body("Customer doesn't exists");
    }
}
