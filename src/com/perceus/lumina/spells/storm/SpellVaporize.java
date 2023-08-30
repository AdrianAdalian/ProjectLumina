package com.perceus.lumina.spells.storm;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.utils.GetNearestEntity;

public class SpellVaporize extends Spell
{

	public SpellVaporize()
	{
		super("Vaporize", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fVaporize&r&7&ko&r",
				"&r&fElement: &r&dStorm&r&f.",
				"&r&fSpell Type: &cOffensive &6&lSignature&r&f.",
				"&r&fSummon three small bolts of lightning on target.",
				"&r&fRange: 30 meters.",
				"&r&fMana cost: 300 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 300, 200, spelltype.STORM);
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
		Bukkit.getScheduler().runTaskLater(Lumina.instance, ()-> target.getWorld().strikeLightning(target.getLocation()), 40);
		Bukkit.getScheduler().runTaskLater(Lumina.instance, ()-> target.getWorld().strikeLightning(target.getLocation()), 80);
		return true;
	}

}
