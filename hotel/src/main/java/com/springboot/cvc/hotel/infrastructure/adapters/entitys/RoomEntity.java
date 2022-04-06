package com.springboot.cvc.hotel.infrastructure.adapters.entitys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomEntity {
    private Long roomID;
    private String categoryName;
    private PriceEntity price;
}
