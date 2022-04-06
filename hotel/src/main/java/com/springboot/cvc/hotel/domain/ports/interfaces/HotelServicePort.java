package com.springboot.cvc.hotel.domain.ports.interfaces;

import com.springboot.cvc.hotel.domain.dtos.HotelDto;

import java.util.List;

public interface HotelServicePort {
    List<HotelDto> getHotelsByCity(Long id, String checkin, String checkout, int numberAdult, int numberChild);

    HotelDto getHotelDetail(Long id, String checkin, String checkout, int numberAdult, int numberChild);
}
