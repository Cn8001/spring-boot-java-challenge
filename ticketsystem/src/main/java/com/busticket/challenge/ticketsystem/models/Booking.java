package com.busticket.challenge.ticketsystem.models;


import org.springframework.hateoas.RepresentationModel;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class Booking extends RepresentationModel<Booking>{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Nonnull
    private String name;

    @Nonnull
    private String email;

    @Nonnull
    private String origin;
    @Nonnull
    private String destination;

    private String depDate;

    private String depTime;

    private double duration;

}
