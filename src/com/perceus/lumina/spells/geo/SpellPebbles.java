package com.perceus.lumina.spells.geo;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.AbstractArrow.PickupStatus;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellPebbles extends Spell
{

	public SpellPebbles()
	{
		super("Pebbles", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fPebbles&r&7&ko&r",
				"&r&fElement: &r&6Geo&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fCasts a small concentration of pebbles",
				"&r&fdealing 2 heart(s) of &cdamage&f and", 
				"&r&fcausing acute blindness for 3 seconds.",
				"&r&fMana cost: 15 &r&9mana&r&f.",
				"&r&fCooldown: 2 seconds."
		}, 15, 40, spelltype.GEO);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ARROW_SHOOT, SoundCategory.MASTER, 1, 1);
		
		Arrow arrow = player.launchProjectile(Arrow.class);
		arrow.setDamage(2);
		arrow.addCustomEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 0), true);
		arrow.setColor(Color.ORANGE);
		arrow.setCritical(false);
		arrow.setGravity(false);
		arrow.setPickupStatus(PickupStatus.DISALLOWED);
		arrow.setKnockbackStrength(0);
		Bukkit.getScheduler().runTaskLater(Lumina.instance, () -> arrow.remove(), 20);
		return true;
	}

}
