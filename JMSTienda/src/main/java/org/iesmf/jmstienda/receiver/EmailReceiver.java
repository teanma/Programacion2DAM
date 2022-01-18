package org.iesmf.jmstienda.receiver;

import org.iesmf.jmstienda.Email;
import org.springframework.jms.annotation.JmsListener;

public class EmailReceiver {

    @JmsListener(destination = "emails")
    public void onMessage(Email email) {
        System.out.println(email.toString());
    }
}
