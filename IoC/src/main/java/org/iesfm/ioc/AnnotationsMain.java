package org.iesfm.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationsMain {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(InstitutoConfiguration.class);
        InstitutoPrograma programa = context.getBean(InstitutoPrograma.class);
        programa.ejecutar();
    }

}
