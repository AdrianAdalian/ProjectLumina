package com.perceus.lumina.spells.void_spells;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellVoidContainment extends Spell
{

	public SpellVoidContainment()
	{
		super("VoidContainment", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fVoid Containment&r&7&ko&r",
				"&r&fElement: &r&3&lVOID&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fAllows the caster to freely store matter.",
				"&r&fMana cost: 10 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 10, 100, spelltype.VOID);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{

		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN, SoundCategory.MASTER, 1, 1);
		Inventory enderchest = player.getEnderChest();
		player.openInventory(enderchest);
		return true;
	}

}
