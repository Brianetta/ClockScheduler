package org.ppcis.ClockScheduler;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.TimerTask;

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
public class EventSchedulerTask extends TimerTask {
    @Override
    public void run() {
        // Schedule a task to run immediately, and synchronously
        BukkitRunnable eventTrigger = new BukkitRunnable() {
            public void run() {
                ScheduledEvent event = new ScheduledEvent(scheduledExecutionTime());
                Bukkit.getServer().getPluginManager().callEvent(event);
            }
        };
        eventTrigger.runTask(ClockScheduler.getInstance());
    }
}
