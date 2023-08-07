package com.perceus.lumina.spells.holy;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellVialOfSupport extends Spell
{

	public SpellVialOfSupport()
	{
		super("VialOfSupport", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fVial of Support&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &aSupport&f.",
				"&r&fThrow a vial that &aheals&f and &6buffs&f.",
				"&r&fMana cost: 50 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 25, 60, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_LINGERING_POTION_THROW, SoundCategory.MASTER, 1, 1);
		
		ItemStack thrownpotion = new ItemStack(Material.SPLASH_POTION);
		PotionMeta meta = (PotionMeta) thrownpotion.getItemMeta();
		meta.setBasePotionData(new PotionData(PotionType.INSTANT_HEAL));
		meta.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 20, 1), true);
		meta.addCustomEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 400, 0), true);
		meta.addCustomEffect(new PotionEffect(PotionEffectType.ABSORPTION, 400, 1), true);
		thrownpotion.setItemMeta(meta);
		
		ThrownPotion sludge = event.getPlayer().launchProjectile(ThrownPotion.class);
		sludge.setItem(thrownpotion);
		
		return true;
	}

}
