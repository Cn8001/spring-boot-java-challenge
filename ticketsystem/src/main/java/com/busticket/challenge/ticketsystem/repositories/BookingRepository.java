package com.busticket.challenge.ticketsystem.repositories;



import org.springframework.data.repository.CrudRepository;

import com.busticket.challenge.ticketsystem.models.Booking;


public interface BookingRepository extends CrudRepository<Booking,Integer>{
   
}
