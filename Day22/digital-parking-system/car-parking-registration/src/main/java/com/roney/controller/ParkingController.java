package com.roney.controller;



import com.roney.model.Car;
import com.roney.model.ParkingEnd;
import com.roney.model.ParkingStart;
import com.roney.service.ParkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking")
@RequiredArgsConstructor
public class ParkingController {

    private final ParkingService parkingService;

    @PostMapping("/start")
    public ParkingStart startParking(@RequestBody Car car, @RequestParam String parkingNo) {
        return parkingService.startParking(car, parkingNo);
    }

    @GetMapping("/end")
    public ParkingEnd endParking(@RequestParam String regNo) {
        return parkingService.endParking(regNo);
    }
}

