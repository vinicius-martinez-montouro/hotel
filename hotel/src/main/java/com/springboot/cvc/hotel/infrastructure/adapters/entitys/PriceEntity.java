package com.springboot.cvc.hotel.infrastructure.adapters.entitys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceEntity {
    private Double adult;
    private Double child;
}
