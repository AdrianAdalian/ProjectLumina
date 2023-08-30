package com.perceus.lumina.spells.holy;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.utils.GetNearestEntity;

public class SpellDisarm extends Spell
{

	public SpellDisarm()
	{
		super("Disarm", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fDisarm&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &aSupport&f.",
				"&r&fDisarm target player of weapons.",
				"&r&fRange: 15 meters.",
				"&r&fMana cost: 20 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 20, 20, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 15);
		
		if (target == null) 
		{
			player.sendMessage("Invalid Target.");
			return false;
		}
		
		if (!(target instanceof Player)) 
		{
			player.sendMessage("Invalid Target.");
			return false;
		}
		
		List<Material> material = List.of(Material.DIAMOND_SWORD,
				Material.GOLDEN_SWORD,
				Material.IRON_SWORD,
				Material.NETHERITE_SWORD,
				Material.STONE_SWORD,
				Material.WOODEN_SWORD,
				Material.DIAMOND_AXE,
				Material.WOODEN_AXE,
				Material.STONE_AXE,
				Material.IRON_AXE,
				Material.GOLDEN_AXE,
				Material.NETHERITE_AXE,
				Material.BOW);
		
		ItemStack stack = ((Player) target).getInventory().getItemInMainHand();
		
		if (stack == null || !material.contains(stack.getType()))
        {
            player.sendMessage("Valid Item Not Detected in Player's Hand.");
            return false;
        }
		
		if (stack.getType().equals(Material.DIAMOND_SWORD)) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			target.getLocation().getWorld().dropItem(target.getLocation(), stack);
			((Player) target).getInventory().getItemInMainHand().setAmount(0);
			return true;
			
		}
		if (stack.getType().equals(Material.GOLDEN_SWORD)) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			target.getLocation().getWorld().dropItem(target.getLocation(), stack);
			((Player) target).getInventory().getItemInMainHand().setAmount(0);
			return true;
		}
		if (stack.getType().equals(Material.IRON_SWORD)) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			target.getLocation().getWorld().dropItem(target.getLocation(), stack);
			((Player) target).getInventory().getItemInMainHand().setAmount(0);
			return true;
		}
		if (stack.getType().equals(Material.NETHERITE_SWORD)) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			target.getLocation().getWorld().dropItem(target.getLocation(), stack);
			((Player) target).getInventory().getItemInMainHand().setAmount(0);
			return true;
		}
		if (stack.getType().equals(Material.STONE_SWORD)) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			target.getLocation().getWorld().dropItem(target.getLocation(), stack);
			((Player) target).getInventory().getItemInMainHand().setAmount(0);
			return true;
		}
		if (stack.getType().equals(Material.WOODEN_SWORD)) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			target.getLocation().getWorld().dropItem(target.getLocation(), stack);
			((Player) target).getInventory().getItemInMainHand().setAmount(0);
			return true;
		}
		if (stack.getType().equals(Material.WOODEN_AXE)) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			target.getLocation().getWorld().dropItem(target.getLocation(), stack);
			((Player) target).getInventory().getItemInMainHand().setAmount(0);
			return true;
		}
		if (stack.getType().equals(Material.STONE_AXE)) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			target.getLocation().getWorld().dropItem(target.getLocation(), stack);
			((Player) target).getInventory().getItemInMainHand().setAmount(0);
			return true;
		}
		if (stack.getType().equals(Material.IRON_AXE)) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			target.getLocation().getWorld().dropItem(target.getLocation(), stack);
			((Player) target).getInventory().getItemInMainHand().setAmount(0);
			return true;
		}
		if (stack.getType().equals(Material.GOLDEN_AXE)) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			target.getLocation().getWorld().dropItem(target.getLocation(), stack);
			((Player) target).getInventory().getItemInMainHand().setAmount(0);
			return true;
		}
		if (stack.getType().equals(Material.DIAMOND_AXE)) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			target.getLocation().getWorld().dropItem(target.getLocation(), stack);
			((Player) target).getInventory().getItemInMainHand().setAmount(0);
			return true;
		}
		if (stack.getType().equals(Material.NETHERITE_AXE)) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			target.getLocation().getWorld().dropItem(target.getLocation(), stack);
			((Player) target).getInventory().getItemInMainHand().setAmount(0);
			return true;
		}
		if (stack.getType().equals(Material.SHIELD)) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			target.getLocation().getWorld().dropItem(target.getLocation(), stack);
			((Player) target).getInventory().getItemInMainHand().setAmount(0);
			return true;
		}
		player.sendMessage("FIZZLE!");
		return false;
	}

}
