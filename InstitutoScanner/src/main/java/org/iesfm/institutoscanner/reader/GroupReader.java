package org.iesfm.institutoscanner.reader;

import org.iesfm.institutoscanner.Group;
import org.iesfm.institutoscanner.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GroupReader {

    private static Logger log = LoggerFactory.getLogger(GroupReader.class);

    public Scanner scanner;
    public StudentReader studentReader;
    public ScannerUtils scannerUtils;

    public GroupReader(Scanner scanner, StudentReader studentReader, ScannerUtils scannerUtils) {
        this.scanner = scanner;
        this.studentReader = studentReader;
        this.scannerUtils = scannerUtils;
    }

    public Group readGroup() {
        log.info("Introduce la letra");
        String letter = scanner.nextLine();
        log.info("Introduce el curso");
        int grade = scannerUtils.readPositiveNumber();
        log.info("Introduce la lista de estudiantes");
        int showStudents = scannerUtils.readPositiveNumber();
        List<Student> students = new LinkedList<>();
        for (int i = 0; i < showStudents; i++) {
            students.add(studentReader.readStudent());
        }
        return new Group(letter, grade, students);
    }
}
