package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static String getSystemProperty(String propertyName) {
        if (System.getProperty(propertyName) == null) {
            return getPropertyFromFile(propertyName);

        } else {

            return System.getProperty(propertyName);
        }
    }

    private static String getPropertyFromFile(String propertyName) {

        Properties properties = new Properties();
        InputStream input = null;


        try {
            input = new FileInputStream("src/tet/resources/framework.propeties");
            properties.load(input);

        } catch (IOException ex) {
            System.out.println("Cannot read property for " + propertyName);
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return properties.getProperty(propertyName);
    }
}
