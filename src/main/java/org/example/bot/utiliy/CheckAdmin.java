package org.example.bot.utiliy;


import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMember;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.chatmember.ChatMember;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CheckAdmin {
    public static boolean isChannelAdmin(Update update, TelegramLongPollingBot bot) {
;
        GetChatMember member = new GetChatMember();
        member.setChatId(UpdateIdProcess.chatId(update));
        member.setUserId(UpdateIdProcess.userId(update));///userId

        try {
            ChatMember member1 = bot.execute(member);
            if (member1.getStatus().equals("administrator") ||
                    member1.getStatus().equals("creator")) {
                return true;
            }
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        return false;
    }




    }


