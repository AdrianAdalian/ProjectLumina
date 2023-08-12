package com.perceus.lumina.spells.unholy;

import com.perceus.lumina.EntityDeathListener;
import com.perceus.lumina.Player;
import com.perceus.lumina.PlayerInteractEvent;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellBeyondTheGrave extends Spell
{

	public SpellBeyondTheGrave() {
		super("BeyondTheGrave", new String[] {
                "&r&7&ko&r&7&lSpell: &r&fAnti-Magic Missile&r&7&ko&r",
                "&r&fElement: &r&4&o&lUnholy&r&f.",
                "&r&fSpell Type: &bUtility&f.",
                "&r&fRevives the caster if they die within 5 seconds.",
                "&r&fMana cost: 250 &r&9mana&r&f.",
                "&r&fCooldown: 5 seconds."
        }, 250, 100, spelltype.UNHOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event) 
	{
		if (EntityDeathListener.isProtected(player))
		{
			player.sendMessage("You are already protected from death!");
			return false;
		}

		EntityDeathListener.protectPlayer(player);
	}
}
