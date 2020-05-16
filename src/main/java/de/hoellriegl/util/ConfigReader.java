package de.hoellriegl.util;

import java.io.*;
import java.util.Properties;

public enum ConfigReader {
    ;

    public static String getDiscordToken()  throws IOException {
        String token = new String();
        try {
            Properties properties = new Properties();
            InputStream inputStream = ConfigReader.class.getResourceAsStream("/config.properties");

            if(inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("config.properties not found");
            }
            token = properties.getProperty("discord_token");
        } catch(Exception e) {
            System.out.println("Exception: " + e);
        }
        return token;
    }
}
