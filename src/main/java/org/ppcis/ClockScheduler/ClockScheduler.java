package org.ppcis.ClockScheduler;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Timer;

/**
 * Copyright © Brian Ronald
 * 14/10/17
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */
public class ClockScheduler extends JavaPlugin {
    private static ClockScheduler instance;
    public static ClockScheduler getInstance() {
        return instance;
    }
    static final int MINUTE_MILLISECONDS = 1000 * 60;
    private EventSchedulerTask eventSchedulerTask;

    @Override
    public void onEnable() {
        // Populate the reference to this Plugin's only instance
        instance = this;
        // Instantiate the event scheduler
        eventSchedulerTask = new EventSchedulerTask();
        // Schedule our event scheduler to run each minute from the start of the next minute
        new Timer().schedule(eventSchedulerTask, (MINUTE_MILLISECONDS - System.currentTimeMillis()%MINUTE_MILLISECONDS), MINUTE_MILLISECONDS);
    }

    @Override
    public void onDisable() {
        eventSchedulerTask.cancel();
    }
}
