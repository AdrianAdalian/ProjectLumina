package com.perceus.lumina.spells.geo;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellGrowth extends Spell
{

	public SpellGrowth()
	{
		super("Growth", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fGrowth&r&7&ko&r",
				"&r&fElement: &r&6Geo&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fCauses growth at target Grass Block.",
				"&r&fMana cost: 5 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 5, 20, spelltype.GEO);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Block block = player.getTargetBlock(null, 5);
		
		if (!block.getType().equals(Material.GRASS_BLOCK)) {
			player.sendMessage("Invalid Target");
			return false;
		}
		player.playSound(player.getLocation(), Sound.ITEM_BONE_MEAL_USE, SoundCategory.MASTER, 1, 1);
		block.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, block.getLocation().add(new Location(block.getWorld(), 0,1,0)), 1);
		block.applyBoneMeal(BlockFace.UP);
		return true;
	}

}
