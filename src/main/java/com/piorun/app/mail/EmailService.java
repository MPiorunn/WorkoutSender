package com.piorun.app.mail;

import com.piorun.app.logger.AbstractLogger;
import com.piorun.app.workout.Person;
import com.piorun.app.workout.Workout;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class EmailService {

    private final JavaMailSender emailSender;

    private final AbstractLogger logger;

    private final List<Person> people = new ArrayList<>();

    public EmailService(JavaMailSender emailSender, AbstractLogger logger) {
        this.emailSender = emailSender;
        this.logger = logger;

    }

    public void remindAll() {
        for (Person person : people) {
            sendReminder(person);
        }
    }

    private void sendReminder(Person person) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        logger.debug("Sending mail to " + person.getEmail());
//        logger.debug("Mail content " + workout.toString());

        mailMessage.setTo(person.getEmail());
        mailMessage.setSubject("Twoj trening na dzis");
        mailMessage.setText(prepareText(person));
        emailSender.send(mailMessage);
    }


    private String prepareText(Person person) {
        DayOfWeek today = LocalDate.now().getDayOfWeek();
        Workout workout = person.getWeekDays().get(today);

        String greetings = "Hej " + person.getName() + "\n\n";
        String intro = "Na dzisiejszy dzień twój trening to:\n\n";
        return greetings + intro + workout.toString();
    }

    public List<String> getLogs() {
        return logger.getLogs();
    }
}
