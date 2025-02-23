package com.roney.service;


import com.fasterxml.jackson.databind.ObjectMapper;

import com.roney.model.ParkingEndResponse;
import com.roney.model.ParkingSession;
import com.roney.repo.ParkingSessionRepository;
import io.awspring.cloud.sqs.annotation.SqsListener;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class ParkingSqsService {

    private final ParkingSessionRepository repository;
    private final SqsTemplate sqsTemplate;
    private final ObjectMapper objectMapper;
    private static final int PRICE_PER_MINUTE = 2;

    @SqsListener("parking-start-request")
    public void handleParkingStart(String message) {
        try {
            ParkingSession session = objectMapper.readValue(message, ParkingSession.class);
            repository.save(session);
            System.out.println("Stored parking session: " + session);
        } catch (Exception e) {
            throw new RuntimeException("Failed to process parking start request", e);
        }
    }

    @SqsListener("parking-end-request")
    public void handleParkingEnd(String regNo) {
        try {
            ParkingSession session = repository.findByRegNo(regNo);
            if (session == null) {
                throw new RuntimeException("No session found for regNo: " + regNo);
            }

            Date endTime = new Date();
            long duration = endTime.getTime() - session.getStartTime().getTime();
            long minutes = TimeUnit.MILLISECONDS.toMinutes(duration);
            int price = (int) (minutes * PRICE_PER_MINUTE);

            String response = objectMapper.writeValueAsString(new ParkingEndResponse(session.getParkingNo(), session.getStartTime(), endTime, price, "End", regNo));
            sqsTemplate.send("parking-end-response", response);
        } catch (Exception e) {
            throw new RuntimeException("Failed to process parking end request", e);
        }
    }
}
