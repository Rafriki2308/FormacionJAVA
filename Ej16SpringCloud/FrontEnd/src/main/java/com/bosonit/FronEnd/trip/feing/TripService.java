package com.bosonit.FronEnd.trip.feing;


import com.bosonit.FronEnd.trip.infrastructure.output.TripOutDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name="trip-frontend", url = "${my.direction.feing}") //url toma el valor de una linea de application propertie
public interface TripService {

    @GetMapping("trip/getByIdByFeing/{id}")
    public TripOutDto findById(@PathVariable String id);

    @PutMapping("trip/addPassenger/{idTrip}/{idPassenger}")
    public void addPassengerToTrip(@PathVariable String idTrip, @PathVariable String idPassenger);

}
