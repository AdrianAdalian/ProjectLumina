package com.perceus.lumina.spells.almighty;

import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellDivineFlame extends Spell
{

	public SpellDivineFlame()
	{
		super("DivineFlame", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fBurst&r&7&ko&r",
				"&r&fElement: &r&f&lΔlmιghτγ&r&f.",
				"&r&fSpell Type: &cOffensive&6&l Signature&r&f.",
				"&r&fCreate a small ball of pure &r&cFire&r&f energy,",
				"&r&fcausing a colossal explosion on impact.",
				"&r&fMana cost: 500 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 500, 200, spelltype.ALMIGHTY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{

		Fireball sf = (Fireball) player.launchProjectile(Fireball.class);
		sf.setYield(15);
		sf.setIsIncendiary(true);
		sf.setGravity(true);
		sf.setFireTicks(200);
		return true;
	}

}
