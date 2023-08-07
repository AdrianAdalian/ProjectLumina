package com.perceus.lumina.spells.holy;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.AbstractArrow.PickupStatus;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellMagicMissile extends Spell
{

	public SpellMagicMissile()
	{
		super("MagicMissile", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fMagic Missile&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fCasts a small concentration of photon",
				"&r&fparticles dealing 1 heart of &cdamage&f.",
				"&r&fMana cost: 5 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 5, 20, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ARROW_SHOOT, SoundCategory.MASTER, 1, 1);
		
		Arrow arrow = player.launchProjectile(Arrow.class);
		arrow.setDamage(2);
		arrow.setGravity(false);
		arrow.setGlowing(true);
		arrow.setColor(Color.WHITE);
		arrow.setCritical(false);
		arrow.setPickupStatus(PickupStatus.DISALLOWED);
		arrow.setKnockbackStrength(0);
		Bukkit.getScheduler().runTaskLater(Lumina.instance, () -> arrow.remove(), 20);
		return true;
	}

}
