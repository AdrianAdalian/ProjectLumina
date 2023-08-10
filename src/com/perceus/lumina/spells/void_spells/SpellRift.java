package com.perceus.lumina.spells.void_spells;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.GetNearestEntity;
import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellRift extends Spell
{

	public SpellRift()
	{
		super("Rift", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fTeleport&r&7&ko&r",
				"&r&fElement: &r&3&lVOID&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fSwap teleport between targets.",
				"&r&fRange: 100 meters.",
				"&r&fMana cost: 100 &r&9mana&r&f.",
				"&r&fCooldown: 3 seconds."
		}, 100, 60, spelltype.VOID);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity targetEntity = GetNearestEntity.getNearestEntityInSight(player, 100) ;
		
		if (targetEntity == null) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		float YAW = player.getLocation().getYaw();
		float PITCH = player.getLocation().getPitch();
		
		float entityYAW = targetEntity.getLocation().getYaw();
		float entityPITCH = targetEntity.getLocation().getPitch();
		
		Location playerLocation = player.getLocation();
		Location entityLocation = targetEntity.getLocation();

		entityLocation.setPitch(PITCH);
		entityLocation.setYaw(YAW);
		playerLocation.setPitch(entityPITCH);
		playerLocation.setYaw(entityYAW);
		player.teleport(entityLocation);
		targetEntity.teleport(playerLocation);
		
		Bukkit.getScheduler().runTaskLater(Lumina.instance, ()->
			player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, SoundCategory.MASTER, 1, 1), 10);
	
		return true;
	}

}
