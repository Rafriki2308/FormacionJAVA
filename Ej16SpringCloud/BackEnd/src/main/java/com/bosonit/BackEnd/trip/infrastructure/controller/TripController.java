package com.bosonit.BackEnd.trip.infrastructure.controller;

import com.bosonit.BackEnd.exceptions.TripFullPeopleException;
import com.bosonit.BackEnd.trip.application.TripServiceImp;
import com.bosonit.BackEnd.trip.infrastructure.controller.input.TripInputDto;
import com.bosonit.BackEnd.trip.infrastructure.controller.output.TripOutDto;
import com.bosonit.BackEnd.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private TripServiceImp tService;

    @PostMapping("")
    public ResponseEntity<?> addTrip(@RequestBody TripInputDto tripInputDto) {
        try {
            TripOutDto tripOutDto = tService.addTrip(tripInputDto);
            return new ResponseEntity<>(tripOutDto, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("Trip already existed");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<TripOutDto>> getAllCustomers(){
        return new ResponseEntity<>(tService.getAllTrips(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/getById/{id}")
    public Object getTripById(@PathVariable String id){
        try {
            return tService.getTripById(id);
        }catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body("Trip doesn't exists");
        }
    }

    @GetMapping("/passenger/count/{id}")
    public ResponseEntity<?> getAllpassengersInTrip(@PathVariable String id){
        try {
            return new ResponseEntity<>("There are " + tService.getTotalPassengers(id) + " passengers"
                    ,HttpStatus.FOUND);
        }catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body("Trip doesn't exists");
        }
    }

    @GetMapping("/verify/{id}")
    public ResponseEntity<?> getStatusTrip(@PathVariable String id){
        try {

            return new ResponseEntity<>("The trip's status is: " + tService.getTravelStatus(id)
                    ,HttpStatus.FOUND);
        }catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body("Trip doesn't exists");
        }
    }

    @PutMapping("addPassenger/{idTrip}/{idPassenger}")
    public ResponseEntity<?> addPassengerToTrip(@PathVariable String idTrip, @PathVariable String idPassenger){

        try {
            return new ResponseEntity<>(tService.addPassengerToTrip(idTrip, idPassenger)
                    ,HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body("Trip doesn't exists");
        }catch (TripFullPeopleException e){
            return ResponseEntity.badRequest().body("Trip is full of people");
        }
    }

    @PutMapping("/changeStatus/{tripId}/{tripStatus}")
    public ResponseEntity<?> changeStatusTrip(@PathVariable String tripId, boolean tripStatus){
        try {
            return new ResponseEntity<>(tService.changeTripStatus(tripId, tripStatus)
                    ,HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body("Trip doesn't exists");
        }
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<?> updateTripById(@RequestBody TripInputDto tripInputDto
            ,@PathVariable String id ){
        try {
            return new ResponseEntity<>(tService.updateTrip(tripInputDto,id), HttpStatus.CREATED);
        }catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body("Trip doesn't exists");
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteTripById(@PathVariable String id){
        try {
            if(tService.deleteTrip(id)){
                return ResponseEntity.ok().body("Trip has been deleted");
            }
        }catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body("Trip doesn't exists");
        }
        return ResponseEntity.badRequest().body("Trip doesn't exists");
    }
}
