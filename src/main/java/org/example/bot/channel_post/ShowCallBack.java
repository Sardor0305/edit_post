package org.example.bot.channel_post;


import org.example.bot.callback.CallBackButtonProc;
import org.example.bot.databse.ExecuteData;
import org.example.bot.utiliy.UpdateIdProcess;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ShowCallBack {
    public static void showBtnProcess(final Update update, final TelegramLongPollingBot bot) {
        if (update.getChannelPost().getText().equals("@Tokhirov_postbot")) {
            if (ExecuteData.fetchChat(UpdateIdProcess.chatId(update)).getChatId() == null) {
                ExecuteData.createChat(UpdateIdProcess.chatId(update), null, null);
            }
            CallBackButtonProc.process(update, bot);

        }
    }
}
