package com.perceus.lumina.spells.water;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellFrost extends Spell
{

	public SpellFrost()
	{
		super("Frost", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fFrost&r&7&ko&r",
				"&r&fElement: &r&9Water&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fExpell a blast of ice.",
				"&r&fMana cost: 5 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 5, 20, spelltype.WATER);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		player.playSound(player.getLocation(), Sound.ENTITY_SNOWBALL_THROW, SoundCategory.MASTER, 1, 1);
		Snowball snowball = player.launchProjectile(Snowball.class);
		snowball.setGravity(false);
		snowball.setFreezeTicks(200);
		Bukkit.getScheduler().runTaskLater(Lumina.instance, ()-> snowball.remove(), 20);
		return true;
	}

}
