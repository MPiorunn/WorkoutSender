package com.piorun.app.reminder;

import com.piorun.app.mail.EmailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReminderController {

    private final EmailService service;

    public ReminderController(EmailService service) {
        this.service = service;
    }

//    @Scheduled(cron = "0 15 10 ? * MON,FRI")
    public void remind() {
        service.remindAll();
    }

//    @Scheduled(cron = "0 15 9 ? * FRI")
    public void startWeekend() {
        service.startWeekend();
    }

//    @Scheduled(cron = "0 15 9 ? * MON")
    public void endWeekend() {
        service.endWeekend();
    }

    @GetMapping("/logs")
    public List<String> getLogs() {
        return service.getLogs();
    }

    @GetMapping("/")
    public String hello() {
        return "I am doing okay";
    }

}