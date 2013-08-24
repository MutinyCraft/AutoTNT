package com.mutinycraft.jigsaw.AutoTNT;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * User: Jigsaw
 * Date: 8/23/13
 * Time: 10:25 PM
 */

public class AutoTNT extends JavaPlugin implements Listener {

    private Logger log;

    public void onEnable() {
        log = getLogger();
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void blockPlaceEvent(BlockPlaceEvent event) {
        Block b = event.getBlock();
        if(b.getTypeId() == 46){
            b.setType(Material.AIR);
            b.getWorld().spawn(b.getLocation(), TNTPrimed.class);
        }
    }

}
