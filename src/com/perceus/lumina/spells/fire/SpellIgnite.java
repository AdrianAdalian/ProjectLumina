package com.perceus.lumina.spells.fire;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.GetNearestEntity;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.SpellParticle;

public class SpellIgnite extends Spell
{

	public SpellIgnite()
	{
		super("Ignite", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fIgnite&r&7&ko&r",
				"&r&fElement: &r&cFire&r&f.",
				"&r&fSpell Type: &cOffensive &bUtility&f.",
				"&r&fIgnite target block or target entity.",
				"&r&fDuration: 10 seconds.",
				"&r&fRange: 10 meters.",
				"&r&fMana cost: 5 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 5, 20, spelltype.FIRE);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{

		Entity target = GetNearestEntity.getNearestEntityInSight(player, 10);
		if (target == null) 
		{
			if (event.getClickedBlock() == null) 
			{
				player.sendMessage("Invalid Target");
				return false;
			}
			player.playSound(player.getLocation(), Sound.ITEM_FLINTANDSTEEL_USE, SoundCategory.MASTER, 1, 1);
			Block target2 = event.getClickedBlock().getRelative(event.getBlockFace());
			target2.setType(Material.FIRE);
			return true;
		}
		
		SpellParticle.drawLine(player.getLocation(), target.getLocation(), 1, Particle.FLAME, null);
		player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, SoundCategory.MASTER, 1, 1);
		target.setFireTicks(200);
		return true;
	}

}
