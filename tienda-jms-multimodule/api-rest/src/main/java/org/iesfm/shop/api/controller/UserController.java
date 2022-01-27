package org.iesfm.shop.api.controller;

import org.iesfm.shop.Email;
import org.iesfm.shop.User;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private JmsTemplate jmsTemplate;

    public UserController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/users")
    public void insert(@RequestBody User user) {
        System.out.println(user.toString());
        Email email = new Email(
                user.getEmail(),
                "Bienvenido, " + user.getUsername(),
                "Gracias por registrarte, " + user.getUsername()
        );
        jmsTemplate.convertAndSend("shopMail", email);
    }
}
