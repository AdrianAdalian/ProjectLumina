package com.perceus.lumina.spells.geo;

import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellExtract extends Spell
{

	public SpellExtract()
	{
		super("Extract", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fExtract&r&7&ko&r",
				"&r&fElement: &r&6Geo&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fExtract target ore for a random amount.",
				"&r&fExpected extraction can be 1-10 pieces.",
				"&r&fMana cost: 50 &r&9mana&r&f.",
				"&r&fCooldown: 1 seconds."
		}, 50, 20, spelltype.GEO);
	}

	
	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		List<Material> validOres = List.of(Material.COAL_ORE, Material.COPPER_ORE);
		
		Block target = player.getTargetBlock(null, 7);
		Random random = new Random();
		int actualRandom = 1 + random.nextInt(10);
		if (validOres.contains(target.getType())) 
		{
			target.setType(Material.AIR);
			target.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, target.getLocation(), 1);
			for (ItemStack stack : target.getDrops(new ItemStack(Material.DIAMOND_PICKAXE))) 
			{
				ItemStack cloneStack = stack.clone();
				cloneStack.setAmount(actualRandom);
				player.getInventory().addItem(cloneStack);
			}						
			return true;
		}
		
		player.sendMessage("Invalid Target");
		return false;
	}

}
