package com.andreitop.newco.controller;

import com.andreitop.newco.dto.Dto;

import java.util.List;

public interface GeneralController<T extends Dto> {
    List<T> findAll();

    T findById(final Long id);

    void create(final T entity);

    void delete(final Long id);

    void update(final T newEntity);
}
