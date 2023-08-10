package com.perceus.lumina.spells.void_spells;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellTeleport extends Spell
{

	public SpellTeleport()
	{
		super("Teleport", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fTeleport&r&7&ko&r",
				"&r&fElement: &r&3&lVOID&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fTeleport a fair distance away.",
				"&r&fRange: 25 meters.",
				"&r&fMana cost: 50 &r&9mana&r&f.",
				"&r&fCooldown: 3 seconds."
		}, 50, 60, spelltype.VOID);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		
		float YAW = event.getPlayer().getLocation().getYaw();
		float PITCH = event.getPlayer().getLocation().getPitch();
		
		Block target = event.getPlayer().getTargetBlock(null, 25);
		
		while (target.getType().equals(Material.AIR)) 
		{
			target = event.getPlayer().getWorld().getBlockAt(target.getLocation().subtract(new Location(event.getPlayer().getWorld(), 0.5, 1, 0.5))) ;
		}
		
		Location newlocation = target.getLocation().add(new Location(event.getPlayer().getWorld(), 0.5, 1, 0.5));
		newlocation.setYaw(YAW);
		newlocation.setPitch(PITCH);
		player.teleport(newlocation);
		Bukkit.getScheduler().runTaskLater(Lumina.instance, ()->
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, SoundCategory.MASTER, 1, 1), 10);
		
		return true;
	}

}
