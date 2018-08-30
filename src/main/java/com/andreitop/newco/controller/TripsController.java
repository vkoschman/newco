package com.andreitop.newco.controller;

import com.andreitop.newco.common.APIConstant;
import com.andreitop.newco.model.Trip;
import com.andreitop.newco.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(APIConstant.API_V_1 + "/trips")
public class TripsController {

    private final TripService tripService;

    @Autowired
    public TripsController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping
    public List<Trip> findAll() {
        return tripService.findAll();
    }

    @GetMapping("/{id}")
    public Trip findById(@PathVariable("id") final Long id) {
        return tripService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody final Trip trip) {
        tripService.save(trip);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Long id) {
        tripService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody final Trip newTrip) {
        tripService.update(newTrip);
    }

}
