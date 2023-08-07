package com.perceus.lumina.spells.storm;

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

public class SpellGalvanicNeedle extends Spell
{

	public SpellGalvanicNeedle()
	{
		super("GalvanicNeedle", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fGalvanic Needle&r&7&ko&r",
				"&r&fElement: &r&dStorm&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fCasts a small needle of charged electricity that",
				"&r&fdeals 2 hearts of &cdamage&f and",
				"&r&fattracts lightning after 2 seconds.",
				"&r&fMana cost: 30 &r&9mana&r&f.",
				"&r&fCooldown: 3 seconds."
		}, 30, 60, spelltype.STORM);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ARROW_SHOOT, SoundCategory.MASTER, 1, 1);
		
		Arrow arrow = player.launchProjectile(Arrow.class);
		arrow.setDamage(2);
		arrow.setGlowing(true);
		arrow.setColor(Color.PURPLE);
		arrow.setCritical(false);
		arrow.setPickupStatus(PickupStatus.DISALLOWED);
		arrow.setKnockbackStrength(0);
		Bukkit.getScheduler().runTaskLater(Lumina.instance, () -> {
			arrow.getLocation().getWorld().strikeLightning(arrow.getLocation());
			arrow.remove();}, 40);
		return true;
	}

}
