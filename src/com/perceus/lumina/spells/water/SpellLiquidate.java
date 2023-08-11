package com.perceus.lumina.spells.water;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellLiquidate extends Spell
{

	public SpellLiquidate()
	{
		super("Liquidate", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fLiquidate&r&7&ko&r",
				"&r&fElement: &r&9Water&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fPlaces a water source at target block.",
				"&r&fMana cost: 5 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 5, 20, spelltype.WATER);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Block target = player.getTargetBlock(null, 5) ;
		
		if (target == null)
		{
			player.sendMessage("Invalid Target.");
			return false;
		}
		
		if (event.getClickedBlock() == null) 
		{
			return false;
		}
		
		player.playSound(player.getLocation(), Sound.BLOCK_GRASS_PLACE, SoundCategory.MASTER, 1, 1);
		
		event.getClickedBlock().getRelative(event.getBlockFace()).setType(Material.WATER);
		return true;
	}

}
