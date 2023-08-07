package com.perceus.lumina.spells.unholy;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellUnholyRecall extends Spell
{

	public SpellUnholyRecall()
	{
		super("UnholyRecall", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fHoly Recall&r&7&ko&r",
				"&r&fElement: &r&4&o&lUnholy&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fRecall caster to their death location.",
				"&r&fMana cost: 100 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 100, 20, spelltype.UNHOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		if (player.getStatistic(Statistic.DEATHS) >= 1) 
		{
			Location lastdeath = player.getLastDeathLocation();
			player.teleport(lastdeath);
			Bukkit.getScheduler().runTaskLater(Lumina.instance, ()->
			player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, SoundCategory.MASTER, 1, 1), 5);
			return true;
		}
		player.sendMessage("You haven't died... yet.");
		return false;
	}

}
