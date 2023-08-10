package com.perceus.lumina.spells.void_spells;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellCataclysm extends Spell
{

	public SpellCataclysm()
	{
		super("Cataclysm", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fCataclysm&r&7&ko&r",
				"&r&fElement: &r&3&lVOID&r&f.",
				"&r&fSpell Type: &cOffensive&6&l Signature&r&f.",
				"&r&fSummon 5 progressively expanding explosions",
				"&r&fat target block, dessimating the surrounding area.",
				"&r&fRange: 40 meters.",
				"&r&fMana cost: 500 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 500, 200, spelltype.VOID);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Block target = player.getTargetBlock(null, 40);
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_SHULKER_SHOOT, SoundCategory.MASTER, 1, 1);
		player.getWorld().createExplosion(target.getLocation(), 1);
		
		Bukkit.getScheduler().runTaskLater(Lumina.instance, ()-> player.getWorld().createExplosion(target.getLocation(), 3), 10); 
		Bukkit.getScheduler().runTaskLater(Lumina.instance, ()-> player.getWorld().createExplosion(target.getLocation(), 6), 20);
		Bukkit.getScheduler().runTaskLater(Lumina.instance, ()-> player.getWorld().createExplosion(target.getLocation(), 8), 30);
		Bukkit.getScheduler().runTaskLater(Lumina.instance, ()-> player.getWorld().createExplosion(target.getLocation(), 12), 40);
		return true;
	}

}
