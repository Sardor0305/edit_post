package org.example.bot.callback;


import org.example.bot.callback.button.Buttons;
import org.example.bot.utiliy.UpdateIdProcess;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class CallBackButtonProc {
    public static InlineKeyboardMarkup INLINE_JOIN_DELETE  = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(Buttons.BTN_JOIN,Buttons.BTN_DELETE))
            .build();

    public static void process(Update update , TelegramLongPollingBot bot) {

            try {
                bot.execute(SendMessage.builder()
                        .chatId(UpdateIdProcess.chatId(update))
                        .text("\uD83E\uDD13 Qaysi xizmatni tanlaysiz:")
                        .replyMarkup(INLINE_JOIN_DELETE)
                        .build());
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);



    }

    }
}
