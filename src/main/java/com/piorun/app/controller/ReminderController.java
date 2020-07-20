package com.piorun.app.controller;

import com.piorun.app.mail.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.TimeZone;

@RestController
public class ReminderController {

    private final EmailService service;

    public ReminderController(EmailService service) {
        this.service = service;
    }

    @Scheduled(cron = "0 0 7 * * *", zone = "CET")
    public void remind() {
        service.remindAll();
    }


    @GetMapping("/logs")
    public ResponseEntity<String> getLogs() {
        return new ResponseEntity<>(service.getLogs().toString(), HttpStatus.OK);
    }


    @GetMapping("/")
    public String hello() {
        return "I am doing okay";
    }

}