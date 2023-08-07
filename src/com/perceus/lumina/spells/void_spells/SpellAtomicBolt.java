package com.perceus.lumina.spells.void_spells;

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

public class SpellAtomicBolt extends Spell
{

	public SpellAtomicBolt()
	{
		super("AtomicBolt", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fAtomic Bolt&r&7&ko&r",
				"&r&fElement: &r&3&lVOID&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fCasts a small concentration of anti-matter particles",
				"&r&fdealing no &cdamage&f, but inflicts &r&3&lVoided&r&f.",
				"&r&fMana cost: 25 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 25, 100, spelltype.VOID);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ENDER_PEARL_THROW, SoundCategory.MASTER, 1, 1);
		
		Arrow arrow = player.launchProjectile(Arrow.class);
		arrow.addCustomEffect(new PotionEffect(PotionEffectType.LEVITATION, 200, 0), true);
		arrow.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0), true);
		arrow.addCustomEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 0), true);
		arrow.setDamage(0);
		arrow.setGlowing(true);
		arrow.setColor(Color.TEAL);
		arrow.setCritical(false);
		arrow.setPickupStatus(PickupStatus.DISALLOWED);
		arrow.setKnockbackStrength(0);
		Bukkit.getScheduler().runTaskLater(Lumina.instance, () -> {
			arrow.remove();}, 60);
		return true;
	}

}
