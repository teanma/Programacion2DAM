package org.iesfm.instituto.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class EnrollmentReader {

    private static Logger log = LoggerFactory.getLogger(EnrollmentReader.class);

    public Scanner scanner;

    public EnrollmentReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Enrollment readEnrollment() {
        Integer enrollment_id = null;
        scanner.nextLine();
        log.info("Introduce el nif");
        String nif = scanner.nextLine();
        log.info("Introduce el año");
        int enrollment_year = scanner.nextInt();
        Integer title_id = null;
        scanner.nextLine();
        Integer group_id = null;
        scanner.nextLine();
        log.info("Introduce el estado");
        String enrollment_status = scanner.nextLine();
        return new Enrollment(enrollment_id, nif, enrollment_year, title_id, group_id, enrollment_status);
    }
}
