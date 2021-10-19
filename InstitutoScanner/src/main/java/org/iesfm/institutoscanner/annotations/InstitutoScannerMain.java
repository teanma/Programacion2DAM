package org.iesfm.institutoscanner.annotations;

import org.iesfm.institutoscanner.Group;
import org.iesfm.institutoscanner.GroupReader;
import org.iesfm.institutoscanner.Student;
import org.iesfm.institutoscanner.StudentReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InstitutoScannerMain {
    private static Logger log = LoggerFactory.getLogger(InstitutoScannerMain.class);
    public static void main(String[] args) {
        // Se crea el contexto de la aplicación
        // Se crean los beans y se inyectan las dependencias
        ApplicationContext context =
                new AnnotationConfigApplicationContext(InstitutoScannerConfiguration.class);

        //StudentReader programa = context.getBean(StudentReader.class);
        //Student student = programa.readStudent();
        //log.info(student.toString());
        GroupReader programa = context.getBean(GroupReader.class);
        Group group = programa.readGroup();
        log.info(group.toString());
    }
}
