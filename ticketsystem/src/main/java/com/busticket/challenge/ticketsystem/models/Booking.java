package com.busticket.challenge.ticketsystem.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.RepresentationModel;

import jakarta.annotation.Nonnull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Document(collection = "ticketsystem")
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class Booking extends RepresentationModel<Booking>{
    
    @Id
    private String id;

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
