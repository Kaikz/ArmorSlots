/*
 * (Kaikz ~ http://pwncraft.net)
 *
 * THIS PLUGIN IS LICENSED UNDER THE WTFPL - (Do What The Fuck You Want To Public License)
 *
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details.
 *
 * TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *
 * 0. You just DO WHAT THE FUCK YOU WANT TO.
 *
 * */
package me.freeplaynz.armorslots;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Handle events for all Player related events
 * @author Kaikz
 */
public class ASPlayerListener extends PlayerListener {

    private final ArmorSlots plugin;

    public ASPlayerListener(ArmorSlots instance) {
        plugin = instance;
    }

    @Override
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (ArmorSlots.fireArmor == true) {
            Location loc = player.getLocation().getBlock().getLocation().subtract(0.0D, 1.0D, 0.0D);
            if ((loc.getBlock().getType() == Material.STATIONARY_WATER) || (loc.getBlock().getType() == Material.WATER)) {
                ArmorSlots.fireArmor = false;
            }
        }
    }
}