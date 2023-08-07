package com.perceus.lumina.spells.storm;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellSurge extends Spell
{

	public SpellSurge()
	{
		super("Surge", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fSurge&r&7&ko&r",
				"&r&fElement: &r&dStorm&r&f.",
				"&r&fSpell Type: &cOffensive &6&lSignature&r&d AOE&f.",
				"&r&fSummon small bolts of lightning at targets nearby.",
				"&r&fRange: 30 meters.",
				"&r&fMana cost: 400 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 400, 200, spelltype.STORM);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		boolean weather = Bukkit.getWorlds().get(0).isClearWeather();
		
		if (weather == true) 
		{
			player.sendMessage("It's not currently storming.");
			return false;
		}
		
		if (player.getNearbyEntities(30, 30, 30).size() == 0) 
		{
			player.sendMessage("No Targets Found");
			return false;
		}
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
		for (Entity target : player.getNearbyEntities(30, 30, 30)) 
		{
			player.getWorld().strikeLightning(target.getLocation());
		}
		return true;
	}

}
