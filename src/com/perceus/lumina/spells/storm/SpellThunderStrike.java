package com.perceus.lumina.spells.storm;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.GetNearestEntity;
import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellThunderStrike extends Spell
{

	public SpellThunderStrike()
	{
		super("ThunderStrike", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fSmite&r&7&ko&r",
				"&r&fElement: &r&dStorm&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fSummon two small bolts of lightning on target.",
				"&r&fRange: 30 meters.",
				"&r&fMana cost: 150 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 150, 100, spelltype.STORM);
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
		Bukkit.getScheduler().runTaskLater(Lumina.instance, ()->target.getWorld().strikeLightning(target.getLocation()), 20);
		return true;
	}

}
