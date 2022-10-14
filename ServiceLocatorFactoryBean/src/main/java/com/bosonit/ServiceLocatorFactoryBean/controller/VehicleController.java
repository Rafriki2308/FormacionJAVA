package com.bosonit.ServiceLocatorFactoryBean.controller;

import com.bosonit.ServiceLocatorFactoryBean.model.Vehicle;
import com.bosonit.ServiceLocatorFactoryBean.registry.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private ServiceRegistry serviceRegistry;

    @PostMapping
    public void processByTypeOfVehicle(@RequestBody Vehicle vehicle){
        serviceRegistry.getService(vehicle.getVehicleType()).process(vehicle);
    }
}
