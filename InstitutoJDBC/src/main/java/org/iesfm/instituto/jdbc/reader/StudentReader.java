package org.iesfm.instituto.jdbc.reader;

import org.iesfm.instituto.jdbc.classes.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class StudentReader {

    private static Logger log = LoggerFactory.getLogger(StudentReader.class);

    public Scanner scanner;

    public StudentReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Student readStudent() {
        log.info("Introduce el nif");
        String nif = scanner.nextLine();
        log.info("Introduce el nombre del estudiante");
        String student_name = scanner.nextLine();
        log.info("Introduce el apellido del estudiante");
        String student_surname = scanner.nextLine();
        log.info("Introduce el zipcode");
        int zipcode = scanner.nextInt();
        scanner.nextLine();
        log.info("Introduce la dirección");
        String address = scanner.nextLine();
        log.info("Introduce el correo");
        String email = scanner.nextLine();
        return new Student(nif, student_name, student_surname, zipcode, address, email);
    }
}
