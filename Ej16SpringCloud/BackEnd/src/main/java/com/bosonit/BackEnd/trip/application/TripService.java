package com.bosonit.BackEnd.trip.application;

import com.bosonit.BackEnd.trip.infrastructure.controller.input.TripInputDto;
import com.bosonit.BackEnd.trip.infrastructure.controller.output.TripOutDto;

import java.util.List;

public interface TripService {

    public TripOutDto addTrip(TripInputDto inputDto) throws Exception;

    public TripOutDto addPassengerToTrip(String tripId, String customerId);

    public List<TripOutDto> getAllTrips();

    public TripOutDto getTripById(String id) throws Exception;

    public Integer getTotalPassengers(String idTrip) throws Exception;

    public Boolean getTravelStatus(String idTrip) throws Exception;

    public TripOutDto updateTrip(TripInputDto tripInputDto, String idTrip) throws Exception;

    public TripOutDto changeTripStatus(String idTrip, Boolean newStatus) throws Exception;

    public Boolean deleteTrip(String idTrip) throws Exception;


}
