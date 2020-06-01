package de.hoellriegl.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * TODO add config class documentation
 *
 * @author Christopher Höllriegl
 * @version 1.0
 */
public class Config {

    private String discordToken;
    private String databaseConnection;

    private Properties properties;

    // TODO add Database Connection

    /**
     * TODO Fill
     */
    public Config() {
        properties = new Properties();

        // Open config File. TODO move from resources to jar folder
        try {
            InputStream inputStream = Config.class.getResourceAsStream("/config.properties");

            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("config.properties not found!");
            }
        } catch(Exception e) {
            System.out.println("Exception: " + e);  // Todo Logfile
        }

        discordToken = readValue("discord_token");
        databaseConnection = buildDatabaseString();
    }

    public String readValue(String value) {
        return properties.getProperty(value);
    }

    public String buildDatabaseString() {
        return "mongodb://" + readValue("mongo_user") +
                ":" + readValue("mongo_pw") +
                "@" + readValue("mongo_ip") +
                ":" + readValue("mongo_port") +
                "/" + readValue("mongo_db");
    }

    public String getDiscordToken() { return discordToken; }

    public String getDatabaseConnection() { return databaseConnection; }

}
