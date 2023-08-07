package com.perceus.lumina.spells.holy;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellAngelicFlight extends Spell
{

	public SpellAngelicFlight()
	{
		super("AngelicFlight", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fAngelic Flight&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fGrants the caster temporary ability to fly.",
				"&r&fDuration: 1 minute.",
				"&r&fMana cost: 100 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 100, 200, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{

		player.playSound(player.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
		player.setAllowFlight(true);
		player.setFlying(true);
		
		Bukkit.getScheduler().runTaskLater(Lumina.instance, () -> 
		{player.playSound(player.getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, SoundCategory.MASTER, 1, 1);player.setAllowFlight(false);player.setFlying(false);}, 1205);
		return true;
	}

}
