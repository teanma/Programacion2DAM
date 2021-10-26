package org.iesfm.institutoscanner.annotations;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.iesfm.institutoscanner.AskForHighSchool;
import org.iesfm.institutoscanner.reader.GroupReader;
import org.iesfm.institutoscanner.reader.HighSchoolReader;
import org.iesfm.institutoscanner.reader.ScannerUtils;
import org.iesfm.institutoscanner.reader.StudentReader;
import org.iesfm.institutoscanner.writer.HighSchoolWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.File;
import java.util.Scanner;

@Configuration
@PropertySource("application.properties")
public class InstitutoScannerConfiguration {

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
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

    @Bean
    public HighSchoolWriter highSchoolWriter(ObjectMapper objectMapper,
                                             @Value("highschool.path") String path) {
        return new HighSchoolWriter(objectMapper, path);
    }

    @Bean
    public AskForHighSchool askForHighSchool(HighSchoolReader highSchoolReader, HighSchoolWriter highSchoolWriter) {
        return new AskForHighSchool(highSchoolReader, highSchoolWriter);
    }
}
