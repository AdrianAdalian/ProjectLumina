package com.perceus.lumina.spells.holy;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellFullHeal extends Spell
{

	public SpellFullHeal()
	{
		super("FullHeal", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fHeal&e&l+&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &6&lSignature &r&aSupport&f.",
				"&r&fFully heals the caster.",
				"&r&aHeals &r&f10+ hearts to self.",
				"&r&fMana cost: 25 &r&9mana&r&f.",
				"&r&fCooldown: 3 seconds."
		}, 75, 100, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		if (player.getHealth() == player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) 
		{
			player.sendMessage("You are already at Maximum Health.");
			return false;
		}
		player.playSound(player.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
		player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
		return true;
	}

}
