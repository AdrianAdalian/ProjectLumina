package com.perceus.lumina.spells.unholy;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellLightShift extends Spell
{

	public SpellLightShift()
	{
		super("LightShift", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fLight Shift&r&7&ko&r",
				"&r&fElement: &r&4&o&lUnholy&r&f.",
				"&r&fSpell Type: &6Buff&f.",
				"&r&fCloaks the caster, becoming invisible.",
				"&r&fDuration: 30 seconds.",
				"&r&fMana cost: 25 &r&9mana&r&f."
		}, 25, 20, spelltype.UNHOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		player.playSound(player.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
		
		player.getWorld().spawnParticle(Particle.SMOKE_LARGE, player.getLocation(), 5);
		
		player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 600, 0));
		return true;
	}

}
