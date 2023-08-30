package com.perceus.lumina.spells.void_spells;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.utils.GetNearestEntity;

public class SpellAntiGravity extends Spell
{

	public SpellAntiGravity()
	{
		super("AntiGravity", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fAnti Gravity&r&7&ko&r",
				"&r&fElement: &r&3&lVOID&r&f.",
				"&r&fSpell Type: &6Buff&f or &7&lCurse&r&f.",
				"&r&fCause null gravity at target or self.",
				"&r&fRange: 15 meters.",
				"&r&fMana cost: 50 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 50, 20, spelltype.VOID);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 15);
		
		if (target == null) 
		{
			player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 60, 4));
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
			Bukkit.getScheduler().runTaskLater(Lumina.instance, ()-> 
			{
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 60, 4));
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, SoundCategory.MASTER, 1, 1);
			}, 65);
			return true;
		}
		
		((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 60, 4));
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
		return true;
	}

}
