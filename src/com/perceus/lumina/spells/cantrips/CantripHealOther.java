package com.perceus.lumina.spells.cantrips;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.utils.GetNearestEntity;
import com.perceus.lumina.utils.SpellParticle;

public class CantripHealOther extends Spell
{

	public CantripHealOther()
	{
		super("HealOther", new String[] {
				"&r&e&ko&r&7&lCantrip: &r&fHeal Other&r&e&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &aSupport &eCantrip&f.",
				"&r&aHeals &r&f5 hearts to target player.", 
				"&r&fRange: 5 meters.",
				"&r&fMana cost: 0 &r&9mana&r&f.",
				"&r&fCooldown: 2 seconds."
		}, 0, 40, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 5);
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
		SpellParticle.drawCircle(player.getLocation(), 2, 180, Particle.CLOUD, null);
		try
		{
			SpellParticle.drawLine(player.getLocation(), target.getLocation(), 2, Particle.CLOUD, null);
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			((Player) target).playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			((Damageable) target).setHealth(event.getPlayer().getHealth()+10);		
		}
		catch(IllegalArgumentException e)
		{		
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			((Player) target).playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			((Damageable) target).setHealth(event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
		}
		return true;
	}

}
