package com.perceus.lumina.spells.geo;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellEarthquake extends Spell
{

	public SpellEarthquake()
	{
		super("Earthquake", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fEarthquake&r&7&ko&r",
				"&r&fElement: &r&6Geo&r&f.",
				"&r&fSpell Type: &r&cOffensive &dAOE &6&lSignature&r&f.",
				"&r&fCause an earthquake that deals 5 hearts of &r&cdamage&r&f",
				"&r&fto all affected and stuns for 5 seconds.",
				"&r&fRange: 30 meters.",
				"&r&fMana cost: 300 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 300, 200, spelltype.GEO);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		if (event.getPlayer().getNearbyEntities(30, 30, 30).size() == 0)
		{
			player.sendMessage("Invalid Target.");
			return false;
		}
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_STONE_BREAK, SoundCategory.MASTER, 1, 1);
		for (Entity target : event.getPlayer().getNearbyEntities(30, 30, 30))
		{
			if (!(target instanceof LivingEntity)) 
			{
				continue;
			}
			if (target instanceof LivingEntity)
			{
				((Damageable) target).damage(10);
				((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 99));
			}
		}
		return true; 
	}

}
