package org.iesfm.shop.listener.emails;

import org.iesfm.shop.Email;
import org.springframework.jms.annotation.JmsListener;

public class EmailListener {

    @JmsListener(destination = "shopMail")
    public void onMessage(Email email) {
        System.out.println("Enviando email " + email.toString());
    }
}
