/*
 * (Kaikz ~ http://freeplaynz.me)
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

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * ArmorSlots for Bukkit
 *
 * @author Kaikz
 */
public class ArmorSlots extends JavaPlugin {
    // Stuff
    public ItemStack hat;
    public ItemStack chestplate;
    public ItemStack leggings;
    public ItemStack boots;
    public static boolean fireArmor = false;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ASListener(), this);
        PluginDescriptionFile pdfFile = this.getDescription();
        System.out.println(pdfFile.getName() + " v" + pdfFile.getVersion() + " is enabled!");
    }
    
    public static boolean hasPermission(Player player, String perms) {
        if (player.hasPermission(perms)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onDisable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        System.out.println(pdfFile.getName() + " v" + pdfFile.getVersion() + " is disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;
        if (!(sender instanceof Player)) {
            return false;
        }

        if (commandLabel.equalsIgnoreCase("hat")) {
            if (hasPermission(player, "armorslots.hat")) {
                if (player.getItemInHand().getTypeId() == 0) {
                    player.sendMessage(ChatColor.RED + "You have nothing in your hand!");
                    return true;
                } else {
                    PlayerInventory inventory = player.getInventory();
                    ItemStack itemHand = player.getItemInHand();
                    if (inventory.getHelmet().getTypeId() != 0) {
                        hat = inventory.getHelmet();
                    }
                    inventory.setHelmet(new ItemStack(itemHand.getTypeId(), 1, itemHand.getDurability()));
                    if (itemHand.getAmount() > 1) {
                        itemHand.setAmount(itemHand.getAmount() - 1);
                    } else {
                        inventory.remove(itemHand);
                    }
                    if (hat != null) {
                        inventory.setItemInHand(hat);
                    }
                    player.sendMessage(ChatColor.GREEN + "Hat set!");
                    hat = null;
                    return true;
                }
            }
        } else if (commandLabel.equalsIgnoreCase("chestplate")) {
            if (hasPermission(player, "armorslots.chestplate")) {
                if (player.getItemInHand().getTypeId() == 0) {
                    player.sendMessage(ChatColor.RED + "You have nothing in your hand!");
                    return true;
                } else {
                    PlayerInventory inventory = player.getInventory();
                    ItemStack itemHand = player.getItemInHand();
                    if (inventory.getChestplate().getTypeId() != 0) {
                        chestplate = inventory.getChestplate();
                    }
                    inventory.setChestplate(new ItemStack(itemHand.getTypeId(), 1, itemHand.getDurability()));
                    if (itemHand.getAmount() > 1) {
                        itemHand.setAmount(itemHand.getAmount() - 1);
                    } else {
                        inventory.remove(itemHand);
                    }
                    if (chestplate != null) {
                        inventory.setItemInHand(chestplate);
                    }
                    player.sendMessage(ChatColor.GREEN + "Chestplate set!");
                    chestplate = null;
                    return true;
                }
            }
        } else if (commandLabel.equalsIgnoreCase("leggings")) {
            if (hasPermission(player, "armorslots.leggings")) {
                if (player.getItemInHand().getTypeId() == 0) {
                    player.sendMessage(ChatColor.RED + "You have nothing in your hand!");
                    return true;
                } else {
                    PlayerInventory inventory = player.getInventory();
                    ItemStack itemHand = player.getItemInHand();
                    if (inventory.getLeggings().getTypeId() != 0) {
                        leggings = inventory.getLeggings();
                    }
                    inventory.setLeggings(new ItemStack(itemHand.getTypeId(), 1, itemHand.getDurability()));
                    if (itemHand.getAmount() > 1) {
                        itemHand.setAmount(itemHand.getAmount() - 1);
                    } else {
                        inventory.remove(itemHand);
                    }
                    if (leggings != null) {
                        inventory.setItemInHand(leggings);
                    }
                    player.sendMessage(ChatColor.GREEN + "Leggings set!");
                    leggings = null;
                    return true;
                }
            }
        } else if (commandLabel.equalsIgnoreCase("boots")) {
            if (hasPermission(player, "armorslots.boots")) {
                if (player.getItemInHand().getTypeId() == 0) {
                    player.sendMessage(ChatColor.RED + "You have nothing in your hand!");
                    return true;
                } else {
                    PlayerInventory inventory = player.getInventory();
                    ItemStack itemHand = player.getItemInHand();
                    if (inventory.getBoots().getTypeId() != 0) {
                        boots = inventory.getBoots();
                    }
                    inventory.setBoots(new ItemStack(itemHand.getTypeId(), 1, itemHand.getDurability()));
                    if (itemHand.getAmount() > 1) {
                        itemHand.setAmount(itemHand.getAmount() - 1);
                    } else {
                        inventory.remove(itemHand);
                    }
                    if (boots != null) {
                        inventory.setItemInHand(boots);
                    }
                    player.sendMessage(ChatColor.GREEN + "Boots set!");
                    boots = null;
                    return true;
                }
            }
        } else if (commandLabel.equalsIgnoreCase("armor")) {
            if (args.length < 0) {
                player.sendMessage(ChatColor.RED + "You didn't give us an armor type!");
                return true;
            } else if (args.length == 1) {
                PlayerInventory inventory = player.getInventory();
                if ((args[0].equalsIgnoreCase("diamond") || args[0].equalsIgnoreCase("d")) && (hasPermission(player, "armorslots.diamondarmor"))) {
                    inventory.setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
                    inventory.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
                    inventory.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
                    inventory.setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
                    player.sendMessage(ChatColor.GREEN + "Armor: Diamond set!");
                    return true;
                } else if ((args[0].equalsIgnoreCase("gold") || args[0].equalsIgnoreCase("g")) && (hasPermission(player, "armorslots.goldarmor"))) {
                    inventory.setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
                    inventory.setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
                    inventory.setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
                    inventory.setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
                    player.sendMessage(ChatColor.GREEN + "Armor: Gold set!");
                    return true;
                } else if ((args[0].equalsIgnoreCase("iron") || args[0].equalsIgnoreCase("i")) && (hasPermission(player, "armorslots.ironarmor"))) {
                    inventory.setHelmet(new ItemStack(Material.IRON_HELMET, 1));
                    inventory.setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
                    inventory.setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
                    inventory.setBoots(new ItemStack(Material.IRON_BOOTS, 1));
                    player.sendMessage(ChatColor.GREEN + "Armor: Iron set!");
                    return true;
                } else if ((args[0].equalsIgnoreCase("chainmail") || args[0].equalsIgnoreCase("c")) && (hasPermission(player, "armorslots.chainmailarmor"))) {
                    inventory.setHelmet(new ItemStack(Material.CHAINMAIL_HELMET, 1));
                    inventory.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
                    inventory.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
                    inventory.setBoots(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
                    player.sendMessage(ChatColor.GREEN + "Armor: Chainmail set!");
                    return true;
                } else if ((args[0].equalsIgnoreCase("leather") || args[0].equalsIgnoreCase("l")) && (hasPermission(player, "armorslots.leatherarmor"))) {
                    inventory.setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
                    inventory.setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
                    inventory.setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
                    inventory.setBoots(new ItemStack(Material.LEATHER_BOOTS, 1));
                    player.sendMessage(ChatColor.GREEN + "Armor: Leather set!");
                    return true;
                } else if ((args[0].equalsIgnoreCase("fire") || args[0].equalsIgnoreCase("f")) && (hasPermission(player, "armorslots.firearmor"))) {
                    if (fireArmor == false) {
                        player.setFireTicks(90000);
                        fireArmor = true;
                        player.sendMessage(ChatColor.GREEN + "Armor: Fire set!");
                        return true;
                    } else if (fireArmor == true) {
                        player.setFireTicks(0);
                        fireArmor = false;
                        player.sendMessage(ChatColor.GREEN + "Armor: Fire removed!");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}