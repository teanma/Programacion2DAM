package org.iesfm.airline.listeners.email;

import org.iesfm.airline.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailListener {

    private final static Logger log = LoggerFactory.getLogger(EmailListener.class);

    private JavaMailSender mailSender;

    public EmailListener(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @JmsListener(destination = "airline_emails")
    public void onMessage(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("iesfmpruebas@gmail.com");
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getBody());
        mailSender.send(message);
    }
}
