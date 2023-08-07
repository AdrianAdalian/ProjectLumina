package com.perceus.lumina.spells.holy;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.GetNearestEntity;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellHealingHands extends Spell
{

	public SpellHealingHands()
	{
		super("HealingHands", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fHealing Hands&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &aSupport&f.",
				"&r&fFully &aHeals&f target player.",
				"&r&fRange: 10 meters.",
				"&r&fMana cost: 50 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 50, 20, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 10);
		if (target == null) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		if (!(target instanceof Player)) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		if (((Player) target).getHealth() == ((Attributable) target).getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) 
		{
			player.sendMessage("That player is already at maximum health.");
			return false;
		}
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
		((Player) target).playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
		((Damageable) target).setHealth(event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
		return true;
	}

}
