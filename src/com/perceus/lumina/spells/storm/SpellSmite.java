package com.perceus.lumina.spells.storm;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.GetNearestEntity;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellSmite extends Spell
{

	public SpellSmite()
	{
		super("Smite", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fSmite&r&7&ko&r",
				"&r&fElement: &r&dStorm&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fSummon a small bolt of lightning on target.",
				"&r&fRange: 30 meters.",
				"&r&fMana cost: 50 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
				
		}, 50, 100, spelltype.STORM);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{

		Entity target = GetNearestEntity.getNearestEntityInSight(player, 30);
		
		if (target==null) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		target.getWorld().strikeLightning(target.getLocation());
		return true;
	}
}
