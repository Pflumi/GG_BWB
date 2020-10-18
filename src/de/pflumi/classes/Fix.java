package de.pflumi.classes;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

import com.intellectualcrafters.plot.api.PlotAPI;
import com.intellectualcrafters.plot.object.Plot;

public class Fix implements Listener{
	
	public static boolean toggleCancelled;
	
	@EventHandler
	public void onOpenInv(InventoryOpenEvent e) {
		
		Player p = (Player) e.getPlayer();
		
		final PlotAPI plotAPI = new PlotAPI();
		final Plot plotloc = plotAPI.getPlot(p.getLocation());
		
		if(e.getInventory().getName().equalsIgnoreCase("showcase")) {
			
			if(plotloc.getOwners().contains(p.getUniqueId())) {
				
				toggleCancelled = false;
				
			}else {
				
				toggleCancelled = true;
				
			}
			
		}
		
	}
	
	@EventHandler
	
	public void onInvClick(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getName().equalsIgnoreCase("showcase")) {
			
			if(toggleCancelled != false) {
				
				if(!p.hasPermission("gg.showcase.int")) {
				
				e.setCancelled(true);
				
				}
				
			}
			
		}
		
	}
	

}
