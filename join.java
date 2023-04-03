package com.milenkovo;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.ArrayList;


public class join implements Listener {

	public ArrayList<Player> notifikacia = new ArrayList<>();


	@EventHandler(priority = EventPriority.MONITOR)
	public void onBlockBreakEvent(BlockBreakEvent event){
		 Player player = event.getPlayer();
		 Block block = event.getBlock();


		if (event.isCancelled()) return;
		if (block.getType() == Material.DEEPSLATE_DIAMOND_ORE || block.getType() == Material.DIAMOND_ORE || block.getType() == Material.ANCIENT_DEBRIS)
		notifyAT(player, block);
	}


	public void notifyAT(Player p, Block b){
		for (Player p2 : Bukkit.getServer().getOnlinePlayers()){
			if (p2.hasPermission("antixray.notify")){
				if (notifikacia.contains(p2)){

					TextComponent tc = new TextComponent(("§4§lXRAY §f• §eSkontroluj! §7(§3" + p.getName() + "§7/§3" + b.getType().name().trim() + "§7)"));
					TextComponent tc2 = new  TextComponent("§a [TP]");
					tc2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpo" + p.getName()));
					TextComponent tc3 = new TextComponent("§4[BAN]");
					tc3.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/gtempban " + p.getName() + " 90d Cheating // Xray"));
					TextComponent tc4 = new TextComponent("§7[LB]");
					tc4.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/lb lookup time 15m coords player " + p.getName()));

					tc.addExtra(tc2);
					tc2.addExtra(tc3);
					tc3.addExtra(tc4);
					p2.spigot().sendMessage(tc);
				}

			}
		}
	}




}
