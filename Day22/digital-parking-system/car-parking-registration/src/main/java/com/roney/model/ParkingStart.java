package com.roney.model;


import lombok.Data;
import java.util.Date;

@Data
public class ParkingStart {
    private String parkingNo;
    private Date startTime;
    private String status;
    private String regNo;

    public ParkingStart(String parkingNo, String regNo) {
        this.parkingNo = parkingNo;
        this.regNo = regNo;
        this.startTime = new Date();
        this.status = "Start";
    }
}
