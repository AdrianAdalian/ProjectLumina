package com.perceus.lumina.spells.unholy;

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

public class SpellAntiMagicMissile extends Spell
{

	public SpellAntiMagicMissile()
	{
		super("AntiMagicMissile", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fAnti-Magic Missile&r&7&ko&r",
				"&r&fElement: &r&4&o&lUnholy&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fCasts a small concentration of anti-light particles",
				"&r&fdealing no &cdamage&f, but inflicts &4&lDOOM&r&f.",
				"&r&fMana cost: 50 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 50, 200, spelltype.UNHOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ARROW_SHOOT, SoundCategory.MASTER, 1, 1);
		
		Arrow arrow = player.launchProjectile(Arrow.class);
		arrow.addCustomEffect(new PotionEffect(PotionEffectType.DARKNESS, 605, 0), true);
		arrow.addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, 605, 0), true);
		arrow.addCustomEffect(new PotionEffect(PotionEffectType.BAD_OMEN, 605, 0), true);
		arrow.setDamage(0);
		arrow.setGravity(false);
		arrow.setGlowing(true);
		arrow.setColor(Color.BLACK);
		arrow.setCritical(false);
		arrow.setPickupStatus(PickupStatus.DISALLOWED);
		arrow.setKnockbackStrength(0);
		Bukkit.getScheduler().runTaskLater(Lumina.instance, () -> arrow.remove(), 20);
		return true;
	}

}
