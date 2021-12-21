package org.iesfm.examen1accesodatos;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {

        ObjectMapper om = new ObjectMapper();
        Building building = om.readValue(
                new File( Main.class.getResource("/building.json").toURI()),
                Building.class);
//        building.showInfo();
        System.out.println(building.getFloors().get(1));
        System.out.println(building.getFloors().size());
    }
}
