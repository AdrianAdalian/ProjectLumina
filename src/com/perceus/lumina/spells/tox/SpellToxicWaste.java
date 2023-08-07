package com.perceus.lumina.spells.tox;

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

public class SpellToxicWaste extends Spell
{

	public SpellToxicWaste()
	{
		super("ToxicWaste", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fToxic Waste&r&7&ko&r",
				"&r&fElement: &r&a&lTØX&r&f.",
				"&r&fSpell Type: &cOffensive&f &6&lSignature&r&f.",
				"&r&fThrow a concocted concentration of &r&a&lTØX&r&f,",
				"&r&fleaving behind a field of &a&lPoison&r&f.",
				"&r&fMana cost: 100 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 100, 100, spelltype.TOX);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_LINGERING_POTION_THROW, SoundCategory.MASTER, 1, 1);
		
		ItemStack tp = new ItemStack(Material.LINGERING_POTION);
		PotionMeta meta = (PotionMeta) tp.getItemMeta();
		meta.setBasePotionData(new PotionData(PotionType.POISON));
		meta.addCustomEffect(new PotionEffect(PotionEffectType.POISON, 200, 0), true);
		tp.setItemMeta(meta);
		
		ThrownPotion waste = event.getPlayer().launchProjectile(ThrownPotion.class);
		waste.setItem(tp);
		
		return true;
	}

}
