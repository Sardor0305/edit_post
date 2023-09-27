package org.example.bot.callback;


import org.example.bot.enam.CallBackDateEnum;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class CallbackProcess {
    public static void process(Update update , TelegramLongPollingBot bot){
        CallBackDateEnum backDate = CallBackDateEnum.of(update.getCallbackQuery().getData());
        switch (backDate){
            case CALLBACK_JOIN -> JoinProcess.process(update,bot);
            case CALLBACK_DELETE -> DeleteProcess.process(update,bot);
        }



    }




}
