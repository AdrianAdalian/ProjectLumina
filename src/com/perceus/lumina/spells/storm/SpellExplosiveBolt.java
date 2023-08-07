package com.perceus.lumina.spells.storm;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellExplosiveBolt extends Spell
{

	public SpellExplosiveBolt()
	{
		super("ExplosiveBolt", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fExplosive Bolt&r&7&ko&r",
				"&r&fElement: &r&dStorm&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fSummon a small bolt of lightning on target block.",
				"&r&fDuring a &dStorm&f, the bolt explodes.",
				"&r&fRange: 30 meters.",
				"&r&fMana cost: 200 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 200, 100, spelltype.STORM);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		boolean weather = Bukkit.getWorlds().get(0).isClearWeather();
		
		if (weather == true) 
		{
			Block target = player.getTargetBlock(null, 30);
			if (target.getType().equals(Material.AIR))
			{
				player.sendMessage("Invalid Target");
				return false;			
			}
			target.getWorld().strikeLightning(target.getLocation());
			return true;
		}
		
		Block target = player.getTargetBlock(null, 30);
		if (target.getType().equals(Material.AIR)) 
		{
			player.sendMessage("Invalid Target");
			return false;	
		}
		
		target.getWorld().strikeLightning(target.getLocation());
		Bukkit.getScheduler().runTaskLater(Lumina.instance, ()->target.getWorld().createExplosion(target.getLocation(), 3), 60);
		return true;
	}

}
