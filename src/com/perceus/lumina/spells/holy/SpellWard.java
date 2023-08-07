package com.perceus.lumina.spells.holy;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellWard extends Spell
{

	public SpellWard()
	{
		super("Ward", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fWard&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &aSupport&f.",
				"&r&fShields the caster in a magical",
				"&r&fbarrier for 2 seconds, negating all damage.",
				"&r&fMana cost: 20 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 20, 100, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{

		player.setInvulnerable(true);
		player.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_NETHERITE, SoundCategory.MASTER, 1, 1);
		Bukkit.getScheduler().runTaskLater(Lumina.instance, () -> {player.setInvulnerable(false); 
		player.playSound(player.getLocation(), Sound.BLOCK_CHAIN_BREAK, SoundCategory.MASTER, 1, 1);}, 40);
		return true;
	}

}
