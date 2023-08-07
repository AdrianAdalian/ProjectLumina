package com.perceus.lumina.spells.unholy;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellEmbraceTheShadows extends Spell
{

	public SpellEmbraceTheShadows()
	{
		super("EmbraceTheShadows", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fEmbrace the Shadows&r&7&ko&r",
				"&r&fElement: &r&4&o&lUnholy&r&f.",
				"&r&fSpell Type: &6Buff&f.",
				"&r&fGrants invisibility for 30 seconds.",
				"&r&fMana cost: 50 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 50, 20, spelltype.UNHOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 600, 0));
		return false;
	}

}
