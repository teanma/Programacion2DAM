package org.iesfm.institutoscanner.annotations;

import org.iesfm.institutoscanner.GroupReader;
import org.iesfm.institutoscanner.HighSchoolReader;
import org.iesfm.institutoscanner.ScannerUtils;
import org.iesfm.institutoscanner.StudentReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class InstitutoScannerConfiguration {

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public StudentReader studentReader (Scanner scanner) {
        return new StudentReader(scanner);
    }

    @Bean
    public GroupReader groupReader (Scanner scanner, StudentReader studentReader, ScannerUtils scannerUtils) {
        return new GroupReader(scanner, studentReader, scannerUtils);
    }

    @Bean
    public HighSchoolReader highSchoolReader (Scanner scanner, GroupReader groupReader, ScannerUtils scannerUtils) {
        return new HighSchoolReader(scanner, groupReader, scannerUtils);
    }

    @Bean
    public ScannerUtils scannerUtils(Scanner scanner) {
        return new ScannerUtils(scanner);
    }
}
