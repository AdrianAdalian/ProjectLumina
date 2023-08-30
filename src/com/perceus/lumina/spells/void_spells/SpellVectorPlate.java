package com.perceus.lumina.spells.void_spells;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.utils.GetNearestEntity;

public class SpellVectorPlate extends Spell
{

	public SpellVectorPlate()
	{
		super("VectorPlate", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fPull&r&7&ko&r",
				"&r&fElement: &r&3&lVOID&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fEmit an expanding force from the caster's hands",
				"&r&fpushing them towards any target.",
				"&r&fRange: 30 meters.",
				"&r&fMana cost: 5 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 5, 20, spelltype.VOID);
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
			player.playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			player.setVelocity(target.getLocation().toVector().subtract(player.getLocation().toVector()).normalize().multiply(5));
			return true;
	}

}
