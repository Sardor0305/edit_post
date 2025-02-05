package org.example.bot.schedule;

import org.example.bot.utiliy.LinkSave;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleTask {
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void schedule() {
        scheduler.scheduleAtFixedRate(LinkSave.SAVE_LINK_MAP::clear, 0, 7, TimeUnit.DAYS);
    }
}
