package org.iesfm.jms.sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SenderMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(SenderMain.class, args);

        context.getBean(HelloWorldEmailSender.class).send();
        context.close();
    }
}
