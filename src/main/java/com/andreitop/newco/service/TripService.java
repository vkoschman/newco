package com.andreitop.newco.service;

import com.andreitop.newco.model.Trip;
import com.andreitop.newco.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    public Trip findById(Long id) {
        return tripRepository.findById(id);
    }

    public void save(Trip trip) {
        tripRepository.save(trip);
    }

    public void delete(Long id) {
        tripRepository.delete(id);
    }

    public void update(Trip newTrip) {
        tripRepository.update(newTrip);
    }
}
