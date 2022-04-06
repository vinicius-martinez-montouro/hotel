package com.springboot.cvc.hotel.adapters.controller;

import com.springboot.cvc.hotel.domain.dtos.HotelDto;
import com.springboot.cvc.hotel.domain.ports.interfaces.HotelServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotels/v1")
public class HotelController {

    private final HotelServicePort hotelServicePort;

    public HotelController(HotelServicePort hotelServicePort) {
        this.hotelServicePort = hotelServicePort;
    }

    @GetMapping("/citys/{id}")
    @ResponseBody
    ResponseEntity<List<HotelDto>> getHotelsByCity(@PathVariable("id") Long id,
                                                   @RequestParam String checkin,
                                                   @RequestParam String checkout,
                                                   @RequestParam Integer numberAdult,
                                                   @RequestParam Integer numberChild) {
        return ResponseEntity.ok(hotelServicePort.getHotelsByCity(id, checkin, checkout, numberAdult, numberChild));
    }

    @GetMapping("/{id}")
    ResponseEntity<HotelDto> getHotelDetails(@PathVariable("id") Long id,
                                             @RequestParam String checkin,
                                             @RequestParam String checkout,
                                             @RequestParam Integer numberAdult,
                                             @RequestParam Integer numberChild) {
        return ResponseEntity.ok(hotelServicePort.getHotelDetail(id, checkin, checkout, numberAdult, numberChild));
    }

}
