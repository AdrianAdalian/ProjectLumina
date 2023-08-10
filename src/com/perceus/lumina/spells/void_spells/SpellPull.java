package com.perceus.lumina.spells.void_spells;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.GetNearestEntity;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellPull extends Spell
{

	public SpellPull()
	{
		super("Pull", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fPull&r&7&ko&r",
				"&r&fElement: &r&3&lVOID&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fEmit a collapsing force from the caster's hands",
				"&r&fpulling any target towards them.",
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
			player.sendMessage("Invalid Target.");
			return false;
		}
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			target.setVelocity(event.getPlayer().getLocation().toVector().subtract(target.getLocation().toVector()).normalize().multiply(5));
			return true;
	}

}
