package com.perceus.lumina.spells.storm;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellBoost extends Spell
{

	public SpellBoost()
	{
		super("Boost", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fBoost&r&7&ko&r",
				"&r&fElement: &r&dStorm&r&f.",
				"&r&fSpell Type: &6Buff&f.",
				"&r&fGrants caster 20% movement speed increase.",
				"&r&fDuration: 30 seconds.",
				"&r&fMana cost: 25 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 25, 20, spelltype.STORM);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		player.playSound(player.getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, SoundCategory.MASTER, 1, 1);
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, 0));
		
		return true;
	}

}
