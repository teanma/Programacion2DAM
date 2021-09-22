import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class HolaReader {

    private static Logger log = LoggerFactory.getLogger(HolaReader.class);

    public static void main(String[] args) {
        HolaReader holaReader = new HolaReader();
        holaReader.readFile();
    }

    public void readFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/tmp/hola.txt")))) {
            StringBuilder str = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                str.append(bufferedReader.readLine() + "\n");
            }
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
