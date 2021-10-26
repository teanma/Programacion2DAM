package org.iesfm.institutoscanner.annotations;

import org.iesfm.institutoscanner.*;
import org.iesfm.institutoscanner.reader.HighSchoolReader;
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
        HighSchoolReader program = context.getBean(HighSchoolReader.class);
        HighSchool highSchool = program.readHighSchool();
        log.info(highSchool.toString());
    }
}
