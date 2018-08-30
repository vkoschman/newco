package com.andreitop.newco.repository;

import com.andreitop.newco.model.Trip;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TripRepository  {

    private final List<Trip> trips = new ArrayList<>();

    public List<Trip> findAll() {
        return trips;
    }

    public Trip findById(final Long id) {
        return trips.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(final Trip trip) {
        trip.setId((long) (trips.size() + 1));
        trips.add(trip);
    }

    public void delete(final Long id) {
        trips.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .ifPresent(trips::remove);
    }

    public void update(final Trip newTrip) {
        trips.stream()
                .filter(t -> t.getId().equals(newTrip.getId()))
                .findFirst()
                .ifPresent(t -> trips.set(trips.indexOf(t), newTrip));
    }
}
