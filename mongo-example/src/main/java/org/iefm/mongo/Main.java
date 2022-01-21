package org.iefm.mongo;

import org.iefm.mongo.repository.EmailRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);

        EmailRepository emailRepository = context.getBean(EmailRepository.class);

        //emailRepository.insert(
          //     new Email(
            //           List.of("alguien@gmail.com", "otro@gmail.com"),
              //  "Bienvenido",
                //"Hola, te has registrado correctamente"
                //)
        //);

        //List<Email> emails = emailRepository.findByTo("otro@gmail.com");
        //for (Email email : emails) {
          //  System.out.println(email.toString());
        //}

        List<Email> emails = emailRepository.findByTo(
                List.of(
                        "alguien@hotmail.com",
                        "otro@hotmail.com"
                )
        );
        for (Email email : emails) {
            System.out.println(email.toString());
        }
    }
}
