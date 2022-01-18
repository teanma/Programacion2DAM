package org.iesfm.jms.sender;

import org.iesfm.jms.Email;
import org.springframework.jms.core.JmsTemplate;

public class HelloWorldEmailSender {

    private JmsTemplate jmsTemplate;

    public HelloWorldEmailSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send() {
        Email email = new Email(
                "admin@iesfm.org",
                "hola@iesfm.org",
                "Hola",
                "Hola mundo"
        );

        jmsTemplate.convertAndSend("emails", email);
    }
}
