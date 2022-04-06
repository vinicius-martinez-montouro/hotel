package com.springboot.cvc.hotel.domain.dtos;

import com.springboot.cvc.hotel.domain.Price;

import java.math.RoundingMode;

import static java.math.BigDecimal.valueOf;

public class PriceDetailDto {
    private Double pricePerDayAdult;
    private Double pricePerDayChild;
    private static final Double commission = 0.7;

    public PriceDetailDto(Double pricePerDayAdult, Double pricePerDayChild) {
        this.pricePerDayAdult = pricePerDayAdult;
        this.pricePerDayChild = pricePerDayChild;
    }

    public Double getPricePerDayAdult() {
        return pricePerDayAdult;
    }

    public Double getPricePerDayChild() {
        return pricePerDayChild;
    }

    public static PriceDetailDto priceDetailDto(Price price) {
        return new PriceDetailDto(addCommission(price.getAdult()), addCommission(price.getChild()));
    }

    private static Double addCommission(Double value) {
        return valueOf(value/commission)
                .setScale(2, RoundingMode.HALF_EVEN)
                .doubleValue();
    }
}
