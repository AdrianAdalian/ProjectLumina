package com.perceus.lumina.spells.geo;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellTransmute extends Spell
{

	public SpellTransmute()
	{
		super("Transmute", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fTransmute&r&7&ko&r",
				"&r&fElement: &r&6Geo&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fTransmutes target ore-item in", 
				"&r&foffhand to the next rarity.",
				"&r&fMana cost: 100 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 100, 20, spelltype.GEO);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		ItemStack stack = player.getInventory().getItemInOffHand();
		
		List<Material> material = List.of(Material.RAW_COPPER, 
				Material.RAW_GOLD, 
				Material.RAW_IRON, 
				Material.COAL_ORE,
				Material.DEEPSLATE_COAL_ORE,
				Material.DEEPSLATE_COPPER_ORE,
				Material.DEEPSLATE_DIAMOND_ORE,
				Material.DEEPSLATE_EMERALD_ORE,
				Material.DEEPSLATE_GOLD_ORE,
				Material.DEEPSLATE_IRON_ORE,
				Material.DEEPSLATE_LAPIS_ORE,
				Material.DIAMOND_ORE,
				Material.EMERALD_ORE,
				Material.GOLD_ORE,
				Material.IRON_ORE,
				Material.LAPIS_ORE,
				Material.REDSTONE_ORE,
				Material.LAPIS_LAZULI,
				Material.COAL,
				Material.COPPER_ORE,
				Material.DIAMOND);
        
        if (stack == null || !material.contains(stack.getType()))
        {
            player.sendMessage("Non-valid item in offhand.");
            return false;
        }
        //precious gemstones & copper
        if (stack.getType() == Material.RAW_COPPER) 
		{
			player.playSound(player.getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			player.getInventory().getItemInOffHand().setType(Material.LAPIS_LAZULI);
			return true;
		}
        if (stack.getType() == Material.LAPIS_LAZULI) 
		{
			player.playSound(player.getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			player.getInventory().getItemInOffHand().setType(Material.EMERALD);
			return true;
		}
        if (stack.getType() == Material.COPPER_ORE) 
		{
			player.playSound(player.getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			player.getInventory().getItemInOffHand().setType(Material.LAPIS_ORE);
			return true;
		}
        if (stack.getType() == Material.LAPIS_ORE) 
		{
			player.playSound(player.getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			player.getInventory().getItemInOffHand().setType(Material.EMERALD_ORE);
			return true;
		}
        if (stack.getType() == Material.DEEPSLATE_COPPER_ORE) 
		{
			player.playSound(player.getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			player.getInventory().getItemInOffHand().setType(Material.DEEPSLATE_LAPIS_ORE);
			return true;
		}
        if (stack.getType() == Material.DEEPSLATE_LAPIS_ORE) 
		{
			player.playSound(player.getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			player.getInventory().getItemInOffHand().setType(Material.DEEPSLATE_EMERALD_ORE);
			return true;
		}
        if (stack.getType() == Material.COAL) 
		{
			player.playSound(player.getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			player.getInventory().getItemInOffHand().setType(Material.RAW_IRON);
			return true;
		}
        if (stack.getType() == Material.RAW_IRON) 
		{
			player.playSound(player.getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			player.getInventory().getItemInOffHand().setType(Material.RAW_GOLD);
			return true;
		}
        if (stack.getType() == Material.RAW_GOLD) 
		{
			player.playSound(player.getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			player.getInventory().getItemInOffHand().setType(Material.DIAMOND);
			return true;
		}
        if (stack.getType() == Material.DIAMOND) 
		{
			player.playSound(player.getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			player.getInventory().getItemInOffHand().setType(Material.NETHERITE_SCRAP);
			return true;
		}
        
        if (stack.getType() == Material.COAL_ORE) 
		{
			player.playSound(player.getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			player.getInventory().getItemInOffHand().setType(Material.IRON_ORE);
			return true;
		}
        if (stack.getType() == Material.IRON_ORE) 
		{
			player.playSound(player.getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			player.getInventory().getItemInOffHand().setType(Material.GOLD_ORE);
			return true;
		}
        if (stack.getType() == Material.GOLD_ORE) 
		{
			player.playSound(player.getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			player.getInventory().getItemInOffHand().setType(Material.DIAMOND_ORE);
			return true;
		}
        if (stack.getType() == Material.DIAMOND_ORE) 
		{
			player.playSound(player.getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			player.getInventory().getItemInOffHand().setType(Material.ANCIENT_DEBRIS);
			return true;
		}
        
        //deepslate ores
        
        if (stack.getType() == Material.DEEPSLATE_COAL_ORE) 
		{
			player.playSound(player.getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			player.getInventory().getItemInOffHand().setType(Material.DEEPSLATE_IRON_ORE);
			return true;
		}
        if (stack.getType() == Material.DEEPSLATE_IRON_ORE) 
		{
			player.playSound(player.getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			player.getInventory().getItemInOffHand().setType(Material.DEEPSLATE_GOLD_ORE);
			return true;
		}
        if (stack.getType() == Material.DEEPSLATE_GOLD_ORE) 
		{
			player.playSound(player.getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			player.getInventory().getItemInOffHand().setType(Material.DEEPSLATE_DIAMOND_ORE);
			return true;
		}
        if (stack.getType() == Material.DEEPSLATE_DIAMOND_ORE) 
		{
			player.playSound(player.getLocation(), Sound.BLOCK_SMITHING_TABLE_USE, SoundCategory.MASTER, 1, 1);
			player.getInventory().getItemInOffHand().setType(Material.ANCIENT_DEBRIS);
			return true;
		}
        player.sendMessage("Fizzle!");
        return false;
	}

}
