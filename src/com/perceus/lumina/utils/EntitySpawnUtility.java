package com.perceus.lumina.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class EntitySpawnUtility extends Spell
{
	private final EntityType etype;
	
	public EntitySpawnUtility(String name, String[] description, int manacost, int cooldown, spelltype type, EntityType etype)
	{
		super(name, description, manacost, cooldown, type);
		this.etype = etype;
	}

	public static boolean SpawnEntity(EntityType type, Player p) 
	{
		Block target = p.getTargetBlock(null, 7);
		if (target == null) 
		{
			p.sendMessage("Invalid Target");
			return false;
		}
		
		if (target.getType().equals(Material.AIR)) 
		{
			p.sendMessage("Invalid Target");
			return false;
		}
		
		Location newloc = target.getLocation().add(0.5, 1, 0.5);
		newloc.getWorld().spawnEntity(newloc, type);
		SpellParticle.drawCylinder(newloc, 1, 50, 3, 1, Particle.ENCHANTMENT_TABLE, null);
		SpellParticle.drawCircle(newloc, 2, 180, Particle.CLOUD, null);
		return true;
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		return SpawnEntity(this.etype, player);
	}
}
