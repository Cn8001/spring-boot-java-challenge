package com.busticket.challenge.ticketsystem.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.busticket.challenge.ticketsystem.models.Booking;
import com.busticket.challenge.ticketsystem.repositories.BookingRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping(path = "/v2/booking")
public class BookingController {
    @Autowired
    private BookingRepository repository;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        if(booking != null){
            try{
                repository.save(booking);
            }catch(IllegalArgumentException e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(booking,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable("id") int id,
            @RequestBody Booking booking){

        Optional<Booking> oldValOpt = repository.findById(id);

        if(!oldValOpt.isPresent()){
            return ResponseEntity.notFound().build();
        }

        Booking oldVal = oldValOpt.get();

        /* Update old booking record values */
        oldVal.setDepDate(booking.getDepDate());
        oldVal.setDepTime(booking.getDepTime());
        oldVal.setDestination(booking.getDestination());
        oldVal.setDuration(booking.getDuration());
        oldVal.setEmail(booking.getEmail());
        oldVal.setName(booking.getName());
        oldVal.setOrigin(booking.getOrigin());

        repository.save(oldVal);
        return new ResponseEntity<>(oldVal,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int id) {
        Optional<Booking> recordOpt = repository.findById(id);
        if(recordOpt.isPresent()){
            Booking b = recordOpt.get();
            return new ResponseEntity<>(b,HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookingById(@PathVariable("id") int id){
        repository.deleteById(id);
    }
    
}
