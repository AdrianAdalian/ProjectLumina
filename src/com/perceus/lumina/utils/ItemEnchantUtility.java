package com.perceus.lumina.utils;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class ItemEnchantUtility extends Spell
{
	private final Enchantment enchant;
	public ItemEnchantUtility(String name, String[] description, int manacost, int cooldown, spelltype type, Enchantment enchant)
	{
		super(name, description, manacost, cooldown, type);
		this.enchant = enchant;
	}
	
	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		ItemStack stack = player.getInventory().getItemInOffHand();
		
		if (stack.getType().equals(Material.AIR)) 
		{
			player.sendMessage("No item(s) detected in offhand.");
			return false;
		}
		
		if (!enchant.canEnchantItem(stack)) 
		{
			player.sendMessage("This item is not compatible with the selected enchantment.");
			return false;
		}
		
		for (Enchantment e : stack.getEnchantments().keySet()) 
		{
			if (e.conflictsWith(enchant)) 
			{
				player.sendMessage("Conflicting enchantment detected.");
				return false;
			}
		}
		
		if (stack.containsEnchantment(enchant)) 
		{
			if (stack.getEnchantmentLevel(enchant) >= enchant.getMaxLevel()) 
			{
				player.sendMessage("This item is already enchanted with the maximum level.");
				return false;
			}
		}
		
		player.playSound(player.getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
		SpellParticle.drawCylinder(player.getLocation(), 1, 50, 4, 1, Particle.ENCHANTMENT_TABLE, null);
		stack.addUnsafeEnchantment(enchant, stack.getEnchantmentLevel(enchant)+1);
		return true;
	}

}
