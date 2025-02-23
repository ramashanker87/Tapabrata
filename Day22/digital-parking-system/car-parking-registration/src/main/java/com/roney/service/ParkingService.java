package com.roney.service;


import com.roney.model.Car;
import com.roney.model.ParkingEnd;
import com.roney.model.ParkingStart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class ParkingService {

    private final ParkingSqsService parkingSqsService;
    private static final int PRICE_PER_MINUTE = 2;

    public ParkingStart startParking(Car car, String parkingNo) {
        ParkingStart parkingStart = new ParkingStart(parkingNo, car.getRegNo());
        parkingSqsService.sendMessage("parking-start-request", parkingStart);
        return parkingStart;
    }

    public ParkingEnd endParking(String regNo) {
        parkingSqsService.sendMessage("parking-end-request", regNo);
        return new ParkingEnd("P123", new Date(), new Date(), 0, "End", regNo);
    }
}
