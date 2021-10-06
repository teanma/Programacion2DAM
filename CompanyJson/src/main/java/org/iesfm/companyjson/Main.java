package org.iesfm.companyjson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    private final static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Company company = mapper.readValue(
                    new File(Company.class.getResource("/company.json").toURI()), Company.class);
            log.info(company.toString());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
