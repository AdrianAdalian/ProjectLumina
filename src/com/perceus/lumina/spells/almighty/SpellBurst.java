package com.perceus.lumina.spells.almighty;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.AbstractArrow.PickupStatus;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellBurst extends Spell
{

	public SpellBurst()
	{
		super("Burst", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fBurst&r&7&ko&r",
				"&r&fElement: &r&f&lΔlmιghτγ&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fCreate a short ranged burst of pure energy,",
				"&r&fdealing 5 hearts of &cdamage&f.",
				"&r&fMana cost: 150 &r&9mana&r&f.",
				"&r&fCooldown: 3 seconds."
		}, 150, 60, spelltype.ALMIGHTY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SHOOT, SoundCategory.MASTER, 1, 1);
		
		Arrow arrow = player.launchProjectile(Arrow.class);
		arrow.setDamage(10d);
		arrow.setGravity(false);
		arrow.setGlowing(true);
		arrow.setCritical(false);
		arrow.setPickupStatus(PickupStatus.DISALLOWED);
		arrow.setKnockbackStrength(1);
		Bukkit.getScheduler().runTaskLater(Lumina.instance, () -> arrow.remove(), 10);
		return true;
	}

}
