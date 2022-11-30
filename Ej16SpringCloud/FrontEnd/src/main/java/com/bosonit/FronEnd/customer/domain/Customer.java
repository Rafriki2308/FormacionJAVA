package com.bosonit.FronEnd.customer.domain;




import com.bosonit.FronEnd.trip.domain.Trip;
import com.bosonit.FronEnd.customer.infrastructure.output.CustomerOutDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {


    private Long idCustomer;

    private String name;

    private String surname;

    private Integer age;

    private String email;

    private Integer movilNumber;

    private Trip travel;

    public Customer(CustomerOutDto customerOutDto){
        setIdCustomer(customerOutDto.getId());
        setName(customerOutDto.getName());
        setSurname(customerOutDto.getSurname());
        setEmail(customerOutDto.getEmail());
        setMovilNumber(customerOutDto.getMovilNumber());
    }

}
