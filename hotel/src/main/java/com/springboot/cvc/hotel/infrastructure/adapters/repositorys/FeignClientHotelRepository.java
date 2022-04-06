package com.springboot.cvc.hotel.infrastructure.adapters.repositorys;

import com.springboot.cvc.hotel.infrastructure.adapters.entitys.HotelEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(value = "hotelRepository", url = "https://cvcbackendhotel.herokuapp.com/hotels")
public interface FeignClientHotelRepository {

    @GetMapping("/{id}")
    Optional<HotelEntity> getHotelById(@PathVariable("id") Long id);

    @GetMapping("/avail/{id}")
    Optional<List<HotelEntity>> getHotelsByCity(@PathVariable("id") Long id);
}
