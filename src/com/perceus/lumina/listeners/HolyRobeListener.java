package com.perceus.lumina.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.utils.DataUtils;

public class HolyRobeListener implements Listener
{
	private static List<Player> active_effects = new ArrayList<>();
	
	@EventHandler
	public void onWear(InventoryClickEvent e) 
	{
		if (!e.getWhoClicked().getInventory().getType().equals(InventoryType.PLAYER)) 
		{
			return;
		}
		
		Player p = (Player) e.getWhoClicked();
		for (ItemStack item : e.getWhoClicked().getInventory().getArmorContents())
		{
			if (item == null)
			{
				continue;
			}
			  
			if (item.getType().equals(Material.AIR))
			{
				return;
			}
			
			if (!DataUtils.has("holy_armor", item))
			{
				return;
			}
	    }
		
		if (active_effects.contains(p)) 
		{
			return;
		}
		
		active_effects.add(p);
		
		new BukkitRunnable() 
		  {
			  @Override
			  public void run() 
			  {        
				  if(!p.isOnline())
				  {
					  active_effects.remove((Player) e.getWhoClicked());
					  this.cancel();
					  return;
				  }
				  
				  if (e.getWhoClicked().getInventory().getItem(EquipmentSlot.HEAD).getType().equals(Material.AIR)|| 
						  e.getWhoClicked().getInventory().getItem(EquipmentSlot.CHEST).getType().equals(Material.AIR)||
						  e.getWhoClicked().getInventory().getItem(EquipmentSlot.LEGS).getType().equals(Material.AIR)|| 
						  e.getWhoClicked().getInventory().getItem(EquipmentSlot.FEET).getType().equals(Material.AIR)) 
				  {
					  active_effects.remove((Player) e.getWhoClicked());
					  this.cancel();
					  return;
				  }
				  if (!DataUtils.has("holy_armor", e.getWhoClicked().getInventory().getItem(EquipmentSlot.HEAD))||
						  !DataUtils.has("holy_armor", e.getWhoClicked().getInventory().getItem(EquipmentSlot.CHEST))||
						  !DataUtils.has("holy_armor", e.getWhoClicked().getInventory().getItem(EquipmentSlot.LEGS))||
						  !DataUtils.has("holy_armor", e.getWhoClicked().getInventory().getItem(EquipmentSlot.FEET)))
				  {
					 active_effects.remove((Player) e.getWhoClicked());
					 this.cancel();
					 return;
				  }
				  
				  p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 40, 0, true));
			 }
		 }.runTaskTimer(Lumina.instance, 10, 20);
	     return;
	}
}
