package com.perceus.lumina.spells.geo;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellMinersLuck extends Spell
{

	public SpellMinersLuck()
	{
		super("MinersLuck", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fMiner's Luck&r&7&ko&r",
				"&r&fElement: &r&6Geo&r&f.",
				"&r&fSpell Type: &6Buff&f.",
				"&r&fGrants Luck III to caster.",
				"&r&fDuration: 1 minute.",
				"&r&fMana cost: 75 &r&9mana&r&f.",
				"&r&fCooldown: 3 seconds."
		}, 75, 60, spelltype.GEO);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		player.playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
		player.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 1200, 2));
		return true;
	}

}
