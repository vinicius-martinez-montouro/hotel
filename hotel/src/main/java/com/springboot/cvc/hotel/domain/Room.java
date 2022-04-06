package com.springboot.cvc.hotel.domain;

import com.springboot.cvc.hotel.infrastructure.adapters.entitys.RoomEntity;

import java.util.List;
import java.util.stream.Collectors;

import static com.springboot.cvc.hotel.domain.Price.toPrice;

public class Room {
    private Long roomID;
    private String categoryName;
    private Price price;

    public Room(Long roomId, String categoryName, Price price) {
        this.roomID = roomId;
        this.categoryName = categoryName;
        this.price = price;
    }

    public Long getRoomID() {
        return roomID;
    }

    public Price getPrice() {
        return price;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public static List<Room> toListRoom(List<RoomEntity> entities){
        return entities.parallelStream()
                .map(Room::toRoom)
                .collect(Collectors.toList());
    }

    public static Room toRoom(RoomEntity entity) {
        return new Room(entity.getRoomID(), entity.getCategoryName(), toPrice(entity.getPrice()));
    }
}
