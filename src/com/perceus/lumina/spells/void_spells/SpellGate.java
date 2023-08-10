package com.perceus.lumina.spells.void_spells;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellGate extends Spell
{

	public SpellGate()
	{
		super("Gate", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fGate&r&7&ko&r",
				"&r&fElement: &r&3&lVOID&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fTeleport between the Nether and the Overworld.",
				"&r&fMana cost: 500 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 100, 20, spelltype.VOID);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		World nether = Bukkit.getWorld("world_nether");
		
		World overworld = Bukkit.getWorlds().get(0);
		
		int xradius = 75;
		int zradius = 75;

		
		if(player.getWorld().getEnvironment().equals(Environment.NORMAL))
		{
			double baseX = player.getLocation().getX() / 8;
			double baseZ = player.getLocation().getX() / 8;
			for (int ix = xradius * -1; ix < xradius; ix++)
			{
				for (int iz = zradius * -1; iz < zradius; iz++)
				{
					for (int iy = 1; iy < 126; iy++)
					{
						
						Block current = nether.getBlockAt(new Location(nether, baseX + ix, iy, baseZ + iz));
						
						if (current.getType().equals(Material.LAVA) || current.getType().equals(Material.MAGMA_BLOCK) || current.getType().equals(Material.AIR)) 
						{
							continue;
						}
						
						if (current.getRelative(BlockFace.UP).getType().isAir() && current.getRelative(BlockFace.UP).getRelative(BlockFace.UP).getType().isAir()) 
						{
							
							Bukkit.getWorld("world_nether").loadChunk(current.getChunk());
							
							current.setType(Material.NETHERRACK); 
							current.getRelative(BlockFace.UP).setType(Material.AIR);
							current.getRelative(BlockFace.UP).getRelative(BlockFace.UP).setType(Material.AIR);
							
							player.teleport(new Location(nether, current.getLocation().getX(), current.getLocation().getY(), current.getLocation().getZ()).add(0.5, 1, 0.5));
							
							return true;
						  //Teleports the caster from the overworld to the nether.
						}
					}
				}
			}
			player.sendMessage("Unsafe Cast Location Found, Please Try Again");
			return false;
		}
		
		if(player.getWorld().getEnvironment().equals(Environment.NETHER)) 
		{
			Location loc2 = player.getLocation();
			int overworldX = (int) (loc2.getX() * 8);
			int overworldZ = (int) (loc2.getZ() * 8);
			Block target = Bukkit.getWorld("world").getHighestBlockAt(overworldX, overworldZ);
			
			player.teleport(new Location(overworld, overworldX, target.getLocation().getY(), overworldZ).add(0.5, 1, 0.5));
			return true;
				//Teleports the caster from the nether to the overworld.
		}

		return false;
	}

}
