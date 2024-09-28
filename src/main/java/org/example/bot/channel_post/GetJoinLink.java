package org.example.bot.channel_post;
import org.example.bot.enam.UserState;
import org.example.bot.utiliy.LinkSave;
import org.example.bot.utiliy.UpdateIdProcess;
import org.example.bot.utiliy.UserButtonState;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class GetJoinLink {
    public static void process(Update update, TelegramLongPollingBot bot){

            if (UserButtonState.USER_BUTTON_STATE_MAP.containsKey(UpdateIdProcess.chatId(update)) &&
        UserButtonState.USER_BUTTON_STATE_MAP.get(UpdateIdProcess.chatId(update)).equals(UserState.DEFAULT)) {

                UserButtonState.USER_BUTTON_STATE_MAP.put(UpdateIdProcess.chatId(update),UserState.CREATElINK);
              LinkSave.save(UpdateIdProcess.chatId(update),update.getChannelPost().getText());
                try {
                    bot.execute(SendMessage.builder()
                                    .chatId(update.getChannelPost().getChatId())
//                                    .messageId(update.getChannelPost().getMessageId())
                                    .text("✅ Link shu ko'rinishda bo'ladi\n\n" +
                                            "\uD83D\uDC47\uD83D\uDC47\uD83D\uDC47 \n\n" +
                                            LinkSave.read(UpdateIdProcess.chatId(update))+"\n\n" +
                                            "\uD83D\uDC46\uD83D\uDC46\uD83D\uDC46 \n")

                            .build());

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }



}
