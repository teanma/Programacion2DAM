package org.iesfm.institutoscanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GroupReader {

    private final Logger log = LoggerFactory.getLogger(GroupReader.class);

    public Scanner scanner;
    public StudentReader studentReader;

    public GroupReader(Scanner scanner, StudentReader studentReader) {
        this.scanner = scanner;
        this.studentReader = studentReader;
    }

    public Group readGroup() {
        log.info("Introduce la letra");
        String letter = scanner.nextLine();
        log.info("Introduce el curso");
        String grade = scanner.nextLine();
        log.info("Introduce la lista de estudiantes");
        int showStudents = scanner.nextInt();
        List<Student> students = new LinkedList<>();
        for (int i = 0; i < showStudents; i++) {
            students.add(studentReader.readStudent());
        }
        return new Group(letter, grade, students);
    }
}
