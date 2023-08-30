package com.perceus.lumina.spells.cantrips;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.utils.SpellParticle;

public class CantripEmbers extends Spell
{

	public CantripEmbers()
	{
		super("Embers", new String[]{"&r&e&ko&r&7&lCantrip: &r&fEmbers&r&e&ko&r", 
				"&r&fElement: &r&cFire&r&f.",
				"&r&fSpell Type: &cOffensive &eCantrip&f.",
				"&r&fCast out tiny embers that sets anything ablaze.",
				"&r&fMana cost: 0 &r&9mana&r&f.",
				"&r&fCooldown: 1 seconds."
				}, 0, 20, spelltype.FIRE);
		
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		SpellParticle.drawCircle(player.getLocation(), 2, 180, Particle.FLAME, null);
		player.playSound(player.getLocation(), Sound.ITEM_FIRECHARGE_USE, SoundCategory.MASTER, 1, 1);
		player.launchProjectile(SmallFireball.class);
		return true;
	}

}
