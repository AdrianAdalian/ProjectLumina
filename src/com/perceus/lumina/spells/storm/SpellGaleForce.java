package com.perceus.lumina.spells.storm;

import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.utils.GetNearestEntity;

public class SpellGaleForce extends Spell
{

	public SpellGaleForce()
	{
		super("GaleForce", new String[] 
		{
				"&r&7&ko&r&7&lSpell: &r&fGale Force&r&7&ko&r",
				"&r&fElement: &r&dStorm&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fCreate a damaging gust to target.",
				"&r&fRange: 3 meters.",
				"&r&fMana cost: 25 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 25, 20, spelltype.STORM);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 3);
		
		if (target == null) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		if (target instanceof Damageable) 
		{
			((Damageable) target).damage(2);	
		}
		target.setVelocity(target.getLocation().toVector().subtract(event.getPlayer().getLocation().toVector()).multiply(1.25));
		return true;
	}

}
