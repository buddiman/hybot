package de.hoellriegl;


import de.hoellriegl.util.ConfigReader;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

import zone.nora.slothpixel.Slothpixel;
import zone.nora.slothpixel.player.Player;

import java.io.IOException;


// GameType Skyblock: 63
// TODO: put config.properties back to git without token

public class Main extends ListenerAdapter {

    public static void main(String[] args) throws LoginException, IOException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = ConfigReader.getDiscordToken();

        builder.setToken(token);
        builder.addEventListeners(new Main());
        builder.build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        System.out.println("Received: " + event.getMessage().getContentDisplay()
        );
        if(event.getMessage().getContentRaw().equals("!hy_hello")) {
            event.getChannel().sendMessage("Hello " + event.getAuthor().getName()).queue();
        }
        if(event.getMessage().getContentRaw().equals("!hy_paddy_coins")) {
            event.getChannel().sendMessage("Paddy hat " + getSomething() + " Coins").queue();
        }
    }

    public String getSomething() {
        Slothpixel slothpixel = new Slothpixel();
        Player p = slothpixel.getPlayer("Pitaya1907");
        return String.valueOf(p.getTotalCoins());
    }
}
