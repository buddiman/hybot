package de.hoellriegl;


import com.mongodb.client.MongoClient;
import de.hoellriegl.events.MessageListener;
import de.hoellriegl.util.ConfigReader;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

import java.io.IOException;


// GameType Skyblock: 63
// TODO: put config.properties back to git without token

public class Main extends ListenerAdapter {

    static JDABuilder jdaBuilder;

    public static void main(String[] args) throws LoginException, IOException {
        // TODO check internet connection
        jdaBuilder = new JDABuilder(AccountType.BOT);
        String token = ConfigReader.getDiscordToken();

        jdaBuilder.setToken(token);
        setupEvents();
        jdaBuilder.build();
    }

    /**
     * setup the event handlers
     */
    private static void setupEvents() {
        jdaBuilder.addEventListeners(new MessageListener());
    }


}
