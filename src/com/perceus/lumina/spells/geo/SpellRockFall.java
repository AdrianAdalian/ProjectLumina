package com.perceus.lumina.spells.geo;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.PointedDripstone;
import org.bukkit.block.data.type.PointedDripstone.Thickness;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.GetNearestEntity;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellRockFall extends Spell
{

	public SpellRockFall()
	{
		super("RockFall", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fRock Fall&r&7&ko&r",
				"&r&fElement: &r&6Geo&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fSummon a falling rock onto target entity.",
				"&r&fDeals relative &cdamage&f to target's location.",
				"&r&fMana cost: 50 &r&9mana&r&f.",
				"&r&fCooldown: 2 seconds."
		}, 50, 40, spelltype.GEO);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 30);
		
		if (target == null) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_FIRECHARGE_USE, SoundCategory.MASTER, 1, 1);
		Location newlocation = target.getLocation().add(new Location(event.getPlayer().getWorld(), 0, 20, 0)) ;
		newlocation.add(0, 20, 0);
		
		PointedDripstone pd = (PointedDripstone) Material.POINTED_DRIPSTONE.createBlockData();
		pd.setVerticalDirection(BlockFace.DOWN);
		pd.setThickness(Thickness.TIP_MERGE);
		target.getWorld().spawnFallingBlock(newlocation, pd);
		return true;
	}

}
