package com.andreitop.newco.service;

import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService extends GeneralServiceImpl<TripDto> {

    @Autowired
    public TripService(TripRepository tripRepository){
        super(tripRepository);
    }
}
