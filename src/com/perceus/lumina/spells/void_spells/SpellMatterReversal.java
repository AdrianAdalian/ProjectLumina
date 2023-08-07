package com.perceus.lumina.spells.void_spells;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellMatterReversal extends Spell
{

	public SpellMatterReversal()
	{
		super("MatterReversal", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fMatter Reversal&r&7&ko&r",
				"&r&fElement: &r&3&lVOID&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fCause any target block to acutely decompose.",
				"&r&fRange: 2 meters.",
				"&r&fMana cost: 10 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 10, 20, spelltype.VOID);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Block target = player.getTargetBlock(null, 2) ;
		
		if (target.getType().equals(Material.AIR))
		{
			return false;			
		}
		if (target.getType().equals(Material.BEDROCK)) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		player.playSound(player.getLocation(), Sound.ENTITY_FOX_TELEPORT, SoundCategory.MASTER, 1, 1);
		target.getLocation().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, target.getLocation(), 1);
		target.breakNaturally();
		return true;
	}

}
