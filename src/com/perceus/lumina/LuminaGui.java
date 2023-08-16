package com.perceus.lumina;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
		"Lumina GUI: Choose an Item", Set.of(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26),
		"Lumina GUI: Choose a Locale", Set.of(12,13,14),
		"Lumina GUI: Choose a Spell", Set.of(10,11,12,13,14,15,16),
		"Lumina GUI: <Choose a Selection>", Set.of(12,13,14),
		"Lumina GUI: Recharge Wand", Set.of(11,15),
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
			case "Lumina GUI: Choose an Item" ->
			{
				view.setItem(0, new ItemStack(Material.GRASS_BLOCK));
				view.setItem(1, new ItemStack(Material.COBBLESTONE));
				view.setItem(2, new ItemStack(Material.OAK_WOOD));
				view.setItem(3, new ItemStack(Material.SAND));
				view.setItem(4, new ItemStack(Material.GRAVEL));
				view.setItem(5, new ItemStack(Material.ICE));
				view.setItem(6, new ItemStack(Material.COBBLED_DEEPSLATE));
				view.setItem(7, new ItemStack(Material.NETHERRACK));
				view.setItem(8, new ItemStack(Material.END_STONE));
				view.setItem(9, new ItemStack(Material.COAL));
				view.setItem(10, new ItemStack(Material.APPLE));
				view.setItem(11, new ItemStack(Material.REDSTONE));
				view.setItem(12, new ItemStack(Material.STRING));
				view.setItem(13, new ItemStack(Material.QUARTZ));
				view.setItem(14, new ItemStack(Material.AMETHYST_SHARD));
				view.setItem(15, new ItemStack(Material.FLINT));
				view.setItem(16, new ItemStack(Material.LEATHER));
				view.setItem(17, new ItemStack(Material.BONE));
				view.setItem(18, new ItemStack(Material.SLIME_BALL));
				view.setItem(19, new ItemStack(Material.CLAY_BALL));
				view.setItem(20, new ItemStack(Material.PRISMARINE_CRYSTALS));
				view.setItem(21, new ItemStack(Material.HONEYCOMB));
				view.setItem(22, new ItemStack(Material.FEATHER));
				view.setItem(23, new ItemStack(Material.BRICK));
				view.setItem(24, new ItemStack(Material.BLAZE_POWDER));
				view.setItem(25, new ItemStack(Material.GUNPOWDER));
				view.setItem(26, new ItemStack(Material.CHORUS_FRUIT));
			}
		
			case "Lumina GUI: Choose a Locale" ->
			{
				ItemStack stack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
				ItemMeta meta = stack.getItemMeta();
				meta.setDisplayName("_");
				stack.setItemMeta(meta);
				view.setItem(0, stack);
				view.setItem(1, stack);
				view.setItem(2, stack);
				view.setItem(3, stack);
				view.setItem(4, stack);
				view.setItem(5, stack);
				view.setItem(6, stack);
				view.setItem(7, stack);
				view.setItem(8, stack);
				view.setItem(9, stack);
				view.setItem(10, stack);
				view.setItem(11, stack);
				
				ItemStack stack1 = new ItemStack(Material.GRASS_BLOCK);
				ItemMeta meta1 = stack1.getItemMeta();
				meta1.setDisplayName("The Overworld");
				stack1.setItemMeta(meta1);
				view.setItem(12, stack1);
				
				ItemStack stack2 = new ItemStack(Material.NETHERRACK);
				ItemMeta meta2 = stack2.getItemMeta();
				meta2.setDisplayName("The Nether");
				stack2.setItemMeta(meta2);
				view.setItem(13, stack2);
				
				ItemStack stack3 = new ItemStack(Material.END_STONE);
				ItemMeta meta3 = stack3.getItemMeta();
				meta3.setDisplayName("The End");
				stack3.setItemMeta(meta3);
				
				view.setItem(14, stack3);
				view.setItem(15, stack);
				view.setItem(16, stack);
				view.setItem(17, stack);
				view.setItem(18, stack);
				view.setItem(19, stack);
				view.setItem(20, stack);
				view.setItem(21, stack);
				view.setItem(22, stack);
				view.setItem(23, stack);
				view.setItem(24, stack);
				view.setItem(25, stack);
				view.setItem(26, stack);
			}
			case "Lumina GUI: Choose a Spell" ->
			{
				ItemStack stack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
				ItemMeta meta = stack.getItemMeta();
				meta.setDisplayName("_");
				stack.setItemMeta(meta);
				view.setItem(0, stack);
				view.setItem(1, stack);
				view.setItem(2, stack);
				view.setItem(3, stack);
				view.setItem(4, stack);
				view.setItem(5, stack);
				view.setItem(6, stack);
				view.setItem(7, stack);
				view.setItem(8, stack);
				view.setItem(9, stack);
				view.setItem(10, new CantripEmbers().getAsItemStack());
				view.setItem(11, new CantripSoak().getAsItemStack());
				view.setItem(12, new CantripTerraform().getAsItemStack());
				view.setItem(13, new CantripGust().getAsItemStack());
				view.setItem(14, new CantripHealOther().getAsItemStack());
				view.setItem(15, new CantripLifeSteal().getAsItemStack());
				view.setItem(16, new CantripBlink().getAsItemStack());
				view.setItem(17, stack);
				view.setItem(18, stack);
				view.setItem(19, stack);
				view.setItem(20, stack);
				view.setItem(21, stack);
				view.setItem(22, stack);
				view.setItem(23, stack);
				view.setItem(24, stack);
				view.setItem(25, stack);
				view.setItem(26, stack);
			}
		
			case "Lumina GUI: <Choose a Selection>" -> 
			{
				ItemStack stack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
				ItemMeta meta = stack.getItemMeta();
				meta.setDisplayName("_");
				stack.setItemMeta(meta);
				view.setItem(0, stack);
				view.setItem(1, stack);
				view.setItem(2, stack);
				view.setItem(3, stack);
				view.setItem(4, stack);
				view.setItem(5, stack);
				view.setItem(6, stack);
				view.setItem(7, stack);
				view.setItem(8, stack);
				view.setItem(9, stack);
				view.setItem(10, stack);
				view.setItem(11, stack);
				
				ItemStack stack4 = new ItemStack(Material.AMETHYST_CLUSTER);
				ItemMeta meta4 = stack4.getItemMeta();
				meta4.setDisplayName("Recharge Wand");
				stack4.setItemMeta(meta4);
				view.setItem(12, stack4);
				
				ItemStack stack5 = new ItemStack(Material.STICK);
				ItemMeta meta5 = stack5.getItemMeta();
				meta5.setDisplayName("Set Spells");
				stack5.setItemMeta(meta5);
				view.setItem(13, stack5);
				
				ItemStack stack6 = new ItemStack(Material.WRITABLE_BOOK);
				ItemMeta meta6 = stack6.getItemMeta();
				meta6.setDisplayName("Discover Spells");
				stack6.setItemMeta(meta6);
				view.setItem(14, stack6);
				view.setItem(15, stack);
				view.setItem(16, stack);
				view.setItem(17, stack);
				view.setItem(18, stack);
				view.setItem(19, stack);
				view.setItem(20, stack);
				view.setItem(21, stack);
				view.setItem(22, stack);
				view.setItem(23, stack);
				view.setItem(24, stack);
				view.setItem(25, stack);
				view.setItem(26, stack);
			}
			case "Lumina GUI: Recharge Wand" -> 
			{
				ItemStack stack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
				ItemMeta meta = stack.getItemMeta();
				meta.setDisplayName("_");
				stack.setItemMeta(meta);
				view.setItem(0, stack);
				view.setItem(1, stack);
				view.setItem(2, stack);
				view.setItem(3, stack);
				view.setItem(4, stack);
				view.setItem(5, stack);
				view.setItem(6, stack);
				view.setItem(7, stack);
				view.setItem(8, stack);
				view.setItem(9, stack);
				view.setItem(10, stack);
				view.setItem(12, stack);
				view.setItem(14, stack);
				view.setItem(16, stack);
				view.setItem(17, stack);
				view.setItem(18, stack);
				view.setItem(19, stack);
				view.setItem(20, stack);
				view.setItem(21, stack);
				view.setItem(22, stack);
				view.setItem(23, stack);
				view.setItem(24, stack);
				view.setItem(25, stack);
				view.setItem(26, stack);
			}
			case "Lumina GUI: Set Spells" -> 
			{
				ItemStack stack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
				ItemMeta meta = stack.getItemMeta();
				meta.setDisplayName("_");
				stack.setItemMeta(meta);
				
				view.setItem(0, stack);
				view.setItem(1, stack);
				view.setItem(2, stack);
				view.setItem(3, stack);
				view.setItem(4, stack);
				view.setItem(5, stack);
				view.setItem(6, stack);
				view.setItem(7, stack);
				view.setItem(8, stack);
				view.setItem(9, stack);
				view.setItem(10, stack);
				view.setItem(12, stack);
				view.setItem(14, stack);
				view.setItem(16, stack);
				view.setItem(17, stack);
				view.setItem(18, stack);
				view.setItem(19, stack);
				view.setItem(25, stack);
				view.setItem(26, stack);
			}
			case "Lumina GUI: Discover Spells" -> 
			{
				ItemStack stack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
				ItemMeta meta = stack.getItemMeta();
				meta.setDisplayName("_");
				stack.setItemMeta(meta);
				
				ItemStack stack2 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				ItemMeta meta2 = stack2.getItemMeta();
				meta2.setDisplayName("Confirm");
				stack2.setItemMeta(meta2);
				view.setItem(0, stack);
				view.setItem(1, stack);
				view.setItem(2, stack);
				view.setItem(3, stack);
				view.setItem(4, stack);
				view.setItem(5, stack);
				view.setItem(6, stack);
				view.setItem(7, stack);
				view.setItem(8, stack);
				view.setItem(9, stack);
				view.setItem(10, stack2);
				view.setItem(11, stack);
				view.setItem(12, stack);
				view.setItem(14, stack);
				view.setItem(15, stack);
				view.setItem(16, stack2);
				view.setItem(17, stack);
				view.setItem(18, stack);
				view.setItem(19, stack);
				view.setItem(20, stack);
				view.setItem(21, stack);
				view.setItem(22, stack);
				view.setItem(23, stack);
				view.setItem(24, stack);
				view.setItem(25, stack);
				view.setItem(26, stack);
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
				if (e.getView().getItem(11) != null) 
				{
					e.getPlayer().getInventory().addItem(e.getView().getItem(11));
				}
				if (e.getView().getItem(15) != null) 
				{
					e.getPlayer().getInventory().addItem(e.getView().getItem(15));
				}
			}
			case "Lumina GUI: Set Spells" -> 
			{
				if (e.getView().getItem(11) != null) 
				{
					e.getPlayer().getInventory().addItem(e.getView().getItem(11));
				}
				if (e.getView().getItem(15) != null) 
				{					
					e.getPlayer().getInventory().addItem(e.getView().getItem(15));
				}
			}
			case "Lumina GUI: Discover Spells" -> 
			{
				if (e.getView().getItem(13) != null) 
				{
					e.getPlayer().getInventory().addItem(e.getView().getItem(13));
				}
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
		}
		if (e.getClick() == ClickType.SHIFT_LEFT || e.getClick() == ClickType.SHIFT_RIGHT || e.getClick() == ClickType.DOUBLE_CLICK) 
		{
			e.setCancelled(true);
			return;
		}
		
		switch (e.getView().getTitle()) 
		{
			case "Lumina GUI: Choose an Item" ->
			{
				switch (e.getRawSlot()) 
				{
					case 0:
					case 1:
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 7:
					case 8:
					case 9:
					case 10:
					case 11:
					case 12:
					case 13:
					case 14:
					case 15:
					case 16:
					case 17:
					case 18:
					case 19:
					case 20:
					case 21:
					case 22:
					case 23:
					case 24:
					case 25:
					case 26:
					{
											
						Inventory inv = e.getWhoClicked().getInventory();
						ItemStack stack = new ItemStack(e.getView().getItem(e.getRawSlot()));
						stack.setAmount(64);
						inv.addItem(stack);
						e.getWhoClicked().closeInventory();
							
						break;
					}
				}
			}
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
			case "Lumina GUI: Choose a Locale" ->
			{
				switch (e.getRawSlot()) 
				{
					case 12 -> 
					{
						World world = Bukkit.getWorld("world");							
						Location loc1 = world.getSpawnLocation();
						e.getWhoClicked().teleport(loc1);
						e.getWhoClicked().closeInventory();
					}
					case 13 ->
					{
						World nether = Bukkit.getWorld("world_nether");
						Location loc2 = nether.getSpawnLocation();
						e.getWhoClicked().teleport(loc2);
						e.getWhoClicked().closeInventory();
					}
					case 14 ->
					{
						World end = Bukkit.getWorld("world_the_end");
						Location loc3 = end.getSpawnLocation();
						e.getWhoClicked().teleport(loc3);
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
						if (e.getCursor() == null || e.getCursor().getType() != Material.AMETHYST_SHARD) 
						{
							return;
						}
						if (!(Wand.isWand(e.getView().getItem(15)))) 
						{
							return;
						}
						Wand wand = new Wand(e.getView().getItem(15));
						wand.addMana(1000);
						e.getView().setItem(13, wand.getAsItemStack());
					}
					case 13 ->
					{
						if (e.getView().getItem(13) == null) 
						{
							return;
						}
						e.getWhoClicked().getInventory().addItem(e.getView().getItem(13));
						e.getView().setItem(11, null);
						e.getView().setItem(15, null);
						e.getWhoClicked().closeInventory();
					}
					case 15 -> 
					{
						if (e.getCursor() == null || !Wand.isWand(e.getCursor())) 
						{
							return;
						}
						if (e.getView().getItem(11) == null || e.getView().getItem(11).getType() != Material.AMETHYST_SHARD) 
						{
							return;
						}
						Wand wand = new Wand(e.getView().getItem(15));
						wand.addMana(1000);
						e.getView().setItem(13, wand.getAsItemStack());
					}
				}
			}
			case "Lumina GUI: Set Spells" -> 
			{
				switch (e.getRawSlot()) 
				{
					case 11: 
					{	
						if (e.getView().getItem(e.getRawSlot()) != null) 
						{
							e.setCancelled(true);
							return;
						}
						if (e.getCursor() == null || !DataUtils.has("spellbook", e.getCursor())) 
						{
							e.setCancelled(true);
							return;
						}
						if (e.getView().getItem(15) == null || !Wand.isWand(e.getView().getItem(15))) 
						{
							return;
						}
						for (int i = 1 ; i <= 5 ; i++) 
						{							
							ItemStack stack = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
							ItemMeta meta = stack.getItemMeta();
							meta.setDisplayName("Set Slot " + i);
							stack.setItemMeta(meta);
							e.getView().setItem(20 + (i -1), stack);
						}
						break;
					}
					
					case 13:
					{
						if (e.getView().getItem(13) == null) 
						{
							return;
						}
						e.getWhoClicked().getInventory().addItem(e.getView().getItem(13));
						e.getView().setItem(15, null);
						e.getView().setItem(13, null);
						e.getWhoClicked().closeInventory();
						break;
					}
					
					case 15: 
					{
						if (e.getView().getItem(e.getRawSlot()) != null) 
						{
							e.setCancelled(true);
							return;
						}
						if (e.getCursor() == null || !Wand.isWand(e.getCursor())) 
						{
							e.setCancelled(true);
							return;
						}
						if (e.getView().getItem(11) == null || !DataUtils.has("spellbook", e.getView().getItem(11))) 
						{
							return;
						}
						
						for (int i = 1 ; i <= 5 ; i++) 
						{							
							ItemStack stack = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
							ItemMeta meta = stack.getItemMeta();
							meta.setDisplayName("Set Slot " + i);
							stack.setItemMeta(meta);
							e.getView().setItem(20 + (i -1), stack);
						}
						break;
						
					}
					
					case 20:
					case 21:
					case 22:
					case 23:
					case 24:
					{
						if (e.getView().getItem(11) == null || e.getView().getItem(15) == null || !DataUtils.has("spellbook", e.getView().getItem(11)) || !Wand.isWand(e.getView().getItem(15))) 
						{
							return;
						}
						int spellindex = e.getRawSlot() - 20;
						String spellname = DataUtils.get("spellbook", e.getView().getItem(11)).asString();
						Wand wand = new Wand(e.getView().getItem(15));
						
						wand.setSpell(SpellControlSystem.spell_registry.get(spellname), spellindex);
						e.getView().setItem(13, wand.getAsItemStack());
						break;
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
			e.getView().setItem(13, null);
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
