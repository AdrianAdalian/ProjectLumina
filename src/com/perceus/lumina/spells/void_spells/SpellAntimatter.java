package com.perceus.lumina.spells.void_spells;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellAntimatter extends Spell
{

	public SpellAntimatter()
	{
		super("Antimatter", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fAntimatter&r&7&ko&r",
				"&r&fElement: &r&3&lVOID&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fSummon a small concentration of antimatter",
				"&r&fthat causes an explosion at any target block.",
				"&r&fRange: 25 meters.",
				"&r&fMana cost: 30 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 30, 100, spelltype.VOID);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Block target = player.getTargetBlock(null, 25);
		if (target.getType().equals(Material.AIR)) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		player.playSound(player.getLocation(), Sound.ENTITY_SHULKER_SHOOT, SoundCategory.MASTER, 1, 1);
		target.getWorld().createExplosion(target.getLocation(), 3);
		return true;
	}

}
