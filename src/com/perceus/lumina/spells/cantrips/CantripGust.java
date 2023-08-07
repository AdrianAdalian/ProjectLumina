package com.perceus.lumina.spells.cantrips;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.GetNearestEntity;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class CantripGust extends Spell
{

	public CantripGust()
	{
		super("Gust", new String[]{
				"&r&e&ko&r&7&lCantrip: &r&fGust&r&e&kao&r", 
				"&r&fElement: &r&dStorm&r&f.",
				"&r&fSpell Type: &cOffensive &eCantrip&f.",
				"&r&fCreate a gust of wind that pushes a target back.",
				"&r&fRange: 3 meters.",
				"&r&fMana cost: 0 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		},0, 1, spelltype.STORM);
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
		
		target.setVelocity(target.getLocation().toVector().subtract(event.getPlayer().getLocation().toVector()));
		return true;
	}

}
