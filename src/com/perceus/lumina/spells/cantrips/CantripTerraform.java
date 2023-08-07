package com.perceus.lumina.spells.cantrips;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class CantripTerraform extends Spell
{

	public CantripTerraform()
	{
		super("Terraform", new String[]{"&r&e&ko&r&7&lCantrip: &r&fTerraform&r&e&ko&r",
				"&r&fElement: &r&6Geo&r&f.",
				"&r&fSpell Type: &bUtility &eCantrip&f.",
				"&r&fPlaces a block of Dirt at target block.", 
				"&r&fMana cost: 0 &r&9mana&r&f.",
				"&r&fCooldown: 2 seconds."}, 0, 40, spelltype.GEO);
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
		
		event.getClickedBlock().getRelative(event.getBlockFace()).setType(Material.DIRT);
		return true;
	}

}
