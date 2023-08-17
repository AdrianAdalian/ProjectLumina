package com.perceus.lumina.spells.holy;

import java.util.List;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellProperDeath extends Spell
{

	public SpellProperDeath()
	{
		super("ProperDeath", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fProper Death&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &cOffensive&d AOE&f.",
				"&r&fBanish undead targets nearby.",
				"&r&fThe Warden and Wither are immune.",
				"&r&fRange: 20 meters.",
				"&r&fMana cost: 250 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 250, 100, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		if (player.getNearbyEntities(20,20,20).size() == 0)
		{
			player.sendMessage("Invalid Target");
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
				EntityType.ZOGLIN);
		player.playSound(player.getLocation(), Sound.BLOCK_BELL_USE, SoundCategory.MASTER, 1, 1);
		for (Entity target : player.getNearbyEntities(20,20,20))
		{
			if(!(entity.contains(target.getType()))) 
			{
				continue;
			}
			((LivingEntity) target).damage(100);;
		}
		return true;
	}

}
