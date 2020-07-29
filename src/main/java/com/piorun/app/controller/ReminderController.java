package com.piorun.app.controller;

import com.piorun.app.mail.EmailService;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReminderController {

    private final EmailService service;

    public ReminderController(EmailService service) {
        LoggerFactory.getLogger(ReminderController.class).debug("Started notifications on 7:00 Warsaw Time");
        this.service = service;
    }

    @Scheduled(cron = "0 0 7 * * *", zone = "CET")
    public void remind() {
        service.remindAll();
    }


    @GetMapping("/send")
    public void send() {
        service.remindMe();
    }

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }
}