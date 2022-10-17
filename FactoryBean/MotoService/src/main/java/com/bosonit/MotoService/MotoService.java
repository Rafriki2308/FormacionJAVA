package com.bosonit.MotoService;
import org.springframework.stereotype.Service;

@Service("Moto")
public class MotoService  implements AdapterService<Vehicle> {

    @Override
    public void process(Vehicle request){
        System.out.println("This is a service for Motos - " + request.toString());
    }


}

