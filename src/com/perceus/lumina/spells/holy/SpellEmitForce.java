package com.perceus.lumina.spells.holy;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellEmitForce extends Spell
{

	public SpellEmitForce()
	{
		super("EmitForce", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fEmit Force&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &6&lSignature &r&aSupport&f &dAOE&f.", 
				"&r&fEmits a radial force, subjugating targets.",
				"&r&fRange: 10 meters.",
				"&r&fMana cost: 5 &r&9mana&r&f."
		}, 5, 20, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		if (player.getNearbyEntities(10,10,10).size() == 0)
		{
			player.sendMessage("Invalid Target.");
			return false;
		}
		player.playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
		for (Entity target : player.getNearbyEntities(10,10,10))
		{
			target.setVelocity(target.getLocation().toVector().subtract(player.getLocation().toVector()));
			
		}
		return true;
	}

}
