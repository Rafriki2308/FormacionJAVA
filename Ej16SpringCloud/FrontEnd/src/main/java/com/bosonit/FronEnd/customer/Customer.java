package com.bosonit.FronEnd.customer;




import FrontEnd.trip.Trip;
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

}
