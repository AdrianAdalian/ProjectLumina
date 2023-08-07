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

public class SpellDracomorph extends Spell
{

	public SpellDracomorph()
	{
		super("Dracomorph", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fDracomorph&r&7&ko&r",
				"&r&fElement: &r&6Geo&r&f.",
				"&r&fSpell Type: &6&lSignature &r&6Buff&f.",
				"&r&fGrants 60% damage reduction and fire immunity.",
				"&r&fGreatly impairs movement.",
				"&r&fDuration: 1 minute.",
				"&r&fMana cost: 100 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 100, 200, spelltype.GEO);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		player.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_GENERIC, SoundCategory.MASTER, 1, 1);
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200, 2));
		player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1200, 2));
		player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200, 0));
		Bukkit.getScheduler().runTaskLater(Lumina.instance, () -> player.playSound(player.getLocation(), Sound.BLOCK_CHAIN_BREAK, SoundCategory.MASTER, 1, 1), 1205);
		return true;
	}

}
