package org.iesfm.filesearch;

import java.io.File;
import java.net.URISyntaxException;

public class QuijoteReader {

    public String readText(File classpath) throws URISyntaxException {
        File classpathFile = new File(this.getClass().getResource("el_quijote.txt").toURI());
        StringBuilder builder = new StringBuilder();
        return null;
    }

    public static void main(String[] args) {

    }
}
