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

public class SpellToxBomb extends Spell
{

	public SpellToxBomb()
	{
		super("ToxBomb", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fTox Bomb&r&7&ko&r",
				"&r&fElement: &r&a&lTØX&r&f.",
				"&r&fSpell Type: &cOffensive &6&lSignature&r&f.",
				"&r&fThrow a concocted concentration of &r&a&lTØX&r&f.",
				"&r&fDeals 4 hearts of &a&lPoison",
				"&r&cDamage&f over 5 seconds.",
				"&r&fMana cost: 50 &r&9mana&r&f.",
				"&r&fCooldown: 3 seconds."
		}, 50, 60, spelltype.TOX);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_SPLASH_POTION_THROW, SoundCategory.MASTER, 1, 1);
		ItemStack p = new ItemStack(Material.SPLASH_POTION);
		PotionMeta meta = (PotionMeta) p.getItemMeta();
		meta.setBasePotionData(new PotionData(PotionType.POISON));
		meta.addCustomEffect(new PotionEffect(PotionEffectType.POISON, 100, 1), true);
		p.setItemMeta(meta);
		ThrownPotion tp = player.launchProjectile(ThrownPotion.class);
		tp.setItem(p);
		return true;
	}

}
