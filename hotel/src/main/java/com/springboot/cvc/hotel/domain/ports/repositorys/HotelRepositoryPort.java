package com.springboot.cvc.hotel.domain.ports.repositorys;

import com.springboot.cvc.hotel.domain.Hotel;

import java.util.List;

public interface HotelRepositoryPort {
    List<Hotel> getHotelsByCity(Long id);

    Hotel getHotelById(Long id);
}
