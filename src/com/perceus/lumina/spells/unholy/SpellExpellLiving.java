package com.perceus.lumina.spells.unholy;

import java.util.List;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.utils.GetNearestEntity;

public class SpellExpellLiving extends Spell
{

	public SpellExpellLiving()
	{
		super("ExpellLiving", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fExpell Living&r&7&ko&r",
				"&r&fElement: &r&4&o&lUnholy&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fObliterates non-undead target.",
				"&r&fPlayer targets are immune.",
				"&r&fRange: 15 meters.",
				"&r&fMana cost: 200 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 200, 200, spelltype.UNHOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 15);
		
		if (target == null)
		{
			player.sendMessage("Invalid Target.");
			return false;
		}
		
		List<EntityType> entity = List.of(EntityType.SKELETON,
				EntityType.ZOMBIE,
				EntityType.DROWNED,
				EntityType.STRAY,
				EntityType.HUSK,
				EntityType.ZOMBIE_VILLAGER,
				EntityType.ZOMBIFIED_PIGLIN,
				EntityType.WITHER_SKELETON,
				EntityType.VEX,
				EntityType.ZOMBIE_HORSE,
				EntityType.SKELETON_HORSE,
				EntityType.ZOGLIN,
				EntityType.WITHER,
				EntityType.WARDEN);
		
		if(entity.contains(target.getType())) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		if(target instanceof Player) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		player.playSound(player.getLocation(), Sound.ENTITY_WITHER_AMBIENT, SoundCategory.MASTER, 1, 1);
		((Damageable) target).damage(84);
		
		return true;
	}

}
