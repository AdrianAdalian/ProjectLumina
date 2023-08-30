package com.perceus.lumina.spells.almighty;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.utils.GetNearestEntity;
import com.perceus.lumina.utils.SpellParticle;

public class SpellCondemn extends Spell
{

	public SpellCondemn()
	{
		super("Condemn", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fCondemn&r&7&ko&r",
				"&r&fElement: &r&f&lΔlmιghτγ&r&f.",
				"&r&fSpell Type: &cOffensive&6&l Signature&r&f.",
				"&r&fDestroy target Boss Mob.",
				"&r&fRange: 10 meters.",
				"&r&fMana cost: 1000 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 1000, 200, spelltype.ALMIGHTY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 10);
		
		if (target == null) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		List<EntityType> entity = List.of(EntityType.ENDER_DRAGON,
				EntityType.WITHER,
				EntityType.WARDEN,
				EntityType.ELDER_GUARDIAN);
		
		if(!entity.contains(target.getType())) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		((LivingEntity) target).damage(500);
		SpellParticle.drawLine(player.getLocation(), target.getLocation(), 1, Particle.WHITE_ASH, null);
		player.playSound(player.getLocation(), Sound.BLOCK_BELL_USE, SoundCategory.MASTER, 1, 1);
		target.getWorld().spawnParticle(Particle.SMOKE_LARGE, target.getLocation().add(new Location(target.getWorld(), 0,1,0)), 5);
		target.getWorld().spawnParticle(Particle.ASH, target.getLocation().add(new Location(target.getWorld(), 0,1,0)), 5);
		target.getWorld().spawnParticle(Particle.PORTAL, target.getLocation().add(new Location(target.getWorld(), 0,1,0)), 5);
		return true;
	}

}
