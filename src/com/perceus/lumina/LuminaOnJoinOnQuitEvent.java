package com.perceus.lumina;

import org.bukkit.GameMode;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.perceus.lumina.wand.Wand;

public class LuminaOnJoinOnQuitEvent implements Listener
{
	public void onJoin(PlayerJoinEvent e) 
	{
		if (!e.getPlayer().isOp()) 
		{
			e.getPlayer().setGameMode(GameMode.SURVIVAL);
			e.getPlayer().setAllowFlight(false);
			e.getPlayer().setFlying(false);
		}
		
		if (!e.getPlayer().hasPlayedBefore()) 
		{
			Wand wand = new Wand(e.getPlayer().getInventory().getItemInMainHand());
			e.getPlayer().sendMessage("Welcome to the server, " + e.getPlayer().getDisplayName() + "!");
			e.getPlayer().getInventory().addItem(wand.getAsItemStack());
			e.getPlayer().sendMessage("We've given you your first wand! Do /kit to pick your first spell!");
			e.getPlayer().sendMessage("Shift + Right Click to open the wand's spell menu with the wand in hand.");
		}
		e.getPlayer().sendMessage("Welcome Back, " + e.getPlayer().getDisplayName() + "!");
		
	}
	
	public void onQuit(PlayerQuitEvent e) 
	{
		if (!e.getPlayer().isOp()) 
		{
			e.getPlayer().setGameMode(GameMode.SURVIVAL);
			e.getPlayer().setAllowFlight(false);
			e.getPlayer().setFlying(false);
		}
	}
}
