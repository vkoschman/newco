package com.andreitop.newco.service;

import com.andreitop.newco.dto.Dto;

import java.util.List;

public interface GeneralService<T extends Dto> {

    List<T> findAll();

    T findById(Long id);

    void save(T entity);

    void delete(Long id);

    void update(T newEntity);
}
