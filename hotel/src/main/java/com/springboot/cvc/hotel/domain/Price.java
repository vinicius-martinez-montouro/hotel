package com.springboot.cvc.hotel.domain;

import com.springboot.cvc.hotel.infrastructure.adapters.entitys.PriceEntity;

public class Price {
    private Double adult;
    private Double child;

    public Price(Double adult, Double child){
        this.adult = adult;
        this.child = child;
    }

    public Double getAdult() {
        return adult;
    }

    public Double getChild() {
        return child;
    }

    public static Price toPrice(PriceEntity entity){
        return new Price(entity.getAdult(), entity.getChild());
    }
}
