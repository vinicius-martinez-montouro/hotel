package com.springboot.cvc.hotel.infrastructure.config;

import com.springboot.cvc.hotel.domain.adapters.services.HotelServiceImpl;
import com.springboot.cvc.hotel.domain.ports.interfaces.HotelServicePort;
import com.springboot.cvc.hotel.domain.ports.repositorys.HotelRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    HotelServicePort hotelService(HotelRepositoryPort hotelRepositoryPort) {
        return new HotelServiceImpl(hotelRepositoryPort);
    }
}
