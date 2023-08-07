package com.perceus.lumina.spells.water;

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

public class SpellScales extends Spell
{

	public SpellScales()
	{
		super("Scales", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fScales&r&7&ko&r",
				"&r&fElement: &r&9Water&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fExpells a set of fish scales outwards inflicting", 
				"&r&freduced movement speed for 10 seconds.",
				"&r&fMana cost: 5 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 5, 20, spelltype.WATER);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ARROW_SHOOT, SoundCategory.MASTER, 1, 1);
		
		Arrow arrow = player.launchProjectile(Arrow.class);
		arrow.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 200, 1), true);
		arrow.setDamage(0);
		arrow.setGlowing(true);
		arrow.setColor(Color.BLUE);
		arrow.setCritical(false);
		arrow.setPickupStatus(PickupStatus.DISALLOWED);
		arrow.setKnockbackStrength(0);
		Bukkit.getScheduler().runTaskLater(Lumina.instance, () -> arrow.remove(), 20);
		return true;
	}

}
