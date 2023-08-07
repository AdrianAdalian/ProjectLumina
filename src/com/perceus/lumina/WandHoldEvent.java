package com.perceus.lumina;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.scheduler.BukkitTask;

import com.perceus.lumina.wand.Wand;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class WandHoldEvent implements Listener
{
	private static Map<Player, BukkitTask> activeTasks = new HashMap<>();
	@EventHandler
	public void onJoin(PlayerJoinEvent e) 
	{
		BukkitTask task = Bukkit.getScheduler().runTaskTimer(Lumina.instance, ()->
		{
			Wand wand = null;
			if (Wand.isWand(e.getPlayer().getInventory().getItem(EquipmentSlot.HAND)))
			{
			    wand = new Wand(e.getPlayer().getInventory().getItem(EquipmentSlot.HAND));
			}
	
			if (Wand.isWand(e.getPlayer().getInventory().getItem(EquipmentSlot.OFF_HAND)) && wand == null)
			{
			    wand = new Wand(e.getPlayer().getInventory().getItem(EquipmentSlot.OFF_HAND));
			}
	
			if (wand == null)
			{
				return;
			}
			e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("Current Mana: " + wand.getCurrentDurability() + "/" + wand.getMaxDurability()));
		}, 0l, 5l);
		activeTasks.put(e.getPlayer(), task);
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) 
	{
		activeTasks.get(e.getPlayer()).cancel();
		activeTasks.remove(e.getPlayer());
	}
}
