package org.iesfm.instituto.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        InstitutoConfiguration.class
                );

        TitleDAO program = context.getBean(TitleDAO.class);
        List<Title> titles = program.list();
        for (Title title : titles) {
            System.out.println(title.toString());
        }
    }
}
