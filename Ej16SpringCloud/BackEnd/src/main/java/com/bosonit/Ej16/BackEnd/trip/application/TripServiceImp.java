package com.bosonit.Ej16.BackEnd.trip.application;

import com.bosonit.Ej16.BackEnd.customer.domain.Customer;
import com.bosonit.Ej16.BackEnd.customer.infrastructure.repository.CustomerRepository;
import com.bosonit.Ej16.BackEnd.exceptions.EntityNotFoundException;
import com.bosonit.Ej16.BackEnd.exceptions.TripFullPeopleException;
import com.bosonit.Ej16.BackEnd.trip.domain.Trip;
import com.bosonit.Ej16.BackEnd.trip.infrastructure.controller.input.TripInputDto;
import com.bosonit.Ej16.BackEnd.trip.infrastructure.controller.output.TripOutDto;
import com.bosonit.Ej16.BackEnd.trip.infrastructure.controller.output.TripOutDtoResponse;
import com.bosonit.Ej16.BackEnd.trip.infrastructure.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImp implements TripService{

    @Autowired
    private TripRepository tRepository;

    @Autowired
    private CustomerRepository cRepository;

    @Autowired
    private TripOutDtoResponse tripResponse;

    @Override
    public TripOutDto addTrip(TripInputDto inputDto) throws Exception {
        return new TripOutDto(tRepository.save(new Trip(inputDto)));
    }

    @Override
    public TripOutDto addPassengerToTrip(String tripId, String customerId) throws EntityNotFoundException
            ,TripFullPeopleException {
        Long idCustomer = Long.parseLong(customerId);
        Long idTrip = Long.parseLong(tripId);

        if(tRepository.getReferenceById(idTrip).getPassengers().size()>40){
            throw new TripFullPeopleException("Trip is full o people");
        }

        if(cRepository.existsById(idCustomer) && tRepository.existsById(idTrip)){
            Customer customer = cRepository.getReferenceById(idCustomer);
            Trip trip = tRepository.getReferenceById(idTrip);

            customer.setTravel(trip);
            cRepository.save(customer);
            trip.setPassenger(customer);

            return new TripOutDto(tRepository.save(trip));
        }
        throw new EntityNotFoundException("Trip or Customer doesn't exits");
    }

    @Override
    public List<TripOutDto> getAllTrips() {
        return tripResponse.mappingTipToTripOutDto(tRepository.findAll());
    }

    @Override
    public TripOutDto getTripById(String id) throws EntityNotFoundException {
        if(tRepository.existsById(Long.parseLong(id))){
            return new TripOutDto(tRepository.getReferenceById(Long.parseLong(id)));
        }
        throw new EntityNotFoundException("Trip with id: " + id + "doesn't exist");
    }

    @Override
    public Integer getTotalPassengers(String id) throws EntityNotFoundException{
        if(tRepository.existsById(Long.parseLong(id))){
            return tRepository.getReferenceById(Long.parseLong(id)).getPassengers().size();
        }
        throw new EntityNotFoundException("Trip with id: " + id + "doesn't exist");
    }

    @Override
    public Boolean getTravelStatus(String id) throws EntityNotFoundException {
        if(tRepository.existsById(Long.parseLong(id))){
            return tRepository.getReferenceById(Long.parseLong(id)).getStatus();
        }
        throw new EntityNotFoundException("Trip with id: " + id + "doesn't exist");
    }

    @Override
    public TripOutDto updateTrip(TripInputDto tripInputDto, String id) throws EntityNotFoundException {
        if(tRepository.existsById(Long.parseLong(id))){
            Trip trip = new Trip(tripInputDto, Long.parseLong(id));
            return new TripOutDto(tRepository.save(trip));
        }
        throw new EntityNotFoundException("Trip with id: " + id + "doesn't exist");
    }

    @Override
    public TripOutDto changeTripStatus(String id, Boolean newStatus) throws EntityNotFoundException {

        if(tRepository.existsById(Long.parseLong(id))){
            Trip trip = tRepository.getReferenceById(Long.parseLong(id));
            trip.setStatus(newStatus);

            return new TripOutDto(tRepository.save(trip));
        }
        throw new EntityNotFoundException("Trip with id: " + id + "doesn't exist");
    }

    @Override
    public Boolean deleteTrip(String id) throws EntityNotFoundException {
        if(tRepository.existsById(Long.parseLong(id))){
            tRepository.deleteById(Long.parseLong(id));
            return true;
        }
        throw new EntityNotFoundException("Trip with id: " + id + "doesn't exist");
    }


}
