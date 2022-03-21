package org.iesfm.airline.listeners.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class EmailListenerMain {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(EmailListenerMain.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }
}
