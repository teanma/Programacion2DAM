package org.iesfm.institutoscanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HighSchoolReader {

    private static Logger log = LoggerFactory.getLogger(GroupReader.class);

    public Scanner scanner;
    public GroupReader groupReader;
    public ScannerUtils scannerUtils;

    public HighSchoolReader(Scanner scanner, GroupReader groupReader, ScannerUtils scannerUtils) {
        this.scanner = scanner;
        this.groupReader = groupReader;
        this.scannerUtils = scannerUtils;
    }

    public HighSchool readHighSchool() {
        log.info("Introduce el nombre del instituto");
        String highSchoolName = scanner.nextLine();
        log.info("Introduce la lista de grupos");
        int showGroups = scannerUtils.readPositiveNumber();
        scanner.nextLine();
        List<Group> groups = new LinkedList<>();
        for (int i = 0; i < showGroups; i++) {
            groups.add(groupReader.readGroup());
        }
        return new HighSchool(highSchoolName, groups);
    }
}
