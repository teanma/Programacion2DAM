package org.iesfm.institutoscanner.writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.iesfm.institutoscanner.HighSchool;
import org.iesfm.institutoscanner.annotations.InstitutoScannerMain;
import org.iesfm.institutoscanner.reader.GroupReader;
import org.iesfm.institutoscanner.reader.ScannerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class HighSchoolWriter {

    private ObjectMapper objectMapper;
    private String path;

    public HighSchoolWriter(ObjectMapper objectMapper, String path) {
        this.objectMapper = objectMapper;
        this.path = path;
    }

    public void highSchoolWriter(HighSchool highSchool) {
        try {
            objectMapper.writeValue(new File(path), highSchool);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
