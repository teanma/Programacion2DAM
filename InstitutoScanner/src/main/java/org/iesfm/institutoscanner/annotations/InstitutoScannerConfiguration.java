package org.iesfm.institutoscanner.annotations;

import org.iesfm.institutoscanner.GroupReader;
import org.iesfm.institutoscanner.StudentReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class InstitutoScannerConfiguration {

    @Bean
    public StudentReader studentReader (Scanner scanner) {
        return new StudentReader(scanner);
    }

    @Bean
    public GroupReader groupReader (Scanner scanner, StudentReader studentReader) {
        return new GroupReader(scanner, studentReader);
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
