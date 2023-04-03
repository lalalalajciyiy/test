package com.milenkovo;

import org.bukkit.plugin.java.JavaPlugin;

public final class XrayMain extends JavaPlugin {

	@Override
	public void onEnable() {

		getServer().getPluginManager().registerEvents(new join(), this);

		getConfig().options().copyDefaults();
		saveDefaultConfig();



	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
