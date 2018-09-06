package com.andreitop.newco.controller;

import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.repository.TripRepository;
import com.andreitop.newco.service.TripService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TripsServiceTest {

    @Autowired
    private TripService tripService;

    @MockBean
    private TripRepository tripRepository;

    private List<TripDto> expected;

    @Before
    public void setUp(){
        TripDto tripDto = new TripDto();
        tripDto.setId(1L);
        tripDto.setOrigin("MOW");
        tripDto.setDestination("LED");
        tripDto.setPrice(4232);

        expected = Collections.singletonList(tripDto);
    }

    @Test
    public void finAllTest() throws Exception {
        given(tripRepository.findAll()).willReturn(expected);

        List<TripDto> real = tripService.findAll();

        assertThat(expected, is(real));
    }

    @Test
    public void finByIdTest() throws Exception {

        given(tripRepository.findById(1L)).willReturn(expected.get(0));

        TripDto real = tripService.findById(1L);

        assertThat(real, is(expected.get(0)));
    }

    @Test
    public void saveTest() throws Exception {
        tripService.save(expected.get(0));
        verify(tripRepository, times(1)).save(expected.get(0));
    }

    @Test
    public void deleteTest() throws Exception {
        tripService.delete(1L);
        verify(tripRepository, times(1)).delete(1L);
    }

    @Test
    public void updateTest() throws Exception {
        tripService.update(expected.get(0));
        verify(tripRepository, times(1)).update(expected.get(0));
    }
}
