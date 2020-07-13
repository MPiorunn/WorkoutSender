package com.piorun.app.mail;

import com.piorun.app.reminder.house.Flatmate;
import com.piorun.app.reminder.house.Room;
import com.piorun.app.reminder.logger.MailLogger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.piorun.app.reminder.messages.MailTextCreator.*;


@Component
public class EmailService {

    private final JavaMailSender emailSender;

    private final MailLogger logger;

    private List<Flatmate> flatmates = Arrays.asList(Flatmate.values());

    public EmailService(JavaMailSender emailSender, MailLogger logger) {
        this.emailSender = emailSender;
        this.logger = logger;
    }

    public void remindAll() {

        logger.debug("Starting sending reminders");

        for (int i = 0; i < Room.values().length; i++) {
            logger.debug("Creating reminder for " + flatmates.get(i));
            logger.debug("Today you have to clean " + Room.values()[i]);
            sendReminder(flatmates.get(i), Room.values()[i]);
        }
    }

    private void sendReminder(Flatmate mate, Room room) {

        String address = mate.getAddress();
        String subject = createSubject();
        String text = createGreeting(mate.getName()) + createCleaning(room.getName());

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(address);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);

        emailSender.send(mailMessage);
        logger.debug("Message sent to " + mate.getAddress());
        System.out.println();

    }

    public void startWeekend() {
        logger.clean();
        logger.debug("Weekend started");
    }

    public void endWeekend() {
        logger.debug("Weekend ended");
        shift();
    }

    public void shift() {
        Collections.rotate(flatmates, 1);
    }

    public List<String> getLogs() {
        return logger.getLogs();
    }

    public List<Flatmate> getFlatmates() {
        return flatmates;
    }
}
