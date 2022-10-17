package com.bosonit.ServiceLocatorFactoryBean.service;

import com.bosonit.ServiceLocatorFactoryBean.model.Vehicle;
import com.bosonit.ServiceLocatorFactoryBean.registry.AdapterService;
import org.springframework.stereotype.Service;

@Service("Car")
public class CarService  implements AdapterService<Vehicle> {

    @Override
    public void process(Vehicle request){
        System.out.println("This is a service for cars - " + request.toString());
    }


}
