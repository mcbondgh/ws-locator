package app.wslocator.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Variables {

    protected Properties loadProperties() {
        Properties properties = new Properties();
        String filePath = "src/main/resources/application.properties";
        try(InputStream stream = new FileInputStream(filePath)) {
            properties.load(stream);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}//end of class
