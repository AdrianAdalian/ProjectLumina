package com.perceus.lumina.spells.holy;

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

public class SpellAmeliorate extends Spell
{

	public SpellAmeliorate()
	{
		super("Ameliorate", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fAmeliorate&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &aSupport&f.",
				"&r&fRoutes all &7&lCurses&r&f from target player.",
				"&r&fRange: 30 meters.",
				"&r&fMana cost: 50 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 50, 200, spelltype.HOLY);
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
		
		List<PotionEffectType> negEffects = List.of(PotionEffectType.WEAKNESS,
				PotionEffectType.BAD_OMEN,
				PotionEffectType.CONFUSION,
				PotionEffectType.POISON,
				PotionEffectType.SLOW_DIGGING,
				PotionEffectType.WITHER,
				PotionEffectType.BLINDNESS,
				PotionEffectType.DARKNESS,
				PotionEffectType.HUNGER,
				PotionEffectType.UNLUCK);
		
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
