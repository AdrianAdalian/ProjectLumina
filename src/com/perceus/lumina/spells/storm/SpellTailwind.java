package com.perceus.lumina.spells.storm;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellTailwind extends Spell
{

	public SpellTailwind()
	{
		super("Tailwind", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fTailwind&r&7&ko&r",
				"&r&fElement: &r&dStorm&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fCreate a gust of wind behind the",
				"&r&fcaster that launches them forward.",
				"&r&fMana cost: 10 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 10, 20, spelltype.STORM);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		player.playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
		player.setVelocity(player.getLocation().getDirection().normalize().multiply(2));
		return true;
	}

}
