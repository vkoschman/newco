package com.andreitop.newco.controller;

import com.andreitop.newco.common.APIConstant;
import com.andreitop.newco.model.Trip;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(APIConstant.API_V_1 + "/trips")
public class TripsController {

    private List<Trip> trips = new ArrayList<>();

    @GetMapping
    public List<Trip> findAll() {
        return trips;
    }

    @GetMapping("/{id}")
    public Trip findById(@PathVariable("id") Long id) {
        return trips.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public void add(@RequestBody Trip trip) {
        trip.setId((long) (trips.size() + 1));
        trips.add(trip);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        trips.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .ifPresent(t -> trips.remove(t));
    }

    @PutMapping
    public void update(@RequestBody Trip newTrip) {
        trips.stream()
                .filter(t -> t.getId().equals(newTrip.getId()))
                .findFirst()
                .ifPresent(t -> trips.set(trips.indexOf(t), newTrip));
    }

}
