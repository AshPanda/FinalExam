package page_object.elements;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
public static Properties getProperties(){
    try {
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);

        return properties;

    } catch (Exception e) {
        e.printStackTrace();

    }
    return null;
}

}
