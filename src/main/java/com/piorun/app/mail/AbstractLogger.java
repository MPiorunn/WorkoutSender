package com.piorun.app.mail;

import com.piorun.app.reminder.logger.MailLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AbstractLogger {

    private List<String> logs = new ArrayList<>();
    private Logger logger = LoggerFactory.getLogger(MailLogger.class);

    public List<String> getLogs() {
        return logs;
    }

    public void debug(String s) {
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate localDate = dateTime.toLocalDate();
        String msg = localDate + " " + dateTime.toLocalTime() + s + " ";
        logs.add(msg);
        logger.debug(msg);
    }

    public void clean() {
        this.logs.clear();
    }
}
