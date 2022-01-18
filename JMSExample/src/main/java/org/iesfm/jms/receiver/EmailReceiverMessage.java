package org.iesfm.jms.receiver;

import org.iesfm.jms.Email;
import org.springframework.jms.annotation.JmsListener;

public class EmailReceiverMessage {

    @JmsListener(destination = "emails")
    public void onMessage(Email email) {
        System.out.println(email.toString());
    }
}
