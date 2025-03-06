package com.tapabrata.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.patient.management.service.SQSService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private SQSService sqsService;

    @GetMapping("/receive")
    public ResponseEntity<String> receivePatientInfo() {
        String response = sqsService.receiveMessage();
        return ResponseEntity.ok(response);
    }
}

