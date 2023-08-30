package com.perceus.lumina.spells.holy;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.utils.GetNearestEntity;

public class SpellRapport extends Spell
{

	public SpellRapport()
	{
		super("Rapport", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fRapport&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &aSupport &bUtility&f.",
				"&r&fAngers target mob.",
				"&r&fRange: 20 meters.",
				"&r&fMana cost: 15 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 15, 1, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 20);
		if (!(target instanceof Mob)) 
		{
			player.sendMessage("Invalid Target");
		}
		player.playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
		((Mob) target).setTarget(player);
		return true;
	}

}
