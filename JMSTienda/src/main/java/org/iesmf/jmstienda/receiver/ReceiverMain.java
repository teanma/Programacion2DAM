package org.iesmf.jmstienda.receiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ReceiverMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(ReceiverMain.class, args);
        context.getBean(EmailReceiver.class);
    }
}
