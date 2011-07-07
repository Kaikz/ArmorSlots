package net.pwncraft.kaikz.armorslots;

import org.bukkit.entity.Player;
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
}