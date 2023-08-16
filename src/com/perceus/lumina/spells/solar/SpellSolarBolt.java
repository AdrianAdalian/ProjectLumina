package com.perceus.lumina.spells.solar;

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

public class SpellSolarBolt extends Spell
{

	public SpellSolarBolt()
	{
		super("SolarBolt", new String[] {
				"&r&7&ko&r&7&lSpell: &r&c&l☀ &r&fSolar Bolt &r&c&l☀&r&7&ko&r",
				"&r&fElement: &r&6S&eo&6l&eα&6r&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fCan only be cast during the &r&6Day&r&f.",
				"&r&fLaunches a concentration of &r&6S&eo&6l&eα&6r&r&f energy.",
				"&r&fInflicts &r&6S&eo&6l&eα&6r&r&f sickness.",
				"&r&fMana cost: 100 &r&9mana&r&f.",
		}, 100, 0, spelltype.SOLAR);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		long time = Bukkit.getWorlds().get(0).getTime();

		if(!(time >= 0 && time <= 12000)) //while time is day
		{
			player.sendMessage("Fizzle!");
			return false;
		}
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ARROW_SHOOT, SoundCategory.MASTER, 1, 1);
		
		Arrow arrow = player.launchProjectile(Arrow.class);
		arrow.addCustomEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 200, 1), true);
		arrow.addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 1), true);
		arrow.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 200, 1), true);
		arrow.setCritical(false);
		arrow.setKnockbackStrength(0);
		arrow.setGlowing(true);
		arrow.setColor(Color.RED);
		arrow.setFireTicks(500);
		arrow.setDamage(10);
		arrow.setGravity(false);
		arrow.setPickupStatus(PickupStatus.DISALLOWED);
		Bukkit.getScheduler().runTaskLater(Lumina.instance, ()->arrow.remove(), 20);
		return true;
	}

}
