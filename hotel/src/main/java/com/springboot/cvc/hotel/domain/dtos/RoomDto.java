package com.springboot.cvc.hotel.domain.dtos;

import com.springboot.cvc.hotel.domain.Room;

import java.util.List;
import java.util.stream.Collectors;

import static com.springboot.cvc.hotel.domain.dtos.PriceDetailDto.priceDetailDto;

public class RoomDto {
    private Long roomID;
    private String categoryName;
    private Double totalPrice;
    private PriceDetailDto priceDetail;

    public RoomDto(Long roomID, String categoryName, PriceDetailDto priceDetail) {
        this.roomID = roomID;
        this.categoryName = categoryName;
        this.priceDetail = priceDetail;
    }

    public RoomDto(Long roomID, String categoryName, Double totalPrice, PriceDetailDto priceDetail) {
        this.roomID = roomID;
        this.categoryName = categoryName;
        this.totalPrice = totalPrice;
        this.priceDetail = priceDetail;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Long getRoomID() {
        return roomID;
    }

    public PriceDetailDto getPriceDetail() {
        return priceDetail;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public static List<RoomDto> toRoomDtoList(List<Room> rooms) {
        return rooms.parallelStream()
                .map(RoomDto::toRoomDto)
                .collect(Collectors.toList());
    }

    public static RoomDto toRoomDto(Room room) {
        return new RoomDto(room.getRoomID(), room.getCategoryName(), priceDetailDto(room.getPrice()));
    }
}
