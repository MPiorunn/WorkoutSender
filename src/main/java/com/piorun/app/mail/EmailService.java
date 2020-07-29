package com.piorun.app.mail;

import com.piorun.app.repository.PersonRepository;
import com.piorun.app.workout.Person;
import com.piorun.app.workout.Workout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;


@Component
public class EmailService {

    private final JavaMailSender emailSender;

    private final Logger logger = LoggerFactory.getLogger(EmailService.class);

    private final List<Person> people;

    public EmailService(JavaMailSender emailSender, PersonRepository repository) {
        this.emailSender = emailSender;

        people = repository.getAll();
    }

    public void remindAll() {
        for (Person person : people) {
            sendReminder(person);
        }
    }

    private void sendReminder(Person person) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        logger.debug("Sending mail to " + person.getEmail());

        mailMessage.setTo(person.getEmail());
        mailMessage.setSubject("Twoj trening na dzis");
        mailMessage.setText(prepareText(person));
        emailSender.send(mailMessage);
    }


    private String prepareText(Person person) {
        DayOfWeek today = LocalDate.now().getDayOfWeek();

        logger.debug("Sending workout for " + today.toString());
        Workout workout = person.getWeekDays().get(today);


        String greetings = "Hej " + person.getName() + "\n\n";
        String intro = "Na dzisiejszy dzień twój trening to:\n\n";
        return greetings + intro + workout.toString();
    }

    public void remindMe() {
        sendReminder(people.get(1));
    }
}
