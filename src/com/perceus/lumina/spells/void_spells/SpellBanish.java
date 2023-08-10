package com.perceus.lumina.spells.void_spells;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.GetNearestEntity;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellBanish extends Spell
{

	public SpellBanish()
	{
		super("Banish", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fAnti Gravity&r&7&ko&r",
				"&r&fElement: &r&3&lVOID&r&f.",
				"&r&fSpell Type: &cOffensive &6&lSignature&r&f.",
				"&r&fBanish any target into the &r&3&lVOID&r&f.",
				"&r&fBoss monsters are immune.",
				"&r&fRange: 20 meters.",
				"&r&fMana cost: 200 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 200, 100, spelltype.VOID);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 20);
		
		if (target == null) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		List<EntityType> entity = List.of(EntityType.ENDER_DRAGON,
				EntityType.WITHER,
				EntityType.WARDEN,
				EntityType.ELDER_GUARDIAN);
		
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
		player.playSound(player.getLocation(), Sound.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.MASTER, 1, 1);
		target.getWorld().spawnParticle(Particle.SMOKE_LARGE, target.getLocation().add(new Location(target.getWorld(), 0,1,0)), 5);
		target.getWorld().spawnParticle(Particle.ASH, target.getLocation().add(new Location(target.getWorld(), 0,1,0)), 5);
		target.getWorld().spawnParticle(Particle.PORTAL, target.getLocation().add(new Location(target.getWorld(), 0,1,0)), 5);
		target.remove();
		return true;
	}

}
