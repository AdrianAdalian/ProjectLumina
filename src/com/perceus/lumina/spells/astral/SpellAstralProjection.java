package com.perceus.lumina.spells.astral;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellAstralProjection extends Spell
{

	public SpellAstralProjection()
	{
		super("AstralProjection", new String[] {
				"&r&7&ko&r&7&lSpell: &r&d&l✩ &r&fAstral Projection &d&l✩&r&7&ko&r",
				"&r&fElement: &r&5A&ds&5t&dr&5α&dl&r&f.",
				"&r&fSpell Type: &6&lSignature &r&bUtility&f.",
				"&r&fEject the caster's consciousness.", 
				"&r&fExit by possessing the apparition.",
				"&r&fIf the apparition is destroyed, the caster will die.",
				"&r&fMana cost: 500 &r&9mana&r&f.",
		}, 500, 0, spelltype.ASTRAL);
	}
	private static Map<UUID, ArmorStand> standInstance = new HashMap<>();
	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		if (event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) 
		{
			player.sendMessage("This spell cannot be cast whilst in Creative Mode");
			return false; 
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
		Entity stand = player.getLocation().getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
		stand.setCustomName(event.getPlayer().getDisplayName() + "'s §r§f§ko §r§d§oAstral Apparition §r§f§ko");
		stand.setCustomNameVisible(true);
		stand.setGlowing(true);
		stand.setPersistent(true);
		((LivingEntity) stand).setRemoveWhenFarAway(false);
		standInstance.put(event.getPlayer().getUniqueId(), (ArmorStand) stand);
		event.getPlayer().setGameMode(GameMode.SPECTATOR);
		standRunnable(player);
		return true;
	}
	private static void standRunnable(Player p) 
	{
		new BukkitRunnable() 
		{
			@Override
			public void run() 
			{
				if (!p.isOnline()) 
				{
					this.cancel();
					standInstance.get(p.getUniqueId()).remove();
					standInstance.clear();
					return;
				}
				
				if (standInstance.get(p.getUniqueId()).isDead()) 
				{
					this.cancel();
					p.sendMessage("§r§4Warning§f: Your apparition has been §4Destroyed§f.");
					p.setGameMode(GameMode.SURVIVAL);
					p.damage(1000);
					standInstance.get(p.getUniqueId()).teleport(new Location(standInstance.get(p.getUniqueId()).getWorld(), 1000d, 1000d, 1000d));
					standInstance.get(p.getUniqueId()).remove();
					standInstance.clear();
					return;
				}
				
				if (p.getLocation().getBlockY() < -64) 
				{
					this.cancel();
					p.sendMessage("§r§4Warning§f: Entering The_Void Biome. Canceling Astral Form.");
					p.teleport(standInstance.get(p.getUniqueId()).getLocation());
					p.setGameMode(GameMode.SURVIVAL);
					standInstance.get(p.getUniqueId()).teleport(new Location(standInstance.get(p.getUniqueId()).getWorld(), 1000d, 1000d, 1000d));
					standInstance.get(p.getUniqueId()).remove();
					standInstance.clear();
					return;
				}
				
				if (!(p.getSpectatorTarget() == null)) 
				{
					this.cancel();
					p.setGameMode(GameMode.SURVIVAL);
					standInstance.get(p.getUniqueId()).teleport(new Location(standInstance.get(p.getUniqueId()).getWorld(), 1000d, 1000d, 1000d));
					standInstance.get(p.getUniqueId()).remove();
					standInstance.clear();
					return;
				}
			}
		}.runTaskTimer(Lumina.instance, 0, 20);
	}
}
