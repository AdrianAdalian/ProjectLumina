package com.perceus.lumina.spells.fire;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellErupt extends Spell
{

	public SpellErupt()
	{
		super("Erupt", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fErupt&r&7&ko&r",
				"&r&fElement: &r&cFire&r&f.",
				"&r&fSpell Type: &bUtility&f.", 
				"&r&fAccutely erupt lava out of the earth.",
				"&r&fMana cost: 5 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 5, 20, spelltype.FIRE);
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
		
		player.playSound(player.getLocation(), Sound.ITEM_BUCKET_EMPTY_LAVA, SoundCategory.MASTER, 1, 1);
		
		event.getClickedBlock().getRelative(event.getBlockFace()).setType(Material.LAVA);
		return true;
	}

}
