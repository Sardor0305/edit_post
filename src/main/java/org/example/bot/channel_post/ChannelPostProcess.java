package org.example.bot.channel_post;


import org.example.bot.databse.ExecuteData;
import org.example.bot.enam.UserState;
import org.example.bot.entitiy.BotDataEntity;
import org.example.bot.utiliy.UpdateIdProcess;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageCaption;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ChannelPostProcess {
    public static void process(final Update update, final TelegramLongPollingBot bot) {

        final BotDataEntity botData = ExecuteData.fetchChat(UpdateIdProcess.chatId(update));
        if (botData != null
                && botData.getState().equals(UserState.CREATElINK.name())
        ) {
            try {
                MessageEntity messageEntity = new MessageEntity();
                messageEntity.setType("bold");
                bot.execute(EditMessageCaption.builder()
                        .chatId(UpdateIdProcess.chatId(update))
                        .messageId(UpdateIdProcess.messageId(update))
                        .caption(update.getChannelPost().getCaption() + "\n\n" + botData.getUrl())
                        .build());
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

        }
    }

}





