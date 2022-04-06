package com.springboot.cvc.hotel.domain.adapters.services;

import com.springboot.cvc.hotel.domain.dtos.HotelDto;
import com.springboot.cvc.hotel.domain.dtos.PriceDetailDto;
import com.springboot.cvc.hotel.domain.dtos.RoomDto;
import com.springboot.cvc.hotel.domain.ports.interfaces.HotelServicePort;
import com.springboot.cvc.hotel.domain.ports.repositorys.HotelRepositoryPort;
import com.springboot.cvc.hotel.domain.utils.DateUtils;

import java.util.List;
import java.util.stream.Collectors;

import static com.springboot.cvc.hotel.domain.dtos.HotelDto.toHotelDto;
import static java.math.BigDecimal.valueOf;
import static java.math.RoundingMode.HALF_EVEN;

public class HotelServiceImpl implements HotelServicePort {

    private final HotelRepositoryPort hotelRepositoryPort;

    public HotelServiceImpl(HotelRepositoryPort hotelRepositoryPort) {
        this.hotelRepositoryPort = hotelRepositoryPort;
    }

    public List<HotelDto> getHotelsByCity(Long id, String checkin, String checkout, int numberAdult, int numberChild) {
        List<HotelDto> hotelDtos = hotelRepositoryPort.getHotelsByCity(id)
                .parallelStream()
                .map(HotelDto::toHotelDto)
                .collect(Collectors.toList());
        hotelDtos
                .parallelStream()
                .forEach(hotelDto -> hotelDto.getRooms()
                        .parallelStream()
                        .forEach(roomDto -> addTotalPrice(DateUtils.getPeriod(checkin, checkout), roomDto, numberAdult, numberChild)));
        return hotelDtos;
    }

    public HotelDto getHotelDetail(Long id, String checkin, String checkout, int numberAdult, int numberChild) {
        HotelDto hotelDto = toHotelDto(hotelRepositoryPort.getHotelById(id));
        hotelDto.getRooms()
                .parallelStream()
                .forEach(roomDto -> addTotalPrice(DateUtils.getPeriod(checkin, checkout), roomDto, numberAdult, numberChild));
        return hotelDto;
    }

    private void addTotalPrice(long period, RoomDto roomDto, int adult, int child) {
        roomDto.setTotalPrice(calcPeriod(period, roomDto.getPriceDetail(), adult, child));
    }

    private Double calcPeriod(long period, PriceDetailDto priceDetailDto, int adult, int child) {
        var dailyChilds = valueOf(priceDetailDto.getPricePerDayChild())
                .multiply(valueOf(child));
        var dailyAdults = valueOf(priceDetailDto.getPricePerDayAdult())
                .multiply(valueOf(adult));
        var resultDaily = dailyAdults.add(dailyChilds);
        var result = resultDaily.multiply(valueOf(period)).setScale(2, HALF_EVEN);
        return result.doubleValue();
    }
}
