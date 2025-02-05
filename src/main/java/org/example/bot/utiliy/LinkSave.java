package org.example.bot.utiliy;

import org.example.bot.entitiy.BotDataEntity;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LinkSave {
    public static final Map<Long, BotDataEntity> SAVE_LINK_MAP = new HashMap<>();
}







