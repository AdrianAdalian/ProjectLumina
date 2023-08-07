package com.perceus.lumina.spells.storm;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellCharge extends Spell
{

	public SpellCharge()
	{
		super("Charge", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fCharge&r&7&ko&r",
				"&r&fElement: &r&dStorm&r&f.",
				"&r&fSpell Type: &6Buff&f.",
				"&r&fIncrease movement and interact speeds by 60%.",
				"&r&fIncrease damage output by 60%.",
				"&r&fDuration: 30 seconds.",
				"&r&fMana cost: 100 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 100, 20, spelltype.STORM);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		player.playSound(player.getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, SoundCategory.MASTER, 1, 1);
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, 2, true));
		player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 600, 2, true));
		player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 600, 2, true));
		return true;
	}

}
