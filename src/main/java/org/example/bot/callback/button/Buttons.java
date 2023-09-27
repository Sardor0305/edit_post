package org.example.bot.callback.button;


import org.example.bot.enam.CallBackDateEnum;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public class Buttons {

    public static InlineKeyboardButton BTN_JOIN  = InlineKeyboardButton.builder()
            .callbackData(CallBackDateEnum.CALLBACK_JOIN.getVal())
            .text("Havola matnini kiritish")
            .build();
    public static InlineKeyboardButton BTN_DELETE  = InlineKeyboardButton.builder()
            .callbackData(CallBackDateEnum.CALLBACK_DELETE.getVal())
            .text("Havolani o’chirish")
            .build();


}
