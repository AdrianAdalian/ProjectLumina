package com.perceus.lumina.spells.lunar;

import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.utils.GetNearestEntity;
import com.perceus.lumina.utils.SpellParticle;

public class SpellLunarBolt extends Spell
{

	public SpellLunarBolt()
	{
		super("LunarBolt", new String[] {
				"&r&fElement: &r&f&o&l&bL&3u&bn&3α&br&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fCan only be cast during &r&7Nightfall&r&f:",
				"&r&fCast out a concentrated bolt of &r&f&o&l&bL&3u&bn&3a&br&r&f energy.",
				"&r&fDeals 2 hearts of &r&cdamage&r&f.",
				"&r&fInflict &r&f&o&l&bL&3u&bn&3a&br&r&f Sickness.",
				"&r&fRange: 15 meters.",
				"&r&fMana cost: 25 &r&9mana&r&f."
		}, 25, 20, spelltype.LUNAR);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		long time = Bukkit.getWorlds().get(0).getTime();

		if(!(time >=12005 && time <= 24000)) //while time is night
		{
			player.sendMessage("Fizzle!");
			return false;
		}
		
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 15);
		
		if (target == null) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		SpellParticle.drawLine(player.getLocation(), target.getLocation(), 2, Particle.GLOW_SQUID_INK, null);
		
		((Damageable) target).damage(4);
		((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 1));
		((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 200, 1));
		
		return true;
	}

}
