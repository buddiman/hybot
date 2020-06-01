package de.hoellriegl;


import de.hoellriegl.events.MessageListener;
import de.hoellriegl.util.Config;
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
        Config config = new Config();

        jdaBuilder = new JDABuilder(AccountType.BOT);
        String token = config.getDiscordToken();
        String database = config.getDatabaseConnection();

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
