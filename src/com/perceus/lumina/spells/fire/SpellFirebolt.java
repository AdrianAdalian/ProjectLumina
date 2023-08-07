package com.perceus.lumina.spells.fire;

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

public class SpellFirebolt extends Spell
{

	public SpellFirebolt()
	{
		super("Firebolt", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fFirebolt&r&7&ko&r",
				"&r&fElement: &r&cFire&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fCasts a small concentration of fire particles",
				"&r&fdealing &cdamage&f over 10 seconds.",
				"&r&fMana cost: 10 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 10, 20, spelltype.FIRE);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ARROW_SHOOT, SoundCategory.MASTER, 1, 1);
		
		Arrow arrow = player.launchProjectile(Arrow.class);
		arrow.setDamage(0);
		arrow.setFireTicks(200);
		arrow.setGravity(false);
		arrow.setVisualFire(true);
		arrow.setGlowing(true);
		arrow.setColor(Color.RED);
		arrow.setCritical(false);
		arrow.setPickupStatus(PickupStatus.DISALLOWED);
		arrow.setKnockbackStrength(0);
		Bukkit.getScheduler().runTaskLater(Lumina.instance, () -> arrow.remove(), 20);
		return true;
	}

}
