package com.perceus.lumina.spells.unholy;

import java.util.List;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.GetNearestEntity;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellBuffBreak extends Spell
{

	public SpellBuffBreak()
	{
		super("BuffBreak", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fAmeliorate&r&7&ko&r",
				"&r&fElement: &r&4&o&lUnholy&r&f.",
				"&r&fSpell Type: &7&lCurse&r&f.",
				"&r&fRoutes all &6Buffs&f from target player.",
				"&r&fRange: 30 meters.",
				"&r&fMana cost: 50 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 50, 200, spelltype.UNHOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 30);
		
		if (!(target instanceof Player)) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		List<PotionEffectType> negEffects = List.of(PotionEffectType.ABSORPTION,
				PotionEffectType.CONDUIT_POWER,
				PotionEffectType.DAMAGE_RESISTANCE,
				PotionEffectType.DOLPHINS_GRACE,
				PotionEffectType.FAST_DIGGING,
				PotionEffectType.FIRE_RESISTANCE,
				PotionEffectType.GLOWING,
				PotionEffectType.HEALTH_BOOST,
				PotionEffectType.HERO_OF_THE_VILLAGE,
				PotionEffectType.INCREASE_DAMAGE,
				PotionEffectType.INVISIBILITY,
				PotionEffectType.JUMP,
				PotionEffectType.LEVITATION,
				PotionEffectType.LUCK,
				PotionEffectType.NIGHT_VISION,
				PotionEffectType.REGENERATION,
				PotionEffectType.SATURATION,
				PotionEffectType.SLOW_FALLING,
				PotionEffectType.SPEED,
				PotionEffectType.WATER_BREATHING);
		
		player.playSound(player.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
		
		for(PotionEffectType pet : negEffects)
		{
			if(!((Player) target).hasPotionEffect(pet)) 
			{
				continue;
			}
			((Player) target).removePotionEffect(pet);
		}
		
		return true;
	}

}
