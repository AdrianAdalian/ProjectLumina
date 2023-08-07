package com.perceus.lumina;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

import com.perceus.lumina.wand.Wand;

public class LuminaGui implements Listener
{
	public static Map<Player, InventoryView> inGUI = new HashMap<>();
	public InventoryView openGUI(Player player, Inventory inv) 
	{
		inGUI.put(player, player.openInventory(inv));
		return inGUI.get(player);
	}
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent e) 
	{
		if (!inGUI.containsKey(e.getPlayer())) 
		{
			return;
		}
		switch (e.getView().getTitle()) 
		{
			case "Lumina GUI: <CHOOSE A SELECTION>" -> 
			{
				
			}
			case "Lumina GUI: Recharge Wand" -> 
			{
				e.getPlayer().getInventory().addItem(e.getView().getItem(11));
				e.getPlayer().getInventory().addItem(e.getView().getItem(15));
			}
			case "Lumina GUI: Set Spells" -> 
			{
				e.getPlayer().getInventory().addItem(e.getView().getItem(11));
				e.getPlayer().getInventory().addItem(e.getView().getItem(15));
			}
			case "Lumina GUI: Descover Spells" -> 
			{
				e.getPlayer().getInventory().addItem(e.getView().getItem(13));
			}
		}
		inGUI.remove(e.getPlayer());
	}
	@EventHandler
	public void onInventoryQuit(PlayerQuitEvent e) 
	{
		if (!inGUI.containsKey(e.getPlayer())) 
		{
			return;
		}
		switch (e.getPlayer().getOpenInventory().getTitle()) 
		{
			case "Lumina GUI: <CHOOSE A SELECTION>" -> 
			{
				
			}
			case "Lumina GUI: Recharge Wand" -> 
			{
				e.getPlayer().getInventory().addItem(e.getPlayer().getOpenInventory().getItem(11));
				e.getPlayer().getInventory().addItem(e.getPlayer().getOpenInventory().getItem(15));
			}
			case "Lumina GUI: Set Spells" -> 
			{
				e.getPlayer().getInventory().addItem(e.getPlayer().getOpenInventory().getItem(11));
				e.getPlayer().getInventory().addItem(e.getPlayer().getOpenInventory().getItem(15));
			}
			case "Lumina GUI: Descover Spells" -> 
			{
				e.getPlayer().getInventory().addItem(e.getPlayer().getOpenInventory().getItem(13));
			}
		}
		inGUI.remove(e.getPlayer());
		
	}
	@EventHandler
	public void onInteractWithWand(PlayerInteractEvent e) 
	{
		
		if (e.getHand() == EquipmentSlot.OFF_HAND) 
		{
			return;
		}
		
		if(!Wand.isWand(e.getPlayer().getInventory().getItemInMainHand())) { return; }
		
		if (e.getPlayer().isSneaking() && e.getAction() == Action.RIGHT_CLICK_AIR) 
		{
			openGUI(e.getPlayer(), Bukkit.createInventory(null, 27));
		}
	}
}
