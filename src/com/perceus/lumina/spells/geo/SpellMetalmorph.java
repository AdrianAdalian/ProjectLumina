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

public class SpellMetalmorph extends Spell
{

	public SpellMetalmorph()
	{
		super("Metalmorph", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fMetalmorph&r&7&ko&r",
				"&r&fElement: &r&6Geo&r&f.",
				"&r&fSpell Type: &6Buff&f.",
				"&r&fGrants 40% damage reduction.",
				"&r&fDecreases caster movement speed.",
				"&r&fDuration: 30 seconds.",
				"&r&fMana cost: 10 &r&9mana&r&f.",
				"&r&fCooldown: 3 seconds."
		}, 10, 60, spelltype.GEO);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{

		player.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_GENERIC, SoundCategory.MASTER, 1, 1);
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 600, 1));
		player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 600, 1));
		Bukkit.getScheduler().runTaskLater(Lumina.instance, () -> player.playSound(player.getLocation(), Sound.BLOCK_CHAIN_BREAK, SoundCategory.MASTER, 1, 1), 605);
		return true;
	}

}
