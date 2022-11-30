package FrontEnd.trip;

import FrontEnd.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {


    private Long idTravel;

    private String origin;

    private String destination;

    private Date departureDate;

    private Date arrivalDate;

    List<Customer> passengers = new ArrayList<>();

    private Boolean status;

}
