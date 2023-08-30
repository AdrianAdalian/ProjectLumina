package com.perceus.lumina;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.BookMeta.Generation;
import org.bukkit.inventory.meta.ItemMeta;

import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.utils.DataUtils;
import com.perceus.lumina.utils.PrintUtils;
import com.perceus.lumina.utils.DataUtils.DType;

public abstract class Spell
{
	private int manacost;
	private int cooldown;
	private String name;
	private String[] description;
	private spelltype type;
	
	public Spell(String name, String[] description, int manacost, int cooldown, spelltype type)
	{
		this.manacost = manacost;
		this.cooldown = cooldown;
		this.name = name;
		this.description = description;
		this.type = type;
	}
	
	public spelltype getSpellType() 
	{
		return type;
	}
	
	public int getManacost()
	{
		return manacost;
	}
	
	public int getCooldown()
	{
		return cooldown;
	}

	public String getName()
	{
		return name;
	}

	public String[] getDescription()
	{
		return description;
	}
	
	public abstract boolean Cast(Player player, PlayerInteractEvent event);
	
	public List<String> getLore() 
	{
		List<String> lore = new ArrayList<>();
		for (String line : description) 
		{
			lore.add(PrintUtils.ColorParser(line));
		}
		return lore;
	}
	
	public ItemStack getAsItemStack() 
	{
		
		ItemStack stack = new ItemStack(Material.WRITTEN_BOOK, 1);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("Spellbook: " + name);
		List<String> lore = new ArrayList<>();
		for (String line : description) 
		{
			lore.add(PrintUtils.ColorParser(line));
		}
		lore.add(PrintUtils.ColorParser("&bMana Cost&f: " + manacost));
		lore.add(PrintUtils.ColorParser("&fCooldown: " + cooldown + " &fsecond(s)."));
		stack.setItemMeta(meta);
		BookMeta bookmeta = (BookMeta) stack.getItemMeta();
		bookmeta.setTitle(name);
		bookmeta.setAuthor(PrintUtils.ColorParser("&koooooo"));
		bookmeta.setGeneration(Generation.TATTERED);
		
		StringBuilder sb = new StringBuilder();
		Arrays.asList(description).forEach(line ->
		{
			sb.append(line.replace("&f", "&0") + '\n');
		});
		
		bookmeta.addPage(PrintUtils.ColorParser(sb.toString()));
		stack.setItemMeta(bookmeta);
		DataUtils.set("spellbook", DType.STRING, name, stack);
		return stack;
	}
}
