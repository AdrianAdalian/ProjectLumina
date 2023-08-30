package com.perceus.lumina.wand;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem;
import com.perceus.lumina.utils.PrintUtils;

public class Wand
{
	private static int NUMBER_OF_SPELLS = 5;
	private String name;
	private int maxdurability;
	private int currentdurability;
	private Spell[] spellslots = new Spell[NUMBER_OF_SPELLS];
	private int spellindex = 0;
	private static final NamespacedKey wandKey = new NamespacedKey(Lumina.instance,"wandKey");
	private static final NamespacedKey wandKey_maxdurability = new NamespacedKey(Lumina.instance, "wandKey_maxdurability");
	private static final NamespacedKey wandKey_currentdurability = new NamespacedKey(Lumina.instance, "wandKey_currentdurability");
	private static NamespacedKey[] slotKeys = new NamespacedKey[NUMBER_OF_SPELLS];
	private boolean deserialized = false;
	static
	{
		for(int i = 0; i < slotKeys.length; i++)
		{
			slotKeys[i] = new NamespacedKey(Lumina.instance,"slot_" + i);
		}
	}
			
	public static boolean isWand(ItemStack stack) 
	{
		if(stack == null) { return false; }
		if(stack.getType().isAir()) { return false; }
		
		ItemMeta meta = stack.getItemMeta();
		PersistentDataContainer dataContainer = meta.getPersistentDataContainer();
		
		if(!dataContainer.has(wandKey,PersistentDataType.INTEGER)) { return false; }
		return true;
	}
	
	public Wand(String name, int maxdurability) 
	{
		this.name = name;
		this.maxdurability = maxdurability;
		this.currentdurability = maxdurability;
	}
	
	public Wand(ItemStack wand) 
	{
		if (!isWand(wand)) 
		{
			return;
		}
		
		ItemMeta meta = wand.getItemMeta();
		PersistentDataContainer dataContainer = meta.getPersistentDataContainer();
		spellindex = dataContainer.get(wandKey,PersistentDataType.INTEGER);
		name = meta.getDisplayName();
		
		// Get spells
		for(int i = 0; i < NUMBER_OF_SPELLS; i++)
		{
			// If ItemStack does not have a spell in this slot, continue (ignore)
			if(!dataContainer.has(slotKeys[i],PersistentDataType.STRING)) { continue; }
			// Get spells 
			spellslots[i] = SpellControlSystem.spell_registry.get(dataContainer.get(slotKeys[i],PersistentDataType.STRING));
		}
		currentdurability = dataContainer.getOrDefault(wandKey_currentdurability, PersistentDataType.INTEGER, 99999);
		maxdurability = dataContainer.getOrDefault(wandKey_maxdurability, PersistentDataType.INTEGER, 1000);
		deserialized = true;
	}
	
	public ItemStack getAsItemStack()
	{
		ItemStack stack = new ItemStack(Material.STICK, 1);
		ItemMeta meta = stack.getItemMeta();
		PersistentDataContainer dataContainer = meta.getPersistentDataContainer();
		meta.setDisplayName(name);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		dataContainer.set(wandKey,PersistentDataType.INTEGER,spellindex);
		dataContainer.set(wandKey_currentdurability,PersistentDataType.INTEGER,currentdurability);
		dataContainer.set(wandKey_maxdurability,PersistentDataType.INTEGER,maxdurability);
		stack.setItemMeta(meta);
		if(!deserialized)
		{
			// Give wand index
			return stack;
		}
		
		// Set spells
		for(int i = 0; i < NUMBER_OF_SPELLS; i++)
		{
			// If no spell exists in this slot, continue (ignore)
			if(spellslots[i] == null) { continue; }
			
			Spell spell = spellslots[i];
			
			// Store name of spell on the item, this will be used to retrieve the spell later
			dataContainer.set(slotKeys[i],PersistentDataType.STRING,spell.getName());
			
			// If the spell the wand has selected, set the spell lore on the wand
			if(spellindex == i)
			{
				meta.setLore(spell.getLore());
			}
		}
		List<String> existingLore = meta.getLore();
		if (existingLore == null) 
		{
			existingLore = new ArrayList<>();
		}
		existingLore.add("");
		
		existingLore.add(PrintUtils.ColorParser("&r&9Mana&f: " )+ currentdurability + PrintUtils.ColorParser("&r&f/")+ maxdurability);
		meta.setLore(existingLore);
		
		stack.setItemMeta(meta);
		return stack;
	}
	
	public boolean hasSpell(int slot) 
	{
		return spellslots[slot] != null;
	}
	
	public void setSpell(Spell spell, int slot) 
	{
		spellslots[slot] = spell;
	}
	
	public Spell getSpell(int slot) 
	{
		return spellslots[slot];
	}
	
	public int getSpellIndex() 
	{
		return spellindex;
	}
	
	public void removeSpell(int slot) 
	{
		spellslots[slot] = null;
	}
	
	public void removeMana(int amount) 
	{
		currentdurability = currentdurability - amount;
		if (currentdurability < 0) 
		{
			currentdurability = 0;
		}
	}
	
	public void addMana(int amount) 
	{
		currentdurability = currentdurability + amount;
		if (currentdurability > maxdurability || currentdurability < 0) 
		{
			currentdurability = maxdurability;
		}
		
	}
	
	public int getMaxDurability() 
	{
		return maxdurability;
	}
	
	public int getCurrentDurability() 
	{
		return currentdurability;
	}
	
	public Spell getNextSpell() 
	{
		int nextslot = spellindex;
		int count = 0;
		
		while(count < 5) 
		{
			nextslot++;
			count++;
			if (nextslot > NUMBER_OF_SPELLS - 1) 
			{
				nextslot = 0;
			}
			Spell spell = spellslots[nextslot];
			if (spell == null)
			{
				continue;
			}
			return spell;
		}
		return null;
	}
	
	public void rotateSpells() 
	{
		int nextslot = spellindex;
		int count = 0;
		
		while(count < 5) 
		{
			nextslot++;
			count++;
			if (nextslot > NUMBER_OF_SPELLS - 1) 
			{
				nextslot = 0;
			}
			Spell spell = spellslots[nextslot];
			if (spell == null)
			{
				continue;
			}
			spellindex = nextslot;
			return;
		}
		return;
	}
}