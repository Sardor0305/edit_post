package org.example.bot.text;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class StartState {

    public static void startProcess(Update update, TelegramLongPollingBot bot) {
        if (update.getMessage().getText().equals("/start")) {
            try {
                bot.execute(SendMessage.builder()
                        .chatId(update.getMessage().getChatId())
                        .text("Botimizga xush kelibsiz\uD83D\uDE0A\n" +
                                "BU bot nima qila oladi?\n" +
                                "Bot sizga kanal link qo'sha oladi \n" +
                                "Buning uchun botni kanalga admin qilishingiz uzi kifoya\uD83D\uDC6E\n" +
                                "@Raximov14_bot kalit suzni yozing va havola kiriting\n" +
                                "CHEKLOVLAR\n" +
                                "❌ Tepasida 'forward' qilingan xabarlarga post qo'ymaydi\n" +
                                "❌ Captionsiz xabarlarga post qo'ymaydi")
                        .build());
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
