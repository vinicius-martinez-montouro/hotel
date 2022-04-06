package com.springboot.cvc.hotel.domain;

import com.springboot.cvc.hotel.infrastructure.adapters.entitys.HotelEntity;

import java.util.List;

import static com.springboot.cvc.hotel.domain.Room.toListRoom;

public class Hotel {
    private Long id;
    private String name;
    private String cityCode;
    private String cityName;
    private List<Room> rooms;

    public Hotel(Long id, String name, String cityCode, String cityName, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.rooms = rooms;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCityCode() {
        return cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public static Hotel toHotel(HotelEntity entity){
        return new Hotel(entity.getId(), entity.getName(), entity.getCityCode(), entity.getCityName(), toListRoom(entity.getRooms()));
    }
}
