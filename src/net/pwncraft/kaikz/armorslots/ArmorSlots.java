package net.pwncraft.kaikz.armorslots;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;
import java.util.HashMap;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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
    
    // Console logger
    Logger log = Logger.getLogger("Minecraft");
    
    // Permissions
    public static PermissionHandler Permissions = null;

    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        
        setupPermissions();
       
        PluginDescriptionFile pdfFile = this.getDescription();
        System.out.println(pdfFile.getName() + " v" + pdfFile.getVersion() + " is enabled!" );
    }
    
    private void setupPermissions() {
        Plugin permissionsPlugin = this.getServer().getPluginManager().getPlugin("Permissions");
        
        if (this.Permissions == null) {
            if (permissionsPlugin != null) {
                this.Permissions = ((Permissions) permissionsPlugin).getHandler();
            } else {
                log.info("[ArmorSlots] Permissions system not found. Disabling.");
                getServer().getPluginManager().disablePlugin(this);
            }
        }
    }
    
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
                    ItemStack itemHand = player.getItemInHand();
                    PlayerInventory inventory = player.getInventory();
                    inventory.remove(itemHand);
                    inventory.setHelmet(itemHand);
                    player.sendMessage(ChatColor.GREEN + "Hat set!");
                    return true;
                }
            }
        } else if (commandLabel.equalsIgnoreCase("chest")) {
            if (Permissions.has(player, "armorslots.chest")) {
                if (player.getItemInHand().getTypeId() == 0) {
                    player.sendMessage(ChatColor.RED + "You have nothing in your hand!");
                    return true;
                } else {
                    ItemStack itemHand = player.getItemInHand();
                    PlayerInventory inventory = player.getInventory();
                    inventory.remove(itemHand);
                    inventory.setChestplate(itemHand);
                    player.sendMessage(ChatColor.GREEN + "Chestplate set!");
                    return true;
                }
            }
        } else if (commandLabel.equalsIgnoreCase("leggings")) {
            if (Permissions.has(player, "armorslots.leggings")) {
                if (player.getItemInHand().getTypeId() == 0) {
                    player.sendMessage(ChatColor.RED + "You have nothing in your hand!");
                    return true;
                } else {
                    ItemStack itemHand = player.getItemInHand();
                    PlayerInventory inventory = player.getInventory();
                    inventory.remove(itemHand);
                    inventory.setLeggings(itemHand);
                    player.sendMessage(ChatColor.GREEN + "Leggings set!");
                    return true;
                }
            }
        } else if (commandLabel.equalsIgnoreCase("boots")) {
            if (Permissions.has(player, "armorslots.boots")) {
                if (player.getItemInHand().getTypeId() == 0) {
                    player.sendMessage(ChatColor.RED + "You have nothing in your hand!");
                    return true;
                } else {
                    ItemStack itemHand = player.getItemInHand();
                    PlayerInventory inventory = player.getInventory();
                    inventory.remove(itemHand);
                    inventory.setBoots(itemHand);
                    player.sendMessage(ChatColor.GREEN + "Boots set!");
                    return true;
                }
            }
        }
        return false;
    }
}