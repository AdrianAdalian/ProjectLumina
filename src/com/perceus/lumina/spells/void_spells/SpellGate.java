package com.perceus.lumina.spells.void_spells;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.LuminaGui;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellGate extends Spell
{

	public SpellGate()
	{
		super("Gate", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fGate&r&7&ko&r",
				"&r&fElement: &r&3&lVOID&r&f.",
				"&r&fSpell Type: &6&lSignature &r&bUtility&f.",
				"&r&fTeleport between the Overworld, Nether, and The End.",
				"&r&fMana cost: 100 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 100, 20, spelltype.VOID);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		player.playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN, SoundCategory.MASTER, 1, 1);
		LuminaGui.openGUI(player, Bukkit.createInventory(null, 27, "Lumina GUI: Choose a Locale"));	
		return true;
	}

}
