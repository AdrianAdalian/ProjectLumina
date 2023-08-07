package com.perceus.lumina.spells.geo;

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

public class SpellMagemorph extends Spell
{

	public SpellMagemorph()
	{
		super("Magemorph", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fMagemorph&r&7&ko&r",
				"&r&fElement: &r&6Geo&r&f.",
				"&r&fSpell Type: &6Buff&f.",
				"&r&fGrants 4 hearts absorption and 20% damage reduction.",
				"&r&fAlso grants fire immunity.",
				"&r&fDuration: 45 seconds.",
				"&r&fMana cost: 10 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 30, 100, spelltype.GEO);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		player.playSound(player.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 900, 0));
		player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 900, 1));
		player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 900, 0));
		Bukkit.getScheduler().runTaskLater(Lumina.instance, () -> player.playSound(player.getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, SoundCategory.MASTER, 1, 1), 1205);
		return true;
	}

}
