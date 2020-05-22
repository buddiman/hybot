package de.hoellriegl.events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import zone.nora.slothpixel.Slothpixel;
import zone.nora.slothpixel.player.Player;

public class MessageListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String m = event.getMessage().getContentRaw();
        if(m.startsWith("!hy_")) {
            String[] ma = m.split(" ");
            event.getChannel().sendMessage(ma[1] + " has " + getSomething(ma[1]) + " Coins").queue();
        }
    }

    public String getSomething(String name) {
        Slothpixel slothpixel = new Slothpixel();
        Player p = slothpixel.getPlayer(name);
        return String.valueOf(p.getTotalCoins());
    }
}
