package com.springboot.cvc.hotel.infrastructure.adapters.repositorys;

import com.springboot.cvc.hotel.domain.Hotel;
import com.springboot.cvc.hotel.domain.ports.repositorys.HotelRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelRepository implements HotelRepositoryPort {

    private final FeignClientHotelRepository feignClientHotelRepository;

    public HotelRepository(FeignClientHotelRepository feignClientHotelRepository) {
        this.feignClientHotelRepository = feignClientHotelRepository;
    }

    @Override
    public Hotel getHotelById(Long id) {
        return Hotel.toHotel(feignClientHotelRepository.getHotelById(id)
                .orElseThrow());
    }

    @Override
    public List<Hotel> getHotelsByCity(Long id) {
        return feignClientHotelRepository.getHotelsByCity(id)
                .orElseThrow()
                .stream()
                .map(Hotel::toHotel)
                .collect(Collectors.toList());
    }
}
