package org.example.bot;

import org.example.bot.callback.CallbackProcess;
import org.example.bot.channel_post.ChannelPostProcess;
import org.example.bot.channel_post.GetJoinLink;
import org.example.bot.channel_post.ShowCallBack;
import org.example.bot.text.StartState;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.LongPollingBot;

public class JoinlinkBot extends TelegramLongPollingBot {

    public JoinlinkBot() {
        super("7027650865:AAHlCdoJORA0tp-rn02YVQxX-d5bmb2Cb88");
    }


    @Override
    public void onUpdateReceived(final Update update) {
        if (update.hasMessage()) {
            if (update.getMessage().hasText()) {
                StartState.startProcess(update, this);
            }

        } else if (update.hasCallbackQuery()) {
            CallbackProcess.process(update, this);

        } else if (update.hasChannelPost() &&
                update.getChannelPost().getCaption() != null
                && update.getChannelPost().getForwardFromChat() == null
                && update.getChannelPost().getForwardFrom() == null) {
            ChannelPostProcess.process(update, this);
        } else if (update.hasChannelPost() && update.getChannelPost().hasText()) {
            ShowCallBack.showBtnProcess(update, this);
            GetJoinLink.process(update, this);
        }

    }

    @Override
    public String getBotUsername() {
        return "Tokhirov_postbot";
    }
}
