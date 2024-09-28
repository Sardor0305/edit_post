package org.example.bot.utiliy;

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
    public static final Map<Long, String> SAVE_LINK_MAP = new HashMap<>();

    private static final String FILE = "src/main/resources/data.text";
    private static final String TEMP_FILE = "src/main/resources/temp_data.text";

    public static String read(Long chatId) {
        if (SAVE_LINK_MAP.containsKey(chatId)) {
            return SAVE_LINK_MAP.get(chatId);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(chatId.toString())) {
                    return line.split(":")[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void save(Long chatId, String link) {
        SAVE_LINK_MAP.put(chatId, link);
        if (chatId != null && link != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE,true))) {
                bw.write(chatId.toString());
                bw.write(":");
                bw.write(link);
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void remove(Long chatId) {
        SAVE_LINK_MAP.remove(chatId);
        File tempFile = new File(TEMP_FILE);
        try (
                BufferedReader reader = new BufferedReader(new FileReader(FILE));
                BufferedWriter writer = new BufferedWriter(new FileWriter(TEMP_FILE, true))
        ) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (!currentLine.startsWith(chatId.toString())) {
                    writer.write(currentLine);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        new File(FILE).delete();
        tempFile.renameTo(new File(FILE));
    }
}







