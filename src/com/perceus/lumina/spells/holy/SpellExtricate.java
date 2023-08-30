package com.perceus.lumina.spells.holy;

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

public class SpellExtricate extends Spell
{

	public SpellExtricate()
	{
		super("Extricate", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fExtricate&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &aSupport&f and &6Buff&f.",
				"&r&fAdd a second Health Bar for 1 minute.",
				"&r&fRange: 25 meters.",
				"&r&fMana cost: 100 &r&9mana&r&f."
		}, 100, 200, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 25);
		
		if (target == null) 
		{
			player.playSound(player.getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, SoundCategory.MASTER, 1, 1);
			player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 100, 0));
			player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1200, 4));
			return true;
		}
		
		if (target instanceof Player) 
		{
			player.playSound(player.getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, SoundCategory.MASTER, 1, 1);
			((Player) target).addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 100, 0));
			((Player) target).addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1200, 4));
			return true;
		}
		player.sendMessage("Invalid Target");
		return false;
	}

}
