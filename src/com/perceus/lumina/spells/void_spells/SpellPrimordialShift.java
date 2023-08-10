package com.perceus.lumina.spells.void_spells;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellPrimordialShift extends Spell
{

	public SpellPrimordialShift()
	{
		super("PrimordialShift", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fPrimordial Shift&r&7&ko&r",
				"&r&fElement: &r&3&lVOID&r&f.",
				"&r&fSpell Type: &6&lSignature &r&bUtility&f.",
				"&r&fShift the world's time by 10 minutes.",
				"&r&fMana cost: 500 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 500, 200, spelltype.VOID);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		long time = Bukkit.getWorlds().get(0).getTime();
		
		if(time >= 0 && time <= 12000)
		{
			player.playSound(player.getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, SoundCategory.MASTER, 1, 1);
			Bukkit.getWorlds().get(0).setTime(12000);
			//Sets the time to Sunset.
			return true;
		}
		if(time >=12005 && time <= 24000)
		{
			player.playSound(player.getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, SoundCategory.MASTER, 1, 1);
			Bukkit.getWorlds().get(0).setTime(0);
			//Sets the time to Sunrise.
			return true;
		}
		return false;
	}

}
