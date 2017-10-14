package org.ppcis.ClockScheduler;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.Calendar;
import java.util.Date;

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

// This is the event which will be triggered by the scheduler each minute
public class ScheduledEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    // These three members all hold the same thing: the time this event was scheduled
    private long scheduledTimeMilliseconds;
    private Date scheduledDate;
    private Calendar scheduledCalendar;
    // Handy constant
    private static int MILLISECONDS_PER_TICK = 50;

    public ScheduledEvent(long scheduledTime) {
        // The time we were meant to be run
        this.scheduledTimeMilliseconds = scheduledTime;
        scheduledDate = new Date();
        scheduledDate.setTime(scheduledTime);
        scheduledCalendar = Calendar.getInstance();
        scheduledCalendar.setTime(scheduledDate);
    }

    public long delayInTicks() {
        // The number of ticks since we were meant to run
        // Not expecting to use this, but it might be handy
        return (scheduledTimeMilliseconds - System.currentTimeMillis()) / MILLISECONDS_PER_TICK;
    }

    public long delayInSeconds() {
        // The number of seconds since we were meant to run
        // Not expecting to use this, but it might be handy
        return (scheduledTimeMilliseconds - System.currentTimeMillis()) / 1000;
    }

    public int hours() {
        // The time of the current hour
        return scheduledCalendar.get(Calendar.HOUR_OF_DAY);
    }

    public int minutes() {
        return scheduledCalendar.get(Calendar.MINUTE);
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
