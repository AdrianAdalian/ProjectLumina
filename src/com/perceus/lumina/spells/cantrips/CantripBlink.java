package com.perceus.lumina.spells.cantrips;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.utils.SpellParticle;

public class CantripBlink extends Spell
{

	public CantripBlink()
	{
		super("Blink", new String[] 
		{
				"&r&e&ko&r&7&lCantrip: &r&fBlink&r&e&ko&r",
				"&r&fElement: &r&3&lVOID&r&f.",
				"&r&fSpell Type: &bUtility &eCantrip.",
				"&r&fTeleport a short distance away.",
				"&r&fRange: 7 meters.",
				"&r&fMana cost: 0 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 0, 100, spelltype.VOID);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		int TARGETRANGE = 7 ;
		
		float YAW = player.getLocation().getYaw() ;
		float PITCH = player.getLocation().getPitch() ; //float is a variable that is a decimal, we can use this to get a rotated object/pitch/yaw.
		
		Block target = player.getTargetBlock(null, TARGETRANGE) ;
		
		while (target.getType().equals(Material.AIR)) 
		{
			
			player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, SoundCategory.MASTER, 1, 1);
			target = player.getWorld().getBlockAt(target.getLocation().subtract(new Location(player.getWorld(), 0.5, 1, 0.5))) ;
		
		}
		
		Location newlocation = target.getLocation().add(new Location(player.getWorld(), 0.5, 1, 0.5)) ;
		newlocation.setYaw(YAW);
		newlocation.setPitch(PITCH);
		
		//Location newlocation is a defined variable that we are using to store a player float (yaw/pitch), and then plugging this information into the teleport.
		SpellParticle.drawLine(player.getLocation(), newlocation, 1, Particle.PORTAL, null);
		SpellParticle.drawCircle(player.getLocation(), 2, 180, Particle.PORTAL, null);
		SpellParticle.drawCircle(newlocation, 2, 180, Particle.PORTAL, null);
		player.teleport(newlocation);
		return true;
	}
}
