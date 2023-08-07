package com.perceus.lumina.spells.holy;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellRegenerate extends Spell
{

	public SpellRegenerate()
	{
		super("Regenerate", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fRegenerate&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &aSupport&f &dAOE&f.",
				"&r&fRestore &aLife&f overtime to self.",
				"&r&fDuration: 30 seconds.",
				"&r&fMana cost: 50 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 50, 100, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		player.playSound(player.getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, SoundCategory.MASTER, 1, 1);
		player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 600, 0));
		return true;
	}

}
