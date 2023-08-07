package com.perceus.lumina.spells.fire;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellFlamethrower extends Spell
{

	public SpellFlamethrower()
	{
		super("Flamethrower", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fFireball&r&7&ko&r",
				"&r&fElement: &r&cFire&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fAllows the caster to summon a flurry of tiny embers.",
				"&r&fMana cost: 10 &r&9mana&r&f.",
				"&r&fCooldown: 0 seconds."
		}, 10, 0, spelltype.FIRE);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		player.playSound(player.getLocation(), Sound.ITEM_FIRECHARGE_USE, SoundCategory.MASTER, 1, 1);
		player.launchProjectile(SmallFireball.class);
		return true;
	}

}
