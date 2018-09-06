package com.andreitop.newco.controller;

import com.andreitop.newco.dto.Dto;
import com.andreitop.newco.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public abstract class GeneralControllerImpl<T extends Dto> implements GeneralController<T> {

    private final GeneralService generalService;

    @Autowired
    public GeneralControllerImpl(GeneralService generalService) {
        this.generalService = generalService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<T> findAll() {
        return generalService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public T findById(@PathVariable("id") final Long id) {
        return (T) generalService.findById(id); //TODO
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final T trip) {
        generalService.save(trip);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final Long id) {
        generalService.delete(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody final T newTrip) {
        generalService.update(newTrip);
    }
}
