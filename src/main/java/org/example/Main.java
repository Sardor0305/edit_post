package org.example;

import org.example.bot.JoinlinkBot;
import org.example.bot.databse.DatabaseConnection;
import org.example.bot.schedule.ScheduleTask;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new JoinlinkBot());
        DatabaseConnection.setConnection();
        ScheduleTask.schedule();

    }
}