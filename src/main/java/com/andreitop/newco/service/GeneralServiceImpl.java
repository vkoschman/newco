package com.andreitop.newco.service;

import com.andreitop.newco.dto.Dto;
import com.andreitop.newco.repository.GeneralRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class GeneralServiceImpl<T extends Dto> implements GeneralService<T> {

    private final GeneralRepositoryImpl<T> generalRepositoryImpl;

    @Autowired
    public GeneralServiceImpl(GeneralRepositoryImpl generalRepositoryImpl) {
        this.generalRepositoryImpl = generalRepositoryImpl;
    }

    public List<T> findAll() {
        return generalRepositoryImpl.findAll();
    }

    public T findById(Long id) {
        return generalRepositoryImpl.findById(id);
    }

    public void save(T entity) {
        generalRepositoryImpl.save(entity);
    }

    public void delete(Long id) {
        generalRepositoryImpl.delete(id);
    }

    public void update(T newEntity) {
        generalRepositoryImpl.update(newEntity);
    }
}
