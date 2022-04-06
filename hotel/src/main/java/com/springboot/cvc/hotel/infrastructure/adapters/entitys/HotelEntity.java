package com.springboot.cvc.hotel.infrastructure.adapters.entitys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelEntity {
    private Long id;
    private String name;
    private String cityCode;
    private String cityName;
    private List<RoomEntity> rooms;
}
