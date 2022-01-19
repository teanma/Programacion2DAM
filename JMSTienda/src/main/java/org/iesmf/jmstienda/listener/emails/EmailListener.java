package org.iesmf.jmstienda.listener.emails;

import org.iesmf.jmstienda.Email;
import org.springframework.jms.annotation.JmsListener;

public class EmailListener {

    @JmsListener(destination = "shopMail")
    public void onMessage(Email email) {
        System.out.println("Enviando email " + email.toString());
    }
}
