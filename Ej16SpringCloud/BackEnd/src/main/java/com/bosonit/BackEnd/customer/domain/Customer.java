package com.bosonit.BackEnd.customer.domain;


import com.bosonit.BackEnd.customer.infrastructure.controller.input.CustomerInputDto;
import com.bosonit.BackEnd.trip.domain.Trip;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CustomerTable")
    private Long idCustomer;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private Integer age;

    @Column (unique = true, nullable = false)
    private String email;

    @Column
    private Integer movilNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="travel_id")
    private Trip travel;

    public Customer (CustomerInputDto customerInputDto){
        setName(customerInputDto.getName());
        setSurname(customerInputDto.getSurname());
        setAge(customerInputDto.getAge());
        setEmail(customerInputDto.getEmail());
        setMovilNumber(customerInputDto.getMovilNumber());
    }

    public Customer (CustomerInputDto customerInputDto, Long idCustomer){
        setIdCustomer(idCustomer);
        setName(customerInputDto.getName());
        setSurname(customerInputDto.getSurname());
        setAge(customerInputDto.getAge());
        setEmail(customerInputDto.getEmail());
        setMovilNumber(customerInputDto.getMovilNumber());
    }
}
