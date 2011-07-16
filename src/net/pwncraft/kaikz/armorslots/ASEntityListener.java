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

package net.pwncraft.kaikz.armorslots;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class ASEntityListener extends EntityListener {
    public static ArmorSlots plugin;
    public static ItemStack playerHelmet;
    public static ItemStack playerChestplate;
    public static ItemStack playerLeggings;
    public static ItemStack playerBoots;

    public ASEntityListener(ArmorSlots instance) {
	plugin = instance;
    }
        
    @Override
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            PlayerInventory inv = player.getInventory();
                
            if (inv.getHelmet() != null) {
                playerHelmet = inv.getHelmet();
            } else if (inv.getChestplate() != null) {
                playerChestplate = inv.getChestplate();
            } else if (inv.getLeggings() != null) {
                playerLeggings = inv.getLeggings();
            } else if (inv.getBoots() != null) {
                playerBoots = inv.getBoots();
            }
        }
    }
    
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        PlayerInventory inv = player.getInventory();
        
        if (playerHelmet != null) {
            inv.setHelmet(playerHelmet);
        } else if (playerChestplate != null) {
            inv.setChestplate(playerChestplate);
        } else if (playerLeggings != null) {
            inv.setLeggings(playerLeggings);
        } else if (playerBoots != null) {
            inv.setBoots(playerBoots);
        }
    }
    
    @Override
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.isCancelled()) {
            return;
        }
        
        if ((event.getCause() == EntityDamageEvent.DamageCause.DROWNING) && ((event.getEntity() instanceof Player))) {
            Player player = (Player)event.getEntity(); event.getEntity();
            if (ArmorSlots.Permissions.has(player, "armorslots.scuba")) {
                if ((player.getInventory().getHelmet().getTypeId() == 20) || (player.getInventory().getHelmet().getTypeId() == 86)) {
                    Location loc = player.getLocation().getBlock().getLocation().add(0.0D, 1.0D, 0.0D);
                    if ((loc.getBlock().getType() == Material.STATIONARY_WATER) || (loc.getBlock().getType() == Material.WATER)) {
                        player.setRemainingAir(player.getMaximumAir());
                        event.setCancelled(true);
                    }
                }
            }
        }
        
        if ((event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION ) && ((event.getEntity() instanceof Player))) {
            Player player = (Player)event.getEntity(); event.getEntity();
            if (ArmorSlots.Permissions.has(player, "armorslots.explosion")) {
                if ((player.getInventory().getHelmet().getTypeId() == 46)) {
                    event.setCancelled(true);
                }
            }
        }
        
        if ((event.getCause() == EntityDamageEvent.DamageCause.CONTACT ) && ((event.getEntity() instanceof Player))) {
            Player player = (Player)event.getEntity(); event.getEntity();
            if (ArmorSlots.Permissions.has(player, "armorslots.contact")) {
                if ((player.getInventory().getHelmet().getTypeId() == 81)) {
                    event.setCancelled(true);
                }
            }
        }
        
        if ((event.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK ) && ((event.getEntity() instanceof Player))) {
            Player player = (Player)event.getEntity(); event.getEntity();
            if (ArmorSlots.Permissions.has(player, "armorslots.attacked")) {
                if ((player.getInventory().getHelmet().getTypeId() == 52)) {
                    event.setCancelled(true);
                }
            }
        }
        
        if ((event.getCause() == EntityDamageEvent.DamageCause.VOID ) && ((event.getEntity() instanceof Player))) {
            Player player = (Player)event.getEntity(); event.getEntity();
            if (ArmorSlots.Permissions.has(player, "armorslots.void")) {
                if ((player.getInventory().getHelmet().getTypeId() == 90)) {
                    event.setCancelled(true);
                }
            }
        }
        
        if ((event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK ) && ((event.getEntity() instanceof Player))) {
            Player player = (Player)event.getEntity(); event.getEntity();
            if (ArmorSlots.Permissions.has(player, "armorslots.firearmor")) {
                if ((ArmorSlots.fireArmor == true)) {
                    event.setCancelled(true);
                }
                Location loc = player.getLocation().getBlock().getLocation().add(0.0D, 1.0D, 0.0D);
                if ((loc.getBlock().getType() == Material.STATIONARY_WATER) || (loc.getBlock().getType() == Material.WATER)) {
                    player.setFireTicks(0);
                    ArmorSlots.fireArmor = false;
                }
            }
        }
        
        if (((event.getCause() == EntityDamageEvent.DamageCause.LAVA ) || (event.getCause() == EntityDamageEvent.DamageCause.FIRE )) && (event.getEntity() instanceof Player)) {
            Player player = (Player)event.getEntity(); event.getEntity();
            if (ArmorSlots.Permissions.has(player, "armorslots.firearmor")) {
                if (ArmorSlots.fireArmor == true) {
                    event.setCancelled(true);
                }
            }
        }
        
        if ((event.getCause() == EntityDamageEvent.DamageCause.FALL ) && ((event.getEntity() instanceof Player))) {
            Player player = (Player)event.getEntity(); event.getEntity();
            if (ArmorSlots.Permissions.has(player, "armorslots.fallboots")) {
                if ((player.getInventory().getBoots().getTypeId() == 317)) {
                    event.setCancelled(true);
                }
            }
        }
    }
}