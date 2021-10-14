package org.iesfm.aerolineaxml;

import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {

        XStream xStream = new XStream();
        xStream.allowTypesByWildcard(new String[]{
                "org.iesfm.aerolineaxml.*"
        });
        xStream.processAnnotations(Iberia.class);
        xStream.processAnnotations(Flight.class);
        xStream.processAnnotations(Passenger.class);
        File iberiaFile = new File(
                Main.class.getResource("/iberia.xml").toURI()
        );
        Iberia iberia = (Iberia) xStream.fromXML(iberiaFile);
        System.out.println(iberia.toString());
    }
}
