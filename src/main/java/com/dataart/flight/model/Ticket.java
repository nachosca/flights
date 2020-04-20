package com.dataart.flight.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket {

    @Id
    @GeneratedValue
    private Integer itineraryID;

    @NotNull
    @FutureOrPresent
    private LocalDate departureDate;
    @NotNull
    @FutureOrPresent
    private LocalDate arrivalDate;
    @NotNull
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private City origin;
    @NotNull
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private City destination;
    @NotNull
    private String name;
    @NotNull
    @PositiveOrZero
    private Integer age;
    @NotNull
    private Boolean hasLuggage;
    @NotNull
    @Positive
    private BigDecimal price;
    @NotNull
    private LocalTime departureTime;
    @NotNull
    private LocalTime arrivalTime;
}
