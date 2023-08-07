package com.perceus.lumina.spells.holy;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellBarrier extends Spell
{

	public SpellBarrier()
	{
		super("Barrier", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fBarrier&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &6Buff&f.",
				"&r&fRaise a magical barrier around the caster.",
				"&r&fDuration: 1 minute.",
				"&r&fMana cost: 25 &r&9mana&r&f.",
				"&r&fCooldown: 3 seconds."
		}, 25, 60, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200, 4));
		return true;
	}

}
