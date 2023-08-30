package com.perceus.lumina.spells.holy;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellLumina extends Spell
{

	public SpellLumina()
	{
		super("Lumina", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fLumina&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &6&lSignature&r&f Flagship &bUtility&f.",
				"&r&fCast a wisp of light at target block.",
				"&r&fDuration: 30 seconds.",
				"&r&fMana cost: 5 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 5, 20, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		if (event.getClickedBlock() == null) 
		{
			return false;
		}
		
		Block block = event.getClickedBlock().getRelative(event.getBlockFace());
		if (!block.getType().isAir()) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		block.setType(Material.LIGHT);
		Bukkit.getScheduler().runTaskLater(Lumina.instance, ()->{
			block.setType(Material.AIR);
		}, 600);
		return true;
	}

}
