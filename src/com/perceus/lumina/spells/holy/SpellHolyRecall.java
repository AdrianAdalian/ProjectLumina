package com.perceus.lumina.spells.holy;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellHolyRecall extends Spell
{

	public SpellHolyRecall()
	{
		super("HolyRecall", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fHoly Recall&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fRecall caster to their spawn location.",
				"&r&fMana cost: 100 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 100, 20, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		if (player.getBedSpawnLocation() == null) 
		{
			Bukkit.getScheduler().runTaskLater(Lumina.instance, ()->
				player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, SoundCategory.MASTER, 1, 1), 5);
			Location worldspawn = player.getWorld().getSpawnLocation();
			player.teleport(worldspawn);
			return true;
		}
		Bukkit.getScheduler().runTaskLater(Lumina.instance, ()->
			player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, SoundCategory.MASTER, 1, 1), 5);
		Location spawnpoint = player.getBedSpawnLocation();
		player.teleport(spawnpoint);
		return true;
	}

}
