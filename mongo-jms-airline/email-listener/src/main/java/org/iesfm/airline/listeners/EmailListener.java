package org.iesfm.airline.listeners;

import org.iesfm.airline.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailListener {

    private final static Logger log = LoggerFactory.getLogger(EmailListener.class);

    @JmsListener(destination = "airline_emails")
    public void onMessage(Email email) {
        log.info("Enviando email " + email.toString());
    }
}
