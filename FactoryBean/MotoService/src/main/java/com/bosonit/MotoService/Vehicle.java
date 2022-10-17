package com.bosonit.MotoService;

import lombok.Data;

import java.io.Serializable;

@Data
public class Vehicle implements Serializable {

    private String vehicleName;
    private String vehicleType;


    @Override
    public String toString(){
        return "Vehicle [vehicleName=" + vehicleName + " , vehicleType=" + vehicleType + "]";
    }

}
