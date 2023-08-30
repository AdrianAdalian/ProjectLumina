package com.perceus.lumina.spells.holy;

import java.util.List;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.utils.GetNearestEntity;

public class SpellAccolades extends Spell
{

	public SpellAccolades()
	{
		super("Accolades", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fAccolades&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &aSupport&f &6Buff&f.",
				"&r&fGrants target player Accolades.",
				"&r&fDuration: 1 minute.",
				"&r&fRange: 30 meters.",
				"&r&fMana cost: 350 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
				
		}, 350, 200, spelltype.HOLY);
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
			player.playSound(player.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
			((Player) target).playSound(player.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
			
			List<PotionEffectType> effects = List.of(
					PotionEffectType.FAST_DIGGING,
					PotionEffectType.SPEED,
					PotionEffectType.SATURATION,
					PotionEffectType.INCREASE_DAMAGE,
					PotionEffectType.DAMAGE_RESISTANCE,
					PotionEffectType.NIGHT_VISION,
					PotionEffectType.FIRE_RESISTANCE);
			
			((Player) target).addPotionEffect(new PotionEffect((PotionEffectType) effects, 1200, 0));
			return true;
	}

}
