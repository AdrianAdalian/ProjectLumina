package com.perceus.lumina.spells.geo;

import org.bukkit.Bukkit;
import org.bukkit.entity.AbstractArrow.PickupStatus;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellBoulder extends Spell
{

	public SpellBoulder()
	{
		super("Boulder", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fBoulder&r&7&ko&r",
				"&r&fElement: &r&6Geo&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fHurl a large boulder that stuns any target upon impact.",
				"&r&fAlso deals 3 hearts of &cdamage&f.",
				"&r&fStun for 5 seconds.",
				"&r&fMana cost: 100 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 100, 100, spelltype.GEO);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Arrow arrow = event.getPlayer().launchProjectile(Arrow.class);
		arrow.setPickupStatus(PickupStatus.DISALLOWED);
		arrow.setCritical(false);
		arrow.setKnockbackStrength(2);
		arrow.setDamage(3);	
		arrow.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 100, 99), true);
		Bukkit.getScheduler().runTaskLater(Lumina.instance, () -> arrow.remove(), 20);
		return true;
	}

}
