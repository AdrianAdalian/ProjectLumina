package com.perceus.lumina.spells.fire;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellIgnitionDrive extends Spell
{

	public SpellIgnitionDrive()
	{
		super("IgnitionDrive", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fIgnition Drive&r&7&ko&r",
				"&r&fElement: &r&cFire&r&f.",
				"&r&fSpell Type: &6Buff&f.",
				"&r&fIncrease caster interact speed and overall damage by 20%.",
				"&r&fDuration: 30 seconds.",
				"&r&fMana cost: 30 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 30, 100, spelltype.FIRE);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 600, 0));
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 600, 0));
		Bukkit.getScheduler().runTaskLater(Lumina.instance, () -> 
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, SoundCategory.MASTER, 1, 1), 605);
		return true;
	}

}
