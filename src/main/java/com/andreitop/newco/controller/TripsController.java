package com.andreitop.newco.controller;

import com.andreitop.newco.common.APIConstant;
import com.andreitop.newco.dto.TripDto;
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
    public List<TripDto> findAll() {
        return tripService.findAll();
    }

    @GetMapping("/{id}")
    public TripDto findById(@PathVariable("id") final Long id) {
        return tripService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody final TripDto trip) {
        tripService.save(trip);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Long id) {
        tripService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody final TripDto newTrip) {
        tripService.update(newTrip);
    }

}
