package net.pwncraft.kaikz.armorslots;

import org.bukkit.event.player.PlayerListener;

/**
 * Handle events for all Player related events
 * @author Kaikz
 */

public class ASPlayerListener extends PlayerListener {
    private final ArmorSlots plugin;

    public ASPlayerListener(ArmorSlots instance) {
        plugin = instance;
    }
}