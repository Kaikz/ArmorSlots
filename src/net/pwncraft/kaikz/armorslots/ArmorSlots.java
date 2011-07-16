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

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;
import java.util.HashMap;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

/**
 * ArmorSlots for Bukkit
 *
 * @author Kaikz
 */

public class ArmorSlots extends JavaPlugin {
    private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();
    private final ASPlayerListener playerListener = new ASPlayerListener(this);
    private final ASEntityListener entityListener = new ASEntityListener(this);
    private final ASWeatherListener weatherListener = new ASWeatherListener(this);
    
    // Console logger
    static final Logger log = Logger.getLogger("Minecraft");
    
    // Permissions
    public static PermissionHandler Permissions = null;
    
    // Stuff
    public ItemStack hat;
    public ItemStack chestplate;
    public ItemStack leggings;
    public ItemStack boots;
    public static boolean fireArmor = false;

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvent(Event.Type.ENTITY_DAMAGE, entityListener, Priority.Normal, this);
        pm.registerEvent(Event.Type.PLAYER_MOVE, playerListener, Priority.Normal, this);
        pm.registerEvent(Event.Type.WEATHER_CHANGE, weatherListener, Priority.Normal, this);
        
        setupPermissions();
       
        PluginDescriptionFile pdfFile = this.getDescription();
        System.out.println(pdfFile.getName() + " v" + pdfFile.getVersion() + " is enabled!" );
    }
    
    private void setupPermissions() {
        Plugin permissionsPlugin = this.getServer().getPluginManager().getPlugin("Permissions");
        
        if (ArmorSlots.Permissions == null) {
            if (permissionsPlugin != null) {
                ArmorSlots.Permissions = ((Permissions) permissionsPlugin).getHandler();
            } else {
                log.info("[ArmorSlots] Permissions system not found. Disabling.");
                getServer().getPluginManager().disablePlugin(this);
            }
        }
    }
    
    @Override
    public void onDisable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        System.out.println(pdfFile.getName() + " v" + pdfFile.getVersion() + " is disabled!" );
    }
    
    public boolean isDebugging(final Player player) {
        if (debugees.containsKey(player)) {
            return debugees.get(player);
        } else {
            return false;
        }
    }

    public void setDebugging(final Player player, final boolean value) {
        debugees.put(player, value);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player)sender;
        
        if (commandLabel.equalsIgnoreCase("hat")) {
            if (Permissions.has(player, "armorslots.hat")) {
                if (player.getItemInHand().getTypeId() == 0) {
                    player.sendMessage(ChatColor.RED + "You have nothing in your hand!");
                    return true;
                } else {
                    PlayerInventory inventory = player.getInventory();
                    ItemStack itemHand = player.getItemInHand();
                    if (inventory.getHelmet().getTypeId() != 0) {
                        hat = inventory.getHelmet();
                    }
                    inventory.remove(itemHand);
                    inventory.setHelmet(itemHand);
                    if (hat != null) {
                        inventory.setItemInHand(hat);
                    }
                    player.sendMessage(ChatColor.GREEN + "Hat set!");
                    hat = null;
                    return true;
                }
            }
        } else if (commandLabel.equalsIgnoreCase("chestplate")) {
            if (Permissions.has(player, "armorslots.chestplate")) {
                if (player.getItemInHand().getTypeId() == 0) {
                    player.sendMessage(ChatColor.RED + "You have nothing in your hand!");
                    return true;
                } else {
                    PlayerInventory inventory = player.getInventory();
                    ItemStack itemHand = player.getItemInHand();
                    if (inventory.getChestplate().getTypeId() != 0) {
                        chestplate = inventory.getChestplate();
                    }
                    inventory.remove(itemHand);
                    inventory.setChestplate(itemHand);
                    if (chestplate != null) {
                        inventory.setItemInHand(chestplate);
                    }
                    player.sendMessage(ChatColor.GREEN + "Chestplate set!");
                    chestplate = null;
                    return true;
                }
            }
        } else if (commandLabel.equalsIgnoreCase("leggings")) {
            if (Permissions.has(player, "armorslots.leggings")) {
                if (player.getItemInHand().getTypeId() == 0) {
                    player.sendMessage(ChatColor.RED + "You have nothing in your hand!");
                    return true;
                } else {
                    PlayerInventory inventory = player.getInventory();
                    ItemStack itemHand = player.getItemInHand();
                    if (inventory.getLeggings().getTypeId() != 0) {
                        leggings = inventory.getLeggings();
                    }
                    inventory.remove(itemHand);
                    inventory.setLeggings(itemHand);
                    if (leggings != null) {
                        inventory.setItemInHand(leggings);
                    }
                    player.sendMessage(ChatColor.GREEN + "Leggings set!");
                    leggings = null;
                    return true;
                }
            }
        } else if (commandLabel.equalsIgnoreCase("boots")) {
            if (Permissions.has(player, "armorslots.boots")) {
                if (player.getItemInHand().getTypeId() == 0) {
                    player.sendMessage(ChatColor.RED + "You have nothing in your hand!");
                    return true;
                } else {
                    PlayerInventory inventory = player.getInventory();
                    ItemStack itemHand = player.getItemInHand();
                    if (inventory.getBoots().getTypeId() != 0) {
                        boots = inventory.getBoots();
                    }
                    inventory.remove(itemHand);
                    inventory.setBoots(itemHand);
                    if (boots != null) {
                        inventory.setItemInHand(boots);
                    }
                    player.sendMessage(ChatColor.GREEN + "Boots set!");
                    boots = null;
                    return true;
                }
            }
        } else if (commandLabel.equalsIgnoreCase("firearmor")) {
            if (Permissions.has(player, "armorslots.firearmor")) {
                if (fireArmor == false) {
                    player.setFireTicks(90000);
                    fireArmor = true;
                    return true;
                } else if (fireArmor == true) {
                    player.setFireTicks(0);
                    fireArmor = false;
                    return true;
                }
            }
        }
        return false;
    }
}