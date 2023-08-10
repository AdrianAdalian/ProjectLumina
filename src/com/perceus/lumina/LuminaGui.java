package com.perceus.lumina;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.spells.cantrips.CantripBlink;
import com.perceus.lumina.spells.cantrips.CantripEmbers;
import com.perceus.lumina.spells.cantrips.CantripGust;
import com.perceus.lumina.spells.cantrips.CantripHealOther;
import com.perceus.lumina.spells.cantrips.CantripLifeSteal;
import com.perceus.lumina.spells.cantrips.CantripSoak;
import com.perceus.lumina.spells.cantrips.CantripTerraform;
import com.perceus.lumina.utils.DataUtils;
import com.perceus.lumina.wand.Wand;

public class LuminaGui implements Listener
{
	private static Map<String, Set<Integer>> white_listed_slots = 
	Map.of(
		"Lumina GUI: Choose a Spell", Set.of(10,11,12,13,14,15,16),
		"Lumina GUI: <Choose a Selection>", Set.of(13,14,15),
		"Lumina GUI: Recharge Wand", Set.of(11, 13,15),
		"Lumina GUI: Set Spells", Set.of(11, 13, 15),
		"Lumina GUI: Discover Spells", Set.of(10, 13, 16)
	);
	public static Map<Player, InventoryView> inGUI = new HashMap<>();
	public static InventoryView openGUI(Player player, Inventory inv) 
	{
		inGUI.put(player, player.openInventory(inv));
		InventoryView view = inGUI.get(player);
		switch (view.getTitle()) 
		{
		
			case "Lumina GUI: Choose a Spell" ->
			{
				view.setItem(10, new CantripEmbers().getAsItemStack());
				view.setItem(11, new CantripSoak().getAsItemStack());
				view.setItem(12, new CantripTerraform().getAsItemStack());
				view.setItem(13, new CantripGust().getAsItemStack());
				view.setItem(14, new CantripHealOther().getAsItemStack());
				view.setItem(15, new CantripLifeSteal().getAsItemStack());
				view.setItem(16, new CantripBlink().getAsItemStack());
			}
		
			case "Lumina GUI: <Choose a Selection>" -> 
			{
				view.setItem(12, new ItemStack(Material.AMETHYST_CLUSTER));
				view.setItem(13, new ItemStack(Material.STICK));
				view.setItem(14, new ItemStack(Material.WRITABLE_BOOK));
			}
			case "Lumina GUI: Recharge Wand" -> 
			{
				
			}
			case "Lumina GUI: Set Spells" -> 
			{
				
			}
			case "Lumina GUI: Discover Spells" -> 
			{
				view.setItem(4, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
				view.setItem(10, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
				view.setItem(12, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
				view.setItem(14, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
				view.setItem(16, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
				view.setItem(22, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));

			}
			default ->
			{
				PrintUtils.Print("THIS IS NOT A GUI");
			}
		}
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
			case "Lumina GUI: <Choose a Selection>" -> 
			{
				
			}
			case "Lumina GUI: Recharge Wand" -> 
			{
				if (e.getView().getItem(11) == null) 
				{
					return;
				}
				if (e.getView().getItem(15) == null) 
				{
					return;
				}
				e.getPlayer().getInventory().addItem(e.getView().getItem(11));
				e.getPlayer().getInventory().addItem(e.getView().getItem(15));
			}
			case "Lumina GUI: Set Spells" -> 
			{
				if (e.getView().getItem(11) == null) 
				{
					return;
				}
				if (e.getView().getItem(15) == null) 
				{
					return;
				}
				e.getPlayer().getInventory().addItem(e.getView().getItem(11));
				e.getPlayer().getInventory().addItem(e.getView().getItem(15));
			}
			case "Lumina GUI: Discover Spells" -> 
			{
				if (e.getView().getItem(13) == null) 
				{
					return;
				}
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
			case "Lumina GUI: <Choose a Selection>" -> 
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
			case "Lumina GUI: Discover Spells" -> 
			{
				e.getPlayer().getInventory().addItem(e.getPlayer().getOpenInventory().getItem(13));
			}
		}
		inGUI.remove(e.getPlayer());
		
	}
	@EventHandler
	public void onClick(InventoryClickEvent e) 
	{
		
		
		if (!e.getView().getTitle().startsWith("Lumina GUI")) 
		{
			return;
		}
		
		if (e.getRawSlot() < 0) 
		{
			return;
		}
		
		if (!white_listed_slots.get(e.getView().getTitle()).contains(e.getRawSlot()) && e.getRawSlot() < e.getView().getTopInventory().getSize()) 
		{
			e.setCancelled(true);
			return;
		}
		
		switch (e.getView().getTitle()) 
		{
			case "Lumina GUI: Choose a Spell" ->
			{
				switch (e.getRawSlot()) 
				{
					case 10 -> 
					{
						e.getWhoClicked().getInventory().addItem(new CantripEmbers().getAsItemStack());
						e.getWhoClicked().closeInventory();
					}
					case 11 -> 
					{
						e.getWhoClicked().getInventory().addItem(new CantripSoak().getAsItemStack());
						e.getWhoClicked().closeInventory();
					}
					case 12 -> 
					{
						e.getWhoClicked().getInventory().addItem(new CantripTerraform().getAsItemStack());
						e.getWhoClicked().closeInventory();
					}
					case 13 -> 
					{
						e.getWhoClicked().getInventory().addItem(new CantripGust().getAsItemStack());
						e.getWhoClicked().closeInventory();
					}
					case 14 -> 
					{
						e.getWhoClicked().getInventory().addItem(new CantripHealOther().getAsItemStack());
						e.getWhoClicked().closeInventory();
					}
					case 15 -> 
					{
						e.getWhoClicked().getInventory().addItem(new CantripLifeSteal().getAsItemStack());
						e.getWhoClicked().closeInventory();
					}
					case 16 -> 
					{
						e.getWhoClicked().getInventory().addItem(new CantripBlink().getAsItemStack());
						e.getWhoClicked().closeInventory();
					}
				}
			}
		}
		
		switch (e.getView().getTitle()) 
		{
			case "Lumina GUI: <Choose a Selection>" -> 
			{
				switch (e.getRawSlot()) 
				{
					case 12 -> openGUI((Player) e.getWhoClicked(), Bukkit.createInventory(null, 27, "Lumina GUI: Recharge Wand"));
					case 13 -> openGUI((Player) e.getWhoClicked(), Bukkit.createInventory(null, 27, "Lumina GUI: Set Spells"));
					case 14 -> openGUI((Player) e.getWhoClicked(), Bukkit.createInventory(null, 27, "Lumina GUI: Discover Spells"));
				}
			}
			case "Lumina GUI: Recharge Wand" -> 
			{
				switch (e.getRawSlot()) 
				{
					case 11 -> 
					{
						
					}
					case 15 -> 
					{
						
					}
				}
			}
			case "Lumina GUI: Set Spells" -> 
			{
				switch (e.getRawSlot()) 
				{
					case 11 -> 
					{
						
					}
					case 15 -> 
					{
						
					}
				}
			}
			case "Lumina GUI: Discover Spells" -> 
			{
				switch (e.getRawSlot()) 
				{
				
					case 10 ->
					{
						e.setCancelled(true);
						clickedGreenButtonInDiscovery(e);
					}
				
					case 13 -> 
					{
						switch (e.getAction()) 
						{
							case PICKUP_ALL ->
							{
								
							}
							
							case PLACE_ALL ->
							{
								
							}
							
							default -> e.setCancelled(true);
						}
					}
					
					case 16 ->
					{
						e.setCancelled(true);
						clickedGreenButtonInDiscovery(e);
					}
				}
			}
		}
	}
	
	public int getRandom(int low, int high) 
	{
		return ThreadLocalRandom.current().nextInt(low, high + 1);
	}
	
	public void clickedGreenButtonInDiscovery(InventoryClickEvent e) 
	{
		if (e.getView().getItem(13) == null) 
		{
			return;
		}
		if (DataUtils.has("grimoire", e.getView().getItem(13))) 
		{

			for (int i = e.getView().getItem(13).getAmount() ; i >= 1 ; i--) 
			{
				spelltype type = spelltype.valueOf(DataUtils.get("grimoire", e.getView().getItem(13)).asString());
				List<Spell> spells = SpellControlSystem.protoregistry.get(type);
				int chosenspellindex = getRandom(0, spells.size() - 1);
				Spell chosenspell = spells.get(chosenspellindex);
				HashMap<Integer, ItemStack> returneditems = e.getWhoClicked().getInventory().addItem(chosenspell.getAsItemStack());
				if (!returneditems.isEmpty()) 
				{
					e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(), returneditems.entrySet().iterator().next().getValue());
				}
			}
			e.getWhoClicked().closeInventory();
		}
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
			openGUI(e.getPlayer(), Bukkit.createInventory(null, 27, "Lumina GUI: <Choose a Selection>"));	
		}
	}
}
