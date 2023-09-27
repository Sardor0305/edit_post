package org.example.bot.channel_post;


import org.example.bot.enam.UserState;
import org.example.bot.utiliy.LinkSave;
import org.example.bot.utiliy.UpdateIdProcess;
import org.example.bot.utiliy.UserButtonState;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageCaption;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ChannelPostProcess {
    public static void process(Update update, TelegramLongPollingBot bot) {


        System.out.println(update.getChannelPost());

        if (LinkSave.SAVE_LINK_MAP.containsKey(UpdateIdProcess.chatId(update))
                && UserButtonState.USER_BUTTON_STATE_MAP.containsKey(update.getChannelPost().getChatId())
                && UserButtonState.USER_BUTTON_STATE_MAP.get(update.getChannelPost().getChatId()).equals(UserState.CREATElINK)
        ) {


            try {
                String username = LinkSave.SAVE_LINK_MAP.get(UpdateIdProcess.chatId(update));
                MessageEntity messageEntity = new MessageEntity();
                messageEntity.setType("bold");
                bot.execute(EditMessageCaption.builder()
                        .chatId(UpdateIdProcess.chatId(update))
                        .messageId(UpdateIdProcess.messageId(update))
                        .caption(update.getChannelPost().getCaption() + "\n\n" + username)
                        .build());
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

        }
    }

}





