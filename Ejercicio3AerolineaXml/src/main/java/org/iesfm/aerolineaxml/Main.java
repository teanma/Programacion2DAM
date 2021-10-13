package org.iesfm.aerolineaxml;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        File iberiaFile = new File(
                Main.class.getResource("/iberia.json").toURI()
        );
        Iberia iberia = mapper.readValue(iberiaFile, Iberia.class);
        System.out.println(iberia.toString());
    }
}
