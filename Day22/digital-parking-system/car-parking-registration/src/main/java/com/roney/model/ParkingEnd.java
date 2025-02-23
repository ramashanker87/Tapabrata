package com.roney.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingEnd {
    private String parkingNo;
    private Date startTime;
    private Date endTime;
    private int price;
    private String status;
    private String regNo;


}
