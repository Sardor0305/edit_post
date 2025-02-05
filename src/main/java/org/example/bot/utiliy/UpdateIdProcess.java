package org.example.bot.utiliy;

import org.telegram.telegrambots.meta.api.objects.Update;

public class UpdateIdProcess {
    public static Long chatId(final Update update) {
        if (update.hasMessage()) {
            return update.getMessage().getChatId();

        } else if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getMessage().getChatId();
        } else if (update.hasChannelPost()) {
            return update.getChannelPost().getChatId();
        }

        throw new RuntimeException();
    }

    public static Integer messageId(final Update update) {
        if (update.hasMessage()) {
            return update.getMessage().getMessageId();
        } else if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getMessage().getMessageId();
        } else if (update.hasChannelPost()) {
            return update.getChannelPost().getMessageId();
        }
        throw new RuntimeException();

    }

    public static Long userId(final Update update) {
        if (update.hasMessage()) {
            return update.getMessage().getFrom().getId();
        } else if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getFrom().getId();
        } else if (update.hasChannelPost()) {
            return update.getChannelPost().getFrom().getId();
        }

        throw new RuntimeException();
    }


}
