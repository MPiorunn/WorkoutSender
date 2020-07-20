package com.piorun.app.mail;


import com.piorun.app.logger.AbstractLogger;
import com.piorun.app.logger.MailLogger;
import org.junit.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.internet.MimeMessage;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EmailServiceTest {


    private final JavaMailSender mailSender = mock(JavaMailSender.class);
    private final AbstractLogger logger = new MailLogger();
    private final EmailService emailService = new EmailService(mailSender, logger);


    @Test
    public void correctFlowTest() {
        emailService.remindAll();
        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }
}