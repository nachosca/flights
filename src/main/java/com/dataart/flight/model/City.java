package com.dataart.flight.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class City {

    @NotNull
    @Size(min = 3, max = 3)
    @Id
    @Column(length = 3)
    private String id;
    @NotNull
    private String name;
}
