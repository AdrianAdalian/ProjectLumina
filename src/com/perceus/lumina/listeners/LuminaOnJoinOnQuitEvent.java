package com.perceus.lumina.listeners;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import com.perceus.lumina.SpellControlSystem;
import com.perceus.lumina.spells.holy.SpellMagicMissile;
import com.perceus.lumina.wand.Wand;

public class LuminaOnJoinOnQuitEvent implements Listener
{
	@EventHandler
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
			ItemStack stack = SpellControlSystem.spell_registry.get(new SpellMagicMissile().getName()).getAsItemStack();
			e.getPlayer().sendMessage("Welcome to the server, " + e.getPlayer().getDisplayName() + "!");
			e.getPlayer().getInventory().addItem(wand.getAsItemStack());
			e.getPlayer().getInventory().addItem(stack);
			e.getPlayer().sendMessage("We've given you your first wand! Do /kit to pick your first spell!");
			e.getPlayer().sendMessage("Shift + Right Click to open the wand's spell menu with the wand in hand.");
		}
		e.getPlayer().sendMessage("Welcome Back, " + e.getPlayer().getDisplayName() + "!");
		e.getPlayer().sendMessage("Project Lumina, ONLINE. Running v. (1.0.0)");
	}
	@EventHandler
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
