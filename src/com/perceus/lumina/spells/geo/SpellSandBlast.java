package com.perceus.lumina.spells.geo;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.GetNearestEntity;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellSandBlast extends Spell
{

	public SpellSandBlast()
	{
		super("SandBlast", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fSand Blast&r&7&ko&r",
				"&r&fElement: &r&6Geo&r&f.",
				"&r&fSpell Type: &7&lCurse&r&f.",
				"&r&fExpell a blast of sand at a target,",
				"&r&fbriefly blinding and slowing them.",
				"&r&fDuration: 10 seconds.",
				"&r&fRange: 10 meters.",
				"&r&fMana cost: 10 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 10, 100, spelltype.GEO);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 10);
		if (target == null) 
		{
			player.sendMessage("Invalid t");
		}
		
		if (target instanceof LivingEntity)
		{
			((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 0, true));
			((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0, true));
			return true;
		}
		return false;
	}

}
