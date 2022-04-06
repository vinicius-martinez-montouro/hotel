package com.springboot.cvc.hotel.domain.dtos;

import com.springboot.cvc.hotel.domain.Hotel;

import java.util.List;

import static com.springboot.cvc.hotel.domain.dtos.RoomDto.toRoomDtoList;

public class HotelDto {
    private Long id;
    private String cityName;
    private List<RoomDto> rooms;

    public HotelDto(Long id, String cityName, List<RoomDto> rooms) {
        this.id = id;
        this.cityName = cityName;
        this.rooms = rooms;
    }

    public Long getId() {
        return id;
    }

    public List<RoomDto> getRooms() {
        return rooms;
    }

    public String getCityName() {
        return cityName;
    }

    public static HotelDto toHotelDto(Hotel hotel) {
        return new HotelDto(hotel.getId(), hotel.getCityName(), toRoomDtoList(hotel.getRooms()));
    }
}
