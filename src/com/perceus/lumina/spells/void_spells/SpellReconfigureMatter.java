package com.perceus.lumina.spells.void_spells;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellReconfigureMatter extends Spell
{

	public SpellReconfigureMatter()
	{
		super("ReconfigureMatter", new String[]{
				"&r&7&ko&r&7&lSpell: &r&fReconfigure Matter&r&7&ko&r",
				"&r&fElement: &r&3&lVOID&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fOpens a portable crafting table.",
				"&r&fMana cost: 5 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 5, 20, spelltype.VOID);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{

		player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, SoundCategory.MASTER, 1, 1);
		player.openInventory(player.openWorkbench(player.getLocation(), true));
		
		return true;
	}

}
