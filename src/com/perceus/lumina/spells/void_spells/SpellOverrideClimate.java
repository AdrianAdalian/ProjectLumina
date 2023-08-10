package com.perceus.lumina.spells.void_spells;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellOverrideClimate extends Spell
{

	public SpellOverrideClimate()
	{
		super("OverrideClimate", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fOverride Climate&r&7&ko&r",
				"&r&fElement: &r&3&lVOID&r&f.",
				"&r&fSpell Type: &6&lSignature &r&bUtility&f.",
				"&r&fFlip weather conditions local to caster.",
				"&r&fMana cost: 500 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 500, 200, spelltype.VOID);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		boolean weather = Bukkit.getWorlds().get(0).isClearWeather();
		
		if(weather) 
		{
			player.playSound(player.getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, SoundCategory.MASTER, 1, 1);
			Bukkit.getWorlds().get(0).setStorm(true);
			Bukkit.getWorlds().get(0).setWeatherDuration(6000);
			return true;
		} 
			player.playSound(player.getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, SoundCategory.MASTER, 1, 1);
			Bukkit.getWorlds().get(0).setStorm(false);
			Bukkit.getWorlds().get(0).setThundering(false);
			Bukkit.getWorlds().get(0).setClearWeatherDuration(12000);
			return true;
	}

}
