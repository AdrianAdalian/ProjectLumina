package com.perceus.lumina.spells.fire;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellRebrand extends Spell
{

	public SpellRebrand()
	{
		super("Rebrand", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fRebrand&r&7&ko&r",
				"&r&fElement: &r&cFire&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fRepairs offhand item to full durability.",
				"&r&fExcludes The Magic Wand.",
				"&r&fMana cost: 50 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 50, 20, spelltype.FIRE);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		ItemStack item = event.getPlayer().getInventory().getItemInOffHand();
		if (item == null) 
		{
			player.sendMessage("Valid Item Not Detected in Offhand.");
			return false;
		}
		if (item.getType().equals(Material.AIR))
		{
		  player.sendMessage("Valid Item Not Detected in Offhand.");
		  return false;
		}
		
		if (!(item.getItemMeta() instanceof Damageable))
		{
		  player.sendMessage("Valid Item Not Detected in Offhand.");
		  return false;
		}
		
		Damageable meta = (Damageable) item.getItemMeta();
		 
		if (!meta.hasDamage())
		{
		  player.sendMessage("This item is at maximum durability or is not applicable.");
		  return false;
		}
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_CONDUIT_ACTIVATE, SoundCategory.MASTER, 1, 1);
		meta.setDamage(0); 
		item.setItemMeta(meta);
		return true;
	}

}
