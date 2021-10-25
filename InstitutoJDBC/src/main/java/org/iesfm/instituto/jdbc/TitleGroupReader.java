package org.iesfm.instituto.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class TitleGroupReader {

    private static Logger log = LoggerFactory.getLogger(TitleGroupReader.class);

    public Scanner scanner;

    public TitleGroupReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public TitleGroup readTitleGroup() {
        Integer group_id = null;
        scanner.nextLine();
        log.info("Introduce el curso");
        String course = scanner.nextLine();
        log.info("Introduce la letra");
        String letter = scanner.nextLine();
        log.info("Introduce el título");
        String title = scanner.nextLine();
        log.info("Introduce el año del grupo");
        String group_year = scanner.nextLine();
        return new TitleGroup(group_id, course, letter, title, group_year);
    }
}
