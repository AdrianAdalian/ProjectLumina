package com.perceus.lumina.spells.storm;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellRainDance extends Spell
{

	public SpellRainDance()
	{
		super("RainDance", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fSmite&r&7&ko&r",
				"&r&fElement: &r&dStorm&r&f.",
				"&r&fSpell Type: &6&lSignature &r&bUtility&f.",
				"&r&fSummons a thunderstorm.",
				"&r&fMana cost: 500 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 500, 200, spelltype.STORM);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		if (player.getWorld().isClearWeather()) 
		{	
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, SoundCategory.MASTER, 1, 1);
			Bukkit.getWorlds().get(0).setStorm(true);
			Bukkit.getWorlds().get(0).setWeatherDuration(6000);
			return true;
		}
		
		player.sendMessage("It's already storming.");
		return false;
	}

}
