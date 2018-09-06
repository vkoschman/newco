package com.andreitop.newco.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class TripDto extends Dto {

    @NotNull
    @Positive
    private Long id;
    @NotNull
    @Pattern(regexp = "[a-zA-Z]+", message = "airport should contain only letters")
    @Max(value = 30, message = "Airport name is too long")
    private String origin;
    @NotNull
    @Pattern(regexp = "[a-zA-Z]+", message = "airport should contain only letters")
    @Max(value = 30, message = "Airport name is too long")
    private String destination;
    @NotNull
    @Positive
    private Integer price;

    @Override
    public Long getId() { return id; }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
