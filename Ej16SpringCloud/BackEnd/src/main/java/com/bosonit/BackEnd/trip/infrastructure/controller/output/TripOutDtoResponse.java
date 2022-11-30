package com.bosonit.BackEnd.trip.infrastructure.controller.output;

import com.bosonit.BackEnd.trip.domain.Trip;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TripOutDtoResponse {

    public static List<TripOutDto> mappingTipToTripOutDto(List<Trip> trips){
        List<TripOutDto> tripOutDtos = new ArrayList<>();

        for (Trip t: trips) {
            tripOutDtos.add(new TripOutDto(t));
        }
        return tripOutDtos;
    }
}
