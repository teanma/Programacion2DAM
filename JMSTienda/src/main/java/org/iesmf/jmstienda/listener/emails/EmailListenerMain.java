package org.iesmf.jmstienda.listener.emails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@SpringBootApplication
public class EmailListenerMain {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(EmailListenerMain.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        SpringApplication.run(EmailListenerMain.class, args);
    }
}
