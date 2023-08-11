package com.perceus.lumina.spells.water;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellIceAge extends Spell
{

	public SpellIceAge()
	{
		super("IceAge", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fIce Age&r&7&ko&r",
				"&r&fElement: &r&9Water&r&f.",
				"&r&fSpell Type: &6&lSignature &r&bUtility&f.",
				"&r&fAcutely &b&lFreeze&r&f nearby water sources.",
				"&r&fUse like Frost Walker.",
				"&r&fRange: 100 meters.",
				"&r&fMana cost: 500 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 500, 200, spelltype.WATER);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		int radius = 100; 
		int radius2 = 1;
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.AMBIENT_UNDERWATER_EXIT, SoundCategory.MASTER, 1, 1);
		for (int iy = (radius2 * -1); iy < (radius2 * 1); iy++)
		{
			for (int ix = (radius * -1); ix < (radius * 1); ix++)
			{
				for (int iz = (radius * -1); iz < (radius * 1); iz++)
				{
					
					Block target1 = event.getPlayer().getWorld().getBlockAt(event.getPlayer().getLocation().add(new Location(event.getPlayer().getWorld(), ix, iy, iz)));
					
					if (target1.getType().equals(Material.WATER))
					{
						target1.setType(Material.FROSTED_ICE);
					}	
				}
			}
		}
		return true;
	}

}
