package com.perceus.lumina.spells.tox;

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

public class SpellPoisonDart extends Spell
{

	public SpellPoisonDart()
	{
		super("PoisonDart", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fPoison Dart&r&7&ko&r",
				"&r&fElement: &r&a&lTØX&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fShoot a dart that deals 4 hearts of",
				"&r&a&lPoison &cDamage&f over 10 seconds.",
				"&r&fMana cost: 15 &r&9mana&r&f.",
				"&r&fCooldown: 3 seconds."
		}, 15, 60, spelltype.TOX);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ARROW_SHOOT, SoundCategory.MASTER, 1, 1);
		
		Arrow arrow = player.launchProjectile(Arrow.class);
		arrow.setGravity(false);
		arrow.setColor(Color.GREEN);
		arrow.setCritical(false);
		arrow.addCustomEffect(new PotionEffect(PotionEffectType.POISON, 200, 0), true);
		arrow.setPickupStatus(PickupStatus.DISALLOWED);
		arrow.setKnockbackStrength(0);
		Bukkit.getScheduler().runTaskLater(Lumina.instance, () -> arrow.remove(), 20);
		return true;
	}

}
