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

public class SpellFrostbite extends Spell
{

	public SpellFrostbite()
	{
		super("Frostbite", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fFrostbite&r&7&ko&r",
				"&r&fElement: &r&9Water&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fAcutely &b&lFreeze&r&f nearby water sources.",
				"&r&fUse like Frost Walker.",
				"&r&fRange: 10 meters.",
				"&r&fMana cost: 25 &r&9mana&r&f.",
				"&r&fCooldown: 2 seconds."
		}, 25, 40, spelltype.WATER);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		int radius = 10; 
		int radius2 = 1;
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.AMBIENT_UNDERWATER_EXIT, SoundCategory.MASTER, 1, 1);
		for (int iy = (radius2 * -1); iy < (radius2 * 1); iy++)
		{
			for (int ix = (radius * -1); ix < (radius * 1); ix++)
			{
				for (int iz = (radius * -1); iz < (radius * 1); iz++)
				{
					
					Block target = event.getPlayer().getWorld().getBlockAt(event.getPlayer().getLocation().add(new Location(event.getPlayer().getWorld(), ix, iy, iz)));
					
					if (target.getType().equals(Material.WATER))
					{
						target.setType(Material.FROSTED_ICE);
					}	
				}
			}
		}
		return true;
	}

}
