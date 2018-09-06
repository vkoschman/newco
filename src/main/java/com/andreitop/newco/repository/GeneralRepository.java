package com.andreitop.newco.repository;

import com.andreitop.newco.dto.Dto;

import java.util.List;

public interface GeneralRepository<T extends Dto> {
    List<T> findAll();

    T findById(final Long id);

    void save(final T entity);

    void delete(final Long id);

    void update(final T newEntity);
}
