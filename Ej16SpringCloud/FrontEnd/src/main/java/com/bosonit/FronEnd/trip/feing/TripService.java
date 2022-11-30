package com.bosonit.FronEnd.trip.feing;


import com.bosonit.FronEnd.trip.infrastructure.output.TripOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name="trip-frontend", url = "http://localhost:8081")
public interface TripService {

    @GetMapping("trip/getById/{id}")
    public TripOutDto findById(@PathVariable String id);

    @PutMapping("trip/addPassenger/{idTrip}/{idPassenger}")
    public void addPassengerToTrip(@PathVariable String idTrip, @PathVariable String idPassenger);

}
