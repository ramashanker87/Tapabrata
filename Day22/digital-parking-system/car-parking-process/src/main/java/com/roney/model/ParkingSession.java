package com.roney.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;


import java.util.Date;

@Data
@DynamoDbBean("parking-sessions")
public class ParkingSession {

    @Id
    private String parkingNo;
    private String regNo;
    private Date startTime;
    private String status;
}

