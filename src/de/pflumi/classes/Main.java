package de.pflumi.classes;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public static String prefix = "§8[§6GrieferGames§8] ";
	
	public void onEnable() {
		
		Bukkit.getConsoleSender().sendMessage(prefix + "Das Showcase Plugin wurde erfolgreich geladen.");
		
		Bukkit.getPluginManager().registerEvents(new Fix(),this);
		
	}

}
