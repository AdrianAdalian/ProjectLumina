package com.perceus.lumina.spells.unholy;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellDamagingForce extends Spell
{

	public SpellDamagingForce()
	{
		super("DamagingForce", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fEmit Force&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &6&lSignature &r&aSupport&f &dAOE&f.", 
				"&r&fEmits a radial force, subjugating targets.",
				"&r&fDeal 1 hearts of &cdamage&f.",
				"&r&fRange: 10 meters.",
				"&r&fMana cost: 15 &r&9mana&r&f."
		}, 15, 40, spelltype.UNHOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		if (event.getPlayer().getNearbyEntities(10, 10, 10).size() == 0)
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_WITHER_SHOOT, SoundCategory.MASTER, 1, 1);
		
		for (Entity target : event.getPlayer().getNearbyEntities(10, 10, 10))
		{
			if (!(target instanceof Damageable)) 
			{
				continue;
			}
			((Damageable) target).damage(4);
			target.setVelocity(target.getLocation().toVector().subtract(event.getPlayer().getLocation().toVector()));
			
		}
		return true;
	}

}
