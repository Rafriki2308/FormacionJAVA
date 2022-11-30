package com.bosonit.BackEnd.trip.infrastructure.repository;

import com.bosonit.BackEnd.trip.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
}
