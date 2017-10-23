# ClockScheduler for Bukkit #

This plugin fires a synchronous Event every real-time minute. The Event
contains the hour and minute that it was scheduled, as well as methods
returning the number of ticks or milliseconds that have elapsed since that
time.

## Installation ##

Place the `.jar file into your plugins folder and start your Bukkit server (or
load it with any plugin manager). The plugin has no configuration, and has no
permissions.

## Use ##

This plugin's events can be handled like any other Bukkit event. The following
plugin gives an example:

```java
package org.ppcis.ClockSchedulerTest;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.ppcis.ClockScheduler.ScheduledEvent;

public class ClockSchedulerTest extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        ScheduledEvent.getHandlerList().unregister((Plugin) this);
    }

    @EventHandler
    public void onScheduledEvent(ScheduledEvent event) {
        this.getLogger().info(String.format("Responding to event at %d:%2d (delay is %d ticks)", event.hours(), event.minutes(), event.delayInTicks()));
    }

}

```

## Building ##

This is a [Maven](https://maven.apache.org/) project. If you have Maven and the
Java JDK in your path, you can build the plugin by cloning this repository, and
from the project root directory running `mvn package`. The resulting `.jar` file
will appear in the target folder.

## Using from other Bukkit plugins ##

If you wish to use this plugin in your own projects, simply include the `.jar`
in your project's dependencies.

If you use Maven, you can install it into your local repository by using `mvn
clean install`. You can then include the dependency in your Maven project by
including the following in the dependencies section of your project's `pom.xml`:

```xml
        <dependency>
            <groupId>org.ppcis</groupId>
            <artifactId>ClockScheduler</artifactId>
            <version>1.0.0</version>
            <scope>provided</scope>
        </dependency>
``` 
 