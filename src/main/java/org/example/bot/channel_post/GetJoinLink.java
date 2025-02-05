package org.example.bot.channel_post;

import org.example.bot.databse.ExecuteData;
import org.example.bot.enam.UserState;
import org.example.bot.entitiy.BotDataEntity;
import org.example.bot.utiliy.UpdateIdProcess;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class GetJoinLink {
    public static void process(final Update update, final TelegramLongPollingBot bot) {
        final BotDataEntity botData = ExecuteData.fetchChat(UpdateIdProcess.chatId(update));
        if (botData.getState() != null &&
                botData.getState().equals(UserState.DEFAULT.name())) {

            ExecuteData.updateChat(UpdateIdProcess.chatId(update), update.getChannelPost().getText(), UserState.CREATElINK.name());
            try {
                bot.execute(SendMessage.builder()
                        .chatId(update.getChannelPost().getChatId())
//                                    .messageId(update.getChannelPost().getMessageId())
                        .text("✅ Link shu ko'rinishda bo'ladi\n\n" +
                                "\uD83D\uDC47\uD83D\uDC47\uD83D\uDC47 \n\n" +
                                ExecuteData.fetchChat(botData.getChatId()).getUrl() + "\n\n" +
                                "\uD83D\uDC46\uD83D\uDC46\uD83D\uDC46 \n")

                        .build());

            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
