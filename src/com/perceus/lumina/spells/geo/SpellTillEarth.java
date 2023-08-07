package com.perceus.lumina.spells.geo;

import java.util.Set;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellTillEarth extends Spell
{

	public SpellTillEarth()
	{
		super("TillEarth", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fTill Earth&r&7&ko&r",
				"&r&fElement: &r&6Geo&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fTills dirt and other dirt-related blocks into farmland.",
				"&r&fMana cost: 5 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 5, 20, spelltype.GEO);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{

		Block block = player.getTargetBlock(null, 5);
		Set<Material> soilBlocks = Set.of(Material.DIRT, Material.GRASS_BLOCK, Material.COARSE_DIRT, Material.PODZOL, Material.MYCELIUM, Material.DIRT_PATH, Material.ROOTED_DIRT);

		if(soilBlocks.contains(block.getType())) 
		{
		    player.playSound(player.getLocation(), Sound.ITEM_HOE_TILL, SoundCategory.MASTER, 1, 1);
		    block.setType(Material.FARMLAND);
		    return true;
		}
		player.sendMessage("Invalid Target");
		
		return false;
	}

}
