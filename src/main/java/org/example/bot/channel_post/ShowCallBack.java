package org.example.bot.channel_post;


import org.example.bot.callback.CallBackButtonProc;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ShowCallBack {
    public static void showBtnProcess(Update update, TelegramLongPollingBot bot){
        if(update.getChannelPost().getText().equals("@Raximov14_bot")){
            CallBackButtonProc.process(update, bot);

        }
    }
}
