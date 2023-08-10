package com.perceus.lumina.spells.water;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.entity.AbstractArrow.PickupStatus;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellFrostSpike extends Spell
{

	public SpellFrostSpike()
	{
		super("FrostSpike", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fFrost Spike&r&7&ko&r",
				"&r&fElement: &r&9Water&r&f.",
				"&r&fSpell Type: &cOffensive&7&l Curse&r&f.",
				"&r&fExpell a spike of ice, chilling those hit.",
				"&r&fDeals 1 heart of &cdamage&f on impact and slows.",
				"&r&fMana cost: 15 &r&9mana&r&f.",
				"&r&fCooldown: 2 seconds."
		}, 15, 40, spelltype.WATER);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Arrow arrow = player.launchProjectile(Arrow.class);
		arrow.setDamage(1);
		arrow.setFreezeTicks(1200);
		arrow.setColor(Color.AQUA);
		arrow.setGravity(false);
		arrow.setCritical(false);
		arrow.setPickupStatus(PickupStatus.DISALLOWED);
		arrow.setKnockbackStrength(0);
		arrow.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 600, 0), true);
		Bukkit.getScheduler().runTaskLater(Lumina.instance, ()->arrow.remove(), 25);
		return true;
	}

}
