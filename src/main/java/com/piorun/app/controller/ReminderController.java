package com.piorun.app.controller;

import com.piorun.app.mail.EmailService;
import com.piorun.app.repository.PersonRepository;
import com.piorun.app.workout.Person;
import com.piorun.app.workout.Workout;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ReminderController {

    private final EmailService service;

    private final PersonRepository personRepository;

    public ReminderController(EmailService service, PersonRepository personRepository) {
        this.service = service;
        this.personRepository = personRepository;
    }

    @Scheduled(cron = "0 0 7 * * *", zone = "CET")
    public void remind() {
        service.remindAll();
    }

    @GetMapping("/add")
    public void dsa() {

        Map<DayOfWeek, Workout> workoutMap = new HashMap<>();
        Workout workout = new Workout();
        workout.add("joga : https://www.youtube.com/watch?v=ABBuecfNqXc&list=PLRz2ixZUdsyRkGl1OVdZf3pz1FylysvCT");
        workout.add("bieganko : setki");
        workoutMap.put(DayOfWeek.MONDAY, workout);
        workoutMap.put(DayOfWeek.TUESDAY, workout);
        workoutMap.put(DayOfWeek.WEDNESDAY, workout);
        workoutMap.put(DayOfWeek.THURSDAY, workout);
        workoutMap.put(DayOfWeek.FRIDAY, workout);
        workoutMap.put(DayOfWeek.SATURDAY, workout);
        Person maciej = new Person("maciej.piorun@op.pl", "Maciej", workoutMap);
        personRepository.save(maciej);

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