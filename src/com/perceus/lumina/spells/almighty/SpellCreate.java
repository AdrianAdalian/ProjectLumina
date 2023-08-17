package com.perceus.lumina.spells.almighty;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.LuminaGui;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellCreate extends Spell
{

	public SpellCreate()
	{
		super("Create", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fCreate&r&7&ko&r",
				"&r&fElement: &r&f&lΔlmιghτγ&r&f.",
				"&r&fSpell Type: &6&lSignature&r &bUtility&f.",
				"&r&fAllows the caster to create matter.",
				"&r&fMana cost: 500 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 500, 200, spelltype.ALMIGHTY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		
		player.playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN, SoundCategory.MASTER, 1, 1);
		LuminaGui.openGUI(player, Bukkit.createInventory(null, 27, "Lumina GUI: Choose an Item"));
		return true;
	}

}
