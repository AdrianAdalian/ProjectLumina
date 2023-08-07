package com.perceus.lumina.spells.holy;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.GetNearestEntity;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellPacify extends Spell
{

	public SpellPacify()
	{
		super("Pacify", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fPacify&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &aSupport&f.",
				"&r&fPacify target mob.",
				"&r&fRange: 30 meters.",
				"&r&fMana cost: 5 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 5, 20, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 30);
		if (target instanceof Mob)
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			((Mob) target).setTarget(null);
			return true;
		}
		
		player.sendMessage("Invalid Target");
		return false;
	}

}
