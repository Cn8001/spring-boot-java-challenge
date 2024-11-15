package com.busticket.challenge.ticketsystem.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.busticket.challenge.ticketsystem.models.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking,String>{
   
}
