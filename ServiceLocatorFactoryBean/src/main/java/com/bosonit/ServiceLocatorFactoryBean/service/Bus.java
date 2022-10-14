package com.bosonit.ServiceLocatorFactoryBean.service;

import com.bosonit.ServiceLocatorFactoryBean.model.Vehicle;
import org.springframework.stereotype.Service;

@Service("Bus")
public class BusService  implements AdapterService<Vehicle>{

    @Override
    public void process(Vehicle request){
        System.out.println("This is a service for buses - " + request.toString());
    }


}
