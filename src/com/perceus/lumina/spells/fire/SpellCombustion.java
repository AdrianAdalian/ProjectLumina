package com.perceus.lumina.spells.fire;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellCombustion extends Spell
{

	public SpellCombustion()
	{
		super("Combustion", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fCombustion&r&7&ko&r",
				"&r&fElement: &r&cFire&r&f.",
				"&r&fSpell Type: &bUtility&f.", 
				"&r&fAllows the caster to smelt any ore in offhand.",
				"&r&fCobbled stones are smeltable.",
				"&r&fMana cost: 50 &r&9mana&r&f."
		}, 50, 100, spelltype.FIRE);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		ItemStack stack = event.getPlayer().getInventory().getItemInOffHand();
		
		List<Material> material = List.of(Material.RAW_COPPER, 
				Material.RAW_GOLD, 
				Material.RAW_IRON, 
				Material.RAW_COPPER_BLOCK, 
				Material.RAW_GOLD_BLOCK,
				Material.RAW_IRON_BLOCK,
				Material.COAL_ORE,
				Material.DEEPSLATE_COAL_ORE,
				Material.DEEPSLATE_COPPER_ORE,
				Material.DEEPSLATE_DIAMOND_ORE,
				Material.DEEPSLATE_EMERALD_ORE,
				Material.DEEPSLATE_GOLD_ORE,
				Material.DEEPSLATE_IRON_ORE,
				Material.DEEPSLATE_LAPIS_ORE,
				Material.DEEPSLATE_REDSTONE_ORE,
				Material.DIAMOND_ORE,
				Material.EMERALD_ORE,
				Material.GOLD_ORE,
				Material.IRON_ORE,
				Material.LAPIS_ORE,
				Material.REDSTONE_ORE,
				Material.COBBLESTONE,
				Material.COBBLED_DEEPSLATE,
				Material.COPPER_ORE);
		
		if (stack == null || !material.contains(stack.getType()))
        {
            player.sendMessage("Valid Item Not Detected in Offhand.");
            return false;
        }
		
        if (stack.getType() == Material.COPPER_ORE) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.COPPER_INGOT);
			return true;
		}
        
		if (stack.getType() == Material.RAW_IRON) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.IRON_INGOT);
			return true;
		}
		if (stack.getType() == Material.RAW_GOLD) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.GOLD_INGOT);
			return true;
		}
		if (stack.getType() == Material.RAW_COPPER) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.COPPER_INGOT);
			return true;
		}
		if (stack.getType() == Material.RAW_IRON_BLOCK) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.IRON_BLOCK);
			return true;
		}
		if (stack.getType() == Material.RAW_GOLD_BLOCK) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.GOLD_BLOCK);
			return true;
		}
		if (stack.getType() == Material.RAW_COPPER_BLOCK) 
		{ 
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.COPPER_BLOCK);
			return true;
		}
		if (stack.getType() == Material.COAL_ORE) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.COAL);
			return true;
		}
		if (stack.getType() == Material.DEEPSLATE_COAL_ORE) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.COAL);
			return true;
		}
		if (stack.getType() == Material.DEEPSLATE_COPPER_ORE) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.COPPER_INGOT);
			return true;
		}
		if (stack.getType() == Material.DEEPSLATE_DIAMOND_ORE) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.DIAMOND);
			return true;
		}
		if (stack.getType() == Material.DEEPSLATE_EMERALD_ORE) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.EMERALD);
			return true;
		}
		if (stack.getType() == Material.DEEPSLATE_GOLD_ORE) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.GOLD_INGOT);
			return true;
		}
		if (stack.getType() == Material.DEEPSLATE_IRON_ORE) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.IRON_INGOT);
			return true;
		}
		if (stack.getType() == Material.DEEPSLATE_LAPIS_ORE) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.LAPIS_LAZULI);
			return true;
		}
		if (stack.getType() == Material.DEEPSLATE_REDSTONE_ORE) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.REDSTONE);
			return true;
		}
		if (stack.getType() == Material.DIAMOND_ORE) 
		{ 
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.DIAMOND);
			return true;
		}
		if (stack.getType() == Material.EMERALD_ORE) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.EMERALD);
			return true;
		}
		if (stack.getType() == Material.IRON_ORE) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.IRON_INGOT);
			return true;
		}
		if (stack.getType() == Material.GOLD_ORE) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.GOLD_INGOT);
			return true;
		}
		if (stack.getType() == Material.LAPIS_ORE) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.LAPIS_LAZULI);
			return true;
		}
		if (stack.getType() == Material.REDSTONE_ORE) 
		{ 
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.REDSTONE);
			return true;
		}
		if (stack.getType() == Material.COBBLESTONE) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.STONE);
			return true;
		}
		if (stack.getType() == Material.COBBLED_DEEPSLATE) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			event.getPlayer().getInventory().getItemInOffHand().setType(Material.DEEPSLATE);
			return true;
		}
		player.sendMessage("FIZZLE!");
		return false;
	}

}
