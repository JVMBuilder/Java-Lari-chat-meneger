package org.telegram.chatbot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;


public class Bot {

    TelegramBot bot;

    public Bot(String token) {
        bot = new TelegramBot(token);
        this.run();
    }

    private void run(){
        System.out.println("BOT STARTED!");
        bot.setUpdatesListener(updates -> {
            updates.forEach(new Controller(bot)::update);
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });

    }


}