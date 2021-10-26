package org.iesfm.institutoscanner;

import org.iesfm.institutoscanner.reader.GroupReader;
import org.iesfm.institutoscanner.reader.HighSchoolReader;
import org.iesfm.institutoscanner.writer.HighSchoolWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AskForHighSchool {

    private static Logger log = LoggerFactory.getLogger(AskForHighSchool.class);

    private HighSchoolReader highSchoolReader;
    private HighSchoolWriter highSchoolWriter;

    public AskForHighSchool(HighSchoolReader highSchoolReader, HighSchoolWriter highSchoolWriter) {
        this.highSchoolReader = highSchoolReader;
        this.highSchoolWriter = highSchoolWriter;
    }
}
