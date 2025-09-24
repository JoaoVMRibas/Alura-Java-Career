package br.com.myproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private final Properties properties = new Properties();

    public Config(String configFilePath){
        try(FileInputStream fis = new FileInputStream(configFilePath)){
            properties.load(fis);
        }catch (IOException e){
            System.err.println("Error loading configuration file: " + e.getMessage());
        }
    }

    public String get(String key) {
        String value = properties.getProperty(key);
        if(value == null){
            System.out.println("Key '" + key + "' not found in configuration file.");
            return null;
        }
        if(value.isEmpty()){
            System.out.println("Setting found with no value for key: " + key + ".");
            return null;
        }
        return value;
    }
}
