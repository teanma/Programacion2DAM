package org.iesfm.instituto.jdbc.reader;

import org.iesfm.instituto.jdbc.classes.Title;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class TitleReader {

    private static Logger log = LoggerFactory.getLogger(TitleReader.class);

    public Scanner scanner;

    public TitleReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Title readTitle() {
        Integer title_id = null;
        scanner.nextLine();
        log.info("Introduce el título");
        String title_name = scanner.nextLine();
        log.info("Introduce el tipo de grado");
        String title_level = scanner.nextLine();
        log.info("Introduce la familia profesional");
        String family = scanner.nextLine();
        log.info("Introduce una descripción");
        String title_description = scanner.nextLine();
        return new Title(title_id, title_name, title_level, family, title_description);
    }
}
