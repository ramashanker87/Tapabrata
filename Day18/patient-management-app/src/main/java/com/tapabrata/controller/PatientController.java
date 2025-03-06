package com.tapabrata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.patient.management.model.Patient;
import com.patient.management.service.SQSService;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private SQSService sqsService;

    @PostMapping("/send")
    public ResponseEntity<String> sendPatientInfo(@RequestHeader("disease") String disease, @RequestBody Patient patient) {

        sqsService.sendMessage(patient, disease);
        return ResponseEntity.ok("Patient Info Sent to Queue");
    }
}

