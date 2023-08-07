package com.perceus.lumina.spells.geo;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellCultivate extends Spell
{

	public SpellCultivate()
	{
		super("Cultivate", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fCultivate&r&7&ko&r",
				"&r&fElement: &r&6Geo&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fFully grows any target crop.",
				"&r&fMana cost: 5 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 5, 20, spelltype.GEO);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Block target = player.getTargetBlock(null, 5);
		
		if (target.getBlockData() instanceof Ageable)
		{
			player.playSound(player.getLocation(), Sound.ITEM_BONE_MEAL_USE, SoundCategory.MASTER, 1, 1);
			target.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, target.getLocation().add(new Location(target.getWorld(), 0,1,0)), 1);
			Ageable data = (Ageable) target.getBlockData();
			data.getMaximumAge(); 
			data.setAge(data.getMaximumAge());
			target.setBlockData(data);
			return true;
		}
		player.sendMessage("Invalid Target");
		return false;
	}

}
