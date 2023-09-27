package org.example.bot.callback;

import org.example.bot.utiliy.CheckAdmin;
import org.example.bot.utiliy.LinkSave;
import org.example.bot.utiliy.UpdateIdProcess;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class DeleteProcess {
    public static void process(Update update, TelegramLongPollingBot bot) {
        if (CheckAdmin.isChannelAdmin(update,bot)) {
            try {
                bot.execute(SendMessage.builder()
                        .chatId(UpdateIdProcess.chatId(update))
                        .text("✅ Joriy havola o’chirildi")
                        .build());
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

             LinkSave.SAVE_LINK_MAP.remove(UpdateIdProcess.chatId(update));
        }
    }
}