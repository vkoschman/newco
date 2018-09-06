package com.andreitop.newco.repository;

import com.andreitop.newco.dto.Dto;

import java.util.ArrayList;
import java.util.List;

public abstract class GeneralRepositoryImpl<T extends Dto> implements GeneralRepository<T> {

    private final List<T> entityList = new ArrayList<>();

    public List<T> findAll() {
        return entityList;
    }

    public T findById(final Long id) {
        return entityList.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(final T trip) {
        trip.setId((long) (entityList.size() + 1));
        entityList.add(trip);
    }

    public void delete(final Long id) {
        entityList.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .ifPresent(entityList::remove);
    }

    public void update(final T newTrip) {
        entityList.stream()
                .filter(t -> t.getId().equals(newTrip.getId()))
                .findFirst()
                .ifPresent(t -> entityList.set(entityList.indexOf(t), newTrip));
    }
}
