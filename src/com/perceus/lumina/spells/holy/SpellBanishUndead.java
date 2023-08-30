package com.perceus.lumina.spells.holy;

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

public class SpellBanishUndead extends Spell
{

	public SpellBanishUndead()
	{
		super("BanishUndead", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fBanish Undead&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fBanish undead target.",
				"&r&fThe Warden and Wither are immune.",
				"&r&fRange: 30 meters.",
				"&r&fMana cost: 25 &r&9mana&r&f.",
				"&r&fCooldown: 3 seconds."
		}, 100, 60, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 30);
		
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
		if (target == null) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		if(!(entity.contains(target.getType()))) 
		{
			player.sendMessage("Invalid Target.");
			return false;
		}
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BELL_USE, SoundCategory.MASTER, 1, 1);
		((Damageable) target).damage(100);
		
		return true;
	}

}
