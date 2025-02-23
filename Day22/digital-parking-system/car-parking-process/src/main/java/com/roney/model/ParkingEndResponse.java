package com.roney.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ParkingEndResponse {
    private String parkingNo;
    private Date startTime;
    private Date endTime;
    private int price;
    private String status;
    private String regNo;
}

