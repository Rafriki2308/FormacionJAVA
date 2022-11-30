package com.bosonit.Ej16.BackEnd.trip.infrastructure.repository;

import com.bosonit.Ej16.BackEnd.trip.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
}
