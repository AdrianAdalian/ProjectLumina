package com.perceus.lumina.spells.fire;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.EntityDeathListener;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellPhoenixBlessing extends Spell
{

	public SpellPhoenixBlessing() {
		super("PhoenixBlessing", new String[] {
                "&r&7&ko&r&7&lSpell: &r&fPhoenix' Blessing&r&7&ko&r",
                "&r&fElement: &r&cFire&r&f.",
                "&r&fSpell Type: &bUtility&f.",
                "&r&fRevives the caster if they die within 5 seconds.",
                "&r&fMana cost: 250 &r&9mana&r&f.",
                "&r&fCooldown: 5 seconds."
        }, 250, 100, spelltype.FIRE);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event) 
	{
		if (EntityDeathListener.isProtected(player))
		{
			player.sendMessage("You are already protected from death.");
			return false;
		}

		EntityDeathListener.protectPlayer(player);
		return true;
	}
}
