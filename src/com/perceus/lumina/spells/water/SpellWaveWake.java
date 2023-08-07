package com.perceus.lumina.spells.water;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellWaveWake extends Spell
{

	public SpellWaveWake()
	{
		super("WaveWake", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fWave Wake&r&7&ko&r",
				"&r&fElement: &r&9Water&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fGreatly boosts the caster through water.",
				"&r&fMana cost: 10 &r&9mana&r&f.",
				"&r&fCooldown: 2 seconds."
		}, 15, 40, spelltype.WATER);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		if (player.isSwimming() == false) 
		{
			player.sendMessage("You are not actively swimming.");
			return false;
		}
		
		if (player.isSwimming() == true) 
		{
			player.setVelocity(player.getLocation().getDirection().multiply(4.5));
			Bukkit.getScheduler().runTaskLater(Lumina.instance, () -> player.playSound(player.getLocation(), Sound.ITEM_TRIDENT_RIPTIDE_3, SoundCategory.MASTER, 1, 1), 10);
		}
		return true;
	}

}
