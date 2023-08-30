package com.perceus.lumina.spells.unholy;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.ZombieVillager;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.utils.GetNearestEntity;

public class SpellConvertUndead extends Spell
{

	public SpellConvertUndead()
	{
		super("ConvertUndead", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fConvert Undead&r&7&ko&r",
				"&r&fElement: &r&4&o&lUnholy&r&f.",
				"&r&fSpell Type: &6&lSignature&r &bUtility&f.",
				"&r&fCure Zombie Villager targets.",
				"&r&fMana cost: 500 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 500, 200, spelltype.UNHOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 5);
		if(target == null) 
		{
			player.sendMessage("Invalid Target.");
			return false;
		}
		
		if (!(target.getType().equals(EntityType.ZOMBIE_VILLAGER)))
		{
			player.sendMessage("Invalid Target.");
			return false;
		}
		if (player.getHealth() <= 1.0 ) 
		{
			player.sendMessage("Invalid Target.");
			return false;
		}

		player.setHealth(player.getHealth() / 2.0);
		player.playSound(player.getLocation(), Sound.ENTITY_ZOMBIE_VILLAGER_CURE, SoundCategory.MASTER, 1, 1);
		((ZombieVillager) target).setConversionTime(0);
		return true;
	}

}
