package com.perceus.lumina;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.perceus.lumina.spells.cantrips.CantripBlink;
import com.perceus.lumina.spells.cantrips.CantripEmbers;
import com.perceus.lumina.spells.cantrips.CantripGust;
import com.perceus.lumina.spells.cantrips.CantripHealOther;
import com.perceus.lumina.spells.cantrips.CantripLifeSteal;
import com.perceus.lumina.spells.cantrips.CantripSoak;
import com.perceus.lumina.spells.cantrips.CantripTerraform;
import com.perceus.lumina.spells.ether.SpellEquilibrium;
import com.perceus.lumina.spells.fire.SpellChaosMeteor;
import com.perceus.lumina.spells.fire.SpellCombustion;
import com.perceus.lumina.spells.fire.SpellDragonBreath;
import com.perceus.lumina.spells.fire.SpellDragonFlare;
import com.perceus.lumina.spells.fire.SpellErupt;
import com.perceus.lumina.spells.fire.SpellFireball;
import com.perceus.lumina.spells.fire.SpellFirebolt;
import com.perceus.lumina.spells.fire.SpellFlamethrower;
import com.perceus.lumina.spells.fire.SpellIgnite;
import com.perceus.lumina.spells.fire.SpellIgnitionDrive;
import com.perceus.lumina.spells.fire.SpellInferno;
import com.perceus.lumina.spells.fire.SpellInsulate;
import com.perceus.lumina.spells.fire.SpellLaunch;
import com.perceus.lumina.spells.fire.SpellMeteor;
import com.perceus.lumina.spells.fire.SpellOverclockProtocol;
import com.perceus.lumina.spells.fire.SpellOverheat;
import com.perceus.lumina.spells.fire.SpellPrimedEruption;
import com.perceus.lumina.spells.fire.SpellPyroball;
import com.perceus.lumina.spells.fire.SpellRebrand;
import com.perceus.lumina.spells.geo.SpellBoulder;
import com.perceus.lumina.spells.geo.SpellCultivate;
import com.perceus.lumina.spells.geo.SpellDracomorph;
import com.perceus.lumina.spells.geo.SpellEarthquake;
import com.perceus.lumina.spells.geo.SpellFortify;
import com.perceus.lumina.spells.geo.SpellGeomorph;
import com.perceus.lumina.spells.geo.SpellGrowth;
import com.perceus.lumina.spells.geo.SpellMagemorph;
import com.perceus.lumina.spells.geo.SpellMetalmorph;
import com.perceus.lumina.spells.geo.SpellMinersLuck;
import com.perceus.lumina.spells.geo.SpellPebbles;
import com.perceus.lumina.spells.geo.SpellSandBlast;
import com.perceus.lumina.spells.geo.SpellSandstorm;
import com.perceus.lumina.spells.geo.SpellTillEarth;
import com.perceus.lumina.spells.geo.SpellTransmute;
import com.perceus.lumina.spells.holy.SpellAccolades;
import com.perceus.lumina.spells.holy.SpellAmeliorate;
import com.perceus.lumina.spells.holy.SpellAngelicFlight;
import com.perceus.lumina.spells.holy.SpellBanishUndead;
import com.perceus.lumina.spells.holy.SpellBarrier;
import com.perceus.lumina.spells.holy.SpellConstitution;
import com.perceus.lumina.spells.holy.SpellCurseBreak;
import com.perceus.lumina.spells.holy.SpellDisarm;
import com.perceus.lumina.spells.holy.SpellEmitForce;
import com.perceus.lumina.spells.holy.SpellExtricate;
import com.perceus.lumina.spells.holy.SpellFertility;
import com.perceus.lumina.spells.holy.SpellFullHeal;
import com.perceus.lumina.spells.holy.SpellHeal;
import com.perceus.lumina.spells.holy.SpellHealingHands;
import com.perceus.lumina.spells.holy.SpellHolyRecall;
import com.perceus.lumina.spells.holy.SpellJudgement;
import com.perceus.lumina.spells.holy.SpellLumina;
import com.perceus.lumina.spells.holy.SpellMagicBarrage;
import com.perceus.lumina.spells.holy.SpellMagicMissile;
import com.perceus.lumina.spells.holy.SpellMinorHeal;
import com.perceus.lumina.spells.holy.SpellPacify;
import com.perceus.lumina.spells.holy.SpellProtect;
import com.perceus.lumina.spells.holy.SpellRadiance;
import com.perceus.lumina.spells.holy.SpellRapport;
import com.perceus.lumina.spells.holy.SpellRegenerate;
import com.perceus.lumina.spells.holy.SpellSatiate;
import com.perceus.lumina.spells.holy.SpellVialOfSupport;
import com.perceus.lumina.spells.holy.SpellWard;
import com.perceus.lumina.spells.storm.SpellBoost;
import com.perceus.lumina.spells.storm.SpellCharge;
import com.perceus.lumina.spells.storm.SpellElectrocute;
import com.perceus.lumina.spells.storm.SpellExplosiveBolt;
import com.perceus.lumina.spells.storm.SpellGaleForce;
import com.perceus.lumina.spells.storm.SpellGalvanicNeedle;
import com.perceus.lumina.spells.storm.SpellRainDance;
import com.perceus.lumina.spells.storm.SpellSmite;
import com.perceus.lumina.spells.storm.SpellSurge;
import com.perceus.lumina.spells.storm.SpellTailwind;
import com.perceus.lumina.spells.storm.SpellThunderStrike;
import com.perceus.lumina.spells.storm.SpellVaporize;
import com.perceus.lumina.spells.tox.SpellCure;
import com.perceus.lumina.spells.tox.SpellNauseate;
import com.perceus.lumina.spells.tox.SpellPoisonCloud;
import com.perceus.lumina.spells.tox.SpellPoisonDart;
import com.perceus.lumina.spells.tox.SpellPoisonGas;
import com.perceus.lumina.spells.tox.SpellToxBomb;
import com.perceus.lumina.spells.tox.SpellToxicGas;
import com.perceus.lumina.spells.tox.SpellToxicWaste;
import com.perceus.lumina.spells.unholy.SpellAntiMagicMissile;
import com.perceus.lumina.spells.unholy.SpellBeyondTheGrave;
import com.perceus.lumina.spells.unholy.SpellBuffBreak;
import com.perceus.lumina.spells.unholy.SpellConvertUndead;
import com.perceus.lumina.spells.unholy.SpellDamagingForce;
import com.perceus.lumina.spells.unholy.SpellDebilitate;
import com.perceus.lumina.spells.unholy.SpellDemonSight;
import com.perceus.lumina.spells.unholy.SpellDemonicReflex;
import com.perceus.lumina.spells.unholy.SpellDoom;
import com.perceus.lumina.spells.unholy.SpellEmbraceTheShadows;
import com.perceus.lumina.spells.unholy.SpellExpellLiving;
import com.perceus.lumina.spells.unholy.SpellHarvest;
import com.perceus.lumina.spells.unholy.SpellLightShift;
import com.perceus.lumina.spells.unholy.SpellReap;
import com.perceus.lumina.spells.unholy.SpellRot;
import com.perceus.lumina.spells.unholy.SpellUndeadEffigy;
import com.perceus.lumina.spells.unholy.SpellUnholyRecall;
import com.perceus.lumina.spells.void_spells.SpellAntiGravity;
import com.perceus.lumina.spells.void_spells.SpellAntimatter;
import com.perceus.lumina.spells.void_spells.SpellAtomicBolt;
import com.perceus.lumina.spells.void_spells.SpellBanish;
import com.perceus.lumina.spells.void_spells.SpellCataclysm;
import com.perceus.lumina.spells.void_spells.SpellCrush;
import com.perceus.lumina.spells.void_spells.SpellGate;
import com.perceus.lumina.spells.void_spells.SpellGravitas;
import com.perceus.lumina.spells.void_spells.SpellMatterReversal;
import com.perceus.lumina.spells.void_spells.SpellNullPointEnchantment;
import com.perceus.lumina.spells.void_spells.SpellOverrideClimate;
import com.perceus.lumina.spells.void_spells.SpellPolarize;
import com.perceus.lumina.spells.void_spells.SpellPrimordialShift;
import com.perceus.lumina.spells.void_spells.SpellPull;
import com.perceus.lumina.spells.void_spells.SpellRecallAnchor;
import com.perceus.lumina.spells.void_spells.SpellReconfigureMatter;
import com.perceus.lumina.spells.void_spells.SpellRift;
import com.perceus.lumina.spells.void_spells.SpellTeleport;
import com.perceus.lumina.spells.void_spells.SpellVectorPlate;
import com.perceus.lumina.spells.void_spells.SpellVoidContainment;
import com.perceus.lumina.spells.void_spells.SpellVoidShift;
import com.perceus.lumina.spells.water.SpellBlizzard;
import com.perceus.lumina.spells.water.SpellConduit;
import com.perceus.lumina.spells.water.SpellFreeze;
import com.perceus.lumina.spells.water.SpellFrost;
import com.perceus.lumina.spells.water.SpellFrostSpike;
import com.perceus.lumina.spells.water.SpellFrostbite;
import com.perceus.lumina.spells.water.SpellGills;
import com.perceus.lumina.spells.water.SpellIceAge;
import com.perceus.lumina.spells.water.SpellLiquidate;
import com.perceus.lumina.spells.water.SpellPoseidonsGrace;
import com.perceus.lumina.spells.water.SpellRiptide;
import com.perceus.lumina.spells.water.SpellScales;
import com.perceus.lumina.spells.water.SpellTidalForce;
import com.perceus.lumina.spells.water.SpellWaveWake;
import com.perceus.lumina.utils.DataUtils;
import com.perceus.lumina.utils.DataUtils.DType;
import com.perceus.lumina.wand.Wand;

public class SpellControlSystem implements Listener
{
	private static Set<Player> lockedplayers = new HashSet<>();
	private static Set<Player> cooldown_mechanic = new HashSet<>();
	
//	@EventHandler
//	public void whileHoldingWand(PlayerItemHeldEvent e) 
//	{
//		if(!Wand.isWand(e.getPlayer().getInventory().getItemInMainHand())) {return;}
//		Wand wand = new Wand(e.getPlayer().getInventory().getItemInMainHand());
//		e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("Current Mana: " + wand.getCurrentDurability() + "/" + wand.getMaxDurability()));
//	}
	@EventHandler
	public void onInteract(PlayerInteractEvent e) 
	{
		if (e.getHand() == EquipmentSlot.OFF_HAND) 
		{
			return;
		}
		
		if(!Wand.isWand(e.getPlayer().getInventory().getItemInMainHand())) { return; }
		
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && !e.getPlayer().isSneaking())
		{
			Wand wand = new Wand(e.getPlayer().getInventory().getItemInMainHand());

			if (!wand.hasSpell(wand.getSpellIndex())) 
			{
				return;
			}
			
			if (lockedplayers.contains(e.getPlayer())) 
			{
				return;
			}
			
			if (cooldown_mechanic.contains(e.getPlayer())) 
			{
				e.getPlayer().sendMessage("Your wand is currently on cooldown.");
				return;
			}
			
			Bukkit.getScheduler().runTask(Lumina.instance, () -> lockedplayers.remove(e.getPlayer()));
			
			if (wand.getCurrentDurability() == 0) 
			{
				e.getPlayer().sendMessage("Not Enough Mana");
				return;
			}
			
			if (wand.getCurrentDurability() > 0 && wand.getSpell(wand.getSpellIndex()).Cast(e.getPlayer(), e)) 
			{
				wand.removeMana(wand.getSpell(wand.getSpellIndex()).getManacost());
				cooldown_mechanic.add(e.getPlayer());
				Bukkit.getScheduler().runTaskLater(Lumina.instance, () -> cooldown_mechanic.remove(e.getPlayer()), wand.getSpell(wand.getSpellIndex()).getCooldown());		
				e.getPlayer().getInventory().setItemInMainHand(wand.getAsItemStack());
				
			}
			lockedplayers.add(e.getPlayer());
			
			return;
		}
		
		if (e.getAction() == Action.LEFT_CLICK_AIR && !e.getPlayer().isSneaking()) 
		{
			Wand wand = new Wand(e.getPlayer().getInventory().getItemInMainHand());
			if (wand.getNextSpell() == null) 
			{
				return;
			}
			wand.rotateSpells();
			
			e.getPlayer().getInventory().setItemInMainHand(wand.getAsItemStack());
			e.getPlayer().sendMessage("[Slot " + (wand.getSpellIndex() + 1) + "] " + "Spell Equipped: " + wand.getSpell(wand.getSpellIndex()).getName());
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ITEM_ARMOR_EQUIP_GENERIC, SoundCategory.MASTER, 1, 1);
			
		}
		return;
	}
	public static Map<String, Spell> spell_registry = new HashMap<>();
	
	public static Map<spelltype, List<Spell>> protoregistry = new EnumMap<>(spelltype.class);
	
	public static void init() 
	{
		
		for (spelltype type : spelltype.values()) 
		{
			type.setGrimoire(generateGrimoire(type));
		}
		//FIRE SPELLS
		SpellFireball spellfireball = new SpellFireball();
		spell_registry.put(spellfireball.getName(), spellfireball);
		SpellIgnite spellignite = new SpellIgnite();
		spell_registry.put(spellignite.getName(), spellignite);
		SpellFirebolt spellfirebolt = new SpellFirebolt();
		spell_registry.put(spellfirebolt.getName(), spellfirebolt);
		SpellMeteor spellmeteor = new SpellMeteor();
		spell_registry.put(spellmeteor.getName(), spellmeteor);
		SpellPyroball spellpyroball = new SpellPyroball();
		spell_registry.put(spellpyroball.getName(), spellpyroball);
		SpellChaosMeteor spellCMeteor = new SpellChaosMeteor();
		spell_registry.put(spellCMeteor.getName(), spellCMeteor);
		SpellDragonBreath spelldragonbreath = new SpellDragonBreath();
		spell_registry.put(spelldragonbreath.getName(), spelldragonbreath);
		SpellDragonFlare spelldracometeor = new SpellDragonFlare();
		spell_registry.put(spelldracometeor.getName(), spelldracometeor);
		SpellCombustion spellcombustion = new SpellCombustion();
		spell_registry.put(spellcombustion.getName(), spellcombustion);
		SpellErupt spellerupt = new SpellErupt();
		spell_registry.put(spellerupt.getName(), spellerupt);
		SpellPrimedEruption spellprimederuption = new SpellPrimedEruption();
		spell_registry.put(spellprimederuption.getName(), spellprimederuption);
		SpellIgnitionDrive spellignitiondrive = new SpellIgnitionDrive();
		spell_registry.put(spellignitiondrive.getName(), spellignitiondrive);
		SpellInsulate spellinsulate = new SpellInsulate();
		spell_registry.put(spellinsulate.getName(), spellinsulate);
		SpellLaunch spelllaunch = new SpellLaunch();
		spell_registry.put(spelllaunch.getName(), spelllaunch);
		SpellOverclockProtocol spellOP = new SpellOverclockProtocol();
		spell_registry.put(spellOP.getName(), spellOP);
		SpellOverheat spelloverheat = new SpellOverheat();
		spell_registry.put(spelloverheat.getName(), spelloverheat);
		SpellInferno spellinferno = new SpellInferno();
		spell_registry.put(spellinferno.getName(), spellinferno);
		SpellFlamethrower spellflamethrower = new SpellFlamethrower();
		spell_registry.put(spellflamethrower.getName(), spellflamethrower);
		SpellRebrand spellrebrand = new SpellRebrand();
		spell_registry.put(spellrebrand.getName(), spellrebrand);
		
		//WATER SPELLS
		SpellRiptide spellriptide = new SpellRiptide();
		spell_registry.put(spellriptide.getName(), spellriptide);
		SpellScales spellscales = new SpellScales();
		spell_registry.put(spellscales.getName(), spellscales);
		SpellTidalForce spellTF = new SpellTidalForce();
		spell_registry.put(spellTF.getName(), spellTF);
		SpellWaveWake spellwavewake = new SpellWaveWake();
		spell_registry.put(spellwavewake.getName(), spellwavewake);
		SpellFrost spellfrost = new SpellFrost();
		spell_registry.put(spellfrost.getName(), spellfrost);
		SpellFrostSpike spellfrostspike = new SpellFrostSpike();
		spell_registry.put(spellfrostspike.getName(), spellfrostspike);
		SpellConduit spellconduit = new SpellConduit();
		spell_registry.put(spellconduit.getName(), spellconduit);
		SpellFrostbite spellfrostbite = new SpellFrostbite();
		spell_registry.put(spellfrostbite.getName(), spellfrostbite);
		SpellFreeze spellfreeze = new SpellFreeze();
		spell_registry.put(spellfreeze.getName(), spellfreeze);
		SpellGills spellgills = new SpellGills();
		spell_registry.put(spellgills.getName(), spellgills);
		SpellBlizzard spellblizzard = new SpellBlizzard();
		spell_registry.put(spellblizzard.getName(), spellblizzard);
		SpellIceAge spelliceage = new SpellIceAge();
		spell_registry.put(spelliceage.getName(), spelliceage);
		SpellPoseidonsGrace spellpgrace = new SpellPoseidonsGrace();
		spell_registry.put(spellpgrace.getName(), spellpgrace);
		SpellLiquidate spellliquidate = new SpellLiquidate();
		spell_registry.put(spellliquidate.getName(), spellliquidate);
		
		//STORM SPELLS
		SpellSmite spellsmite = new SpellSmite();
		spell_registry.put(spellsmite.getName(), spellsmite);
		SpellGalvanicNeedle spellgalvanicneedle = new SpellGalvanicNeedle();
		spell_registry.put(spellgalvanicneedle.getName(), spellgalvanicneedle);
		SpellTailwind spelltailwind = new SpellTailwind();
		spell_registry.put(spelltailwind.getName(), spelltailwind);
		SpellBoost spellboost = new SpellBoost();
		spell_registry.put(spellboost.getName(), spellboost);
		SpellElectrocute spellelectrocute = new SpellElectrocute();
		spell_registry.put(spellelectrocute.getName(), spellelectrocute);
		SpellExplosiveBolt spellexplosivebolt = new SpellExplosiveBolt();
		spell_registry.put(spellexplosivebolt.getName(), spellexplosivebolt);
		SpellGaleForce spellgaleforce = new SpellGaleForce();
		spell_registry.put(spellgaleforce.getName(), spellgaleforce);
		SpellCharge spellcharge = new SpellCharge();
		spell_registry.put(spellcharge.getName(), spellcharge);
		SpellSurge spellsurge = new SpellSurge();
		spell_registry.put(spellsurge.getName(), spellsurge);
		SpellRainDance spellRD = new SpellRainDance();
		spell_registry.put(spellRD.getName(), spellRD);
		SpellThunderStrike spellthunderstrike = new SpellThunderStrike();
		spell_registry.put(spellthunderstrike.getName(), spellthunderstrike);
		SpellVaporize spellvaporize = new SpellVaporize();
		spell_registry.put(spellvaporize.getName(), spellvaporize);
		
		//GEO SPELLS
		SpellGeomorph spellgeomorph = new SpellGeomorph();
		spell_registry.put(spellgeomorph.getName(), spellgeomorph);
		SpellPebbles spellpebbles = new SpellPebbles();
		spell_registry.put(spellpebbles.getName(), spellpebbles);
		SpellMetalmorph spellmetalmorph = new SpellMetalmorph();
		spell_registry.put(spellmetalmorph.getName(), spellmetalmorph);
		SpellMagemorph spellmagemorph = new SpellMagemorph();
		spell_registry.put(spellmagemorph.getName(), spellmagemorph);
		SpellDracomorph spelldracomorph = new SpellDracomorph();
		spell_registry.put(spelldracomorph.getName(), spelldracomorph);
		SpellTillEarth spelltillearth = new SpellTillEarth();
		spell_registry.put(spelltillearth.getName(), spelltillearth);
		SpellCultivate spellcultivate = new SpellCultivate();
		spell_registry.put(spellcultivate.getName(), spellcultivate);
		SpellBoulder spellboulder = new SpellBoulder();
		spell_registry.put(spellboulder.getName(), spellboulder);
		SpellEarthquake spellearthquake = new SpellEarthquake();
		spell_registry.put(spellearthquake.getName(), spellearthquake);
		SpellTransmute spelltransmute = new SpellTransmute();
		spell_registry.put(spelltransmute.getName(), spelltransmute);
		SpellGrowth spellgrowth = new SpellGrowth();
		spell_registry.put(spellgrowth.getName(), spellgrowth);
		SpellMinersLuck spellluck = new SpellMinersLuck();
		spell_registry.put(spellluck.getName(), spellluck);
		SpellFortify spellfortify = new SpellFortify();
		spell_registry.put(spellfortify.getName(), spellfortify);
		SpellSandBlast spellsandblast = new SpellSandBlast();
		spell_registry.put(spellsandblast.getName(), spellsandblast);
		SpellSandstorm spellsandstorm = new SpellSandstorm();
		spell_registry.put(spellsandstorm.getName(), spellsandstorm);
		
		//UNHOLY SPELLS
		SpellRot spellrot = new SpellRot();
		spell_registry.put(spellrot.getName(), spellrot);
		SpellAntiMagicMissile AntiMM = new SpellAntiMagicMissile();
		spell_registry.put(AntiMM.getName(), AntiMM);
		SpellReap spellreap = new SpellReap();
		spell_registry.put(spellreap.getName(), spellreap);
		SpellHarvest spellharvest = new SpellHarvest();
		spell_registry.put(spellharvest.getName(), spellharvest);
		SpellDebilitate spelldebilitate = new SpellDebilitate();
		spell_registry.put(spelldebilitate.getName(), spelldebilitate);
		SpellDemonicReflex spelldemonicreflex = new SpellDemonicReflex();
		spell_registry.put(spelldemonicreflex.getName(), spelldemonicreflex);
		SpellDemonSight spelldemonsight = new SpellDemonSight();
		spell_registry.put(spelldemonsight.getName(), spelldemonsight);
		SpellDoom spelldoom = new SpellDoom();
		spell_registry.put(spelldoom.getName(), spelldoom);
		SpellDamagingForce spelldforce = new SpellDamagingForce();
		spell_registry.put(spelldforce.getName(), spelldforce);
		SpellBuffBreak spellbuffbreak = new SpellBuffBreak();
		spell_registry.put(spellbuffbreak.getName(), spellbuffbreak);
		SpellExpellLiving spellexpellliving = new SpellExpellLiving();
		spell_registry.put(spellexpellliving.getName(), spellexpellliving);
		SpellEmbraceTheShadows spellETS = new SpellEmbraceTheShadows();
		spell_registry.put(spellETS.getName(), spellETS);
		SpellConvertUndead spellconvertundead = new SpellConvertUndead();
		spell_registry.put(spellconvertundead.getName(), spellconvertundead);
		SpellUndeadEffigy spellundeadeffigy = new SpellUndeadEffigy();
		spell_registry.put(spellundeadeffigy.getName(), spellundeadeffigy);
		SpellUnholyRecall spellunholyrecall = new SpellUnholyRecall();
		spell_registry.put(spellunholyrecall.getName(), spellunholyrecall);
		SpellLightShift spellshift = new SpellLightShift();
		spell_registry.put(spellshift.getName(), spelllshift);
		SpellBeyondTheGrave spellBeyondTheGrave = new SpellBeyondTheGrave();
		spell_registry.put(spellBeyondTheGrave.getName(), spellBeyondTheGrave);
		
		//HOLY SPELLS
		SpellMinorHeal spellminorheal = new SpellMinorHeal();
		spell_registry.put(spellminorheal.getName(), spellminorheal);
		SpellWard spellflashward = new SpellWard();
		spell_registry.put(spellflashward.getName(), spellflashward);
		SpellSatiate spellsatiate = new SpellSatiate();
		spell_registry.put(spellsatiate.getName(), spellsatiate);
		SpellMagicMissile spellMM = new SpellMagicMissile();
		spell_registry.put(spellMM.getName(), spellMM);
		SpellAngelicFlight spellangelicflight = new SpellAngelicFlight();
		spell_registry.put(spellangelicflight.getName(), spellangelicflight);
		SpellRapport spellrapport = new SpellRapport();
		spell_registry.put(spellrapport.getName(), spellrapport);
		SpellLumina SPELLLUMINA = new SpellLumina();
		spell_registry.put(SPELLLUMINA.getName(), SPELLLUMINA);
		SpellHeal spellheal = new SpellHeal();
		spell_registry.put(spellheal.getName(), spellheal);
		SpellFullHeal spellfullheal = new SpellFullHeal();
		spell_registry.put(spellfullheal.getName(), spellfullheal);
		SpellBarrier spellbarrier = new SpellBarrier();
		spell_registry.put(spellbarrier.getName(), spellbarrier);
		SpellAccolades spellaccolades = new SpellAccolades();
		spell_registry.put(spellaccolades.getName(), spellaccolades);
		SpellAmeliorate spellameliorate = new SpellAmeliorate();
		spell_registry.put(spellameliorate.getName(), spellameliorate);
		SpellDisarm spelldisarm = new SpellDisarm();
		spell_registry.put(spelldisarm.getName(), spelldisarm);
		SpellEmitForce spellef = new SpellEmitForce();
		spell_registry.put(spellef.getName(), spellef);
		SpellBanishUndead spellbanishundead = new SpellBanishUndead();
		spell_registry.put(spellbanishundead.getName(), spellbanishundead);
		SpellConstitution spellconstitution = new SpellConstitution();
		spell_registry.put(spellconstitution.getName(), spellconstitution);
		SpellRegenerate spellregen = new SpellRegenerate();
		spell_registry.put(spellregen.getName(), spellregen);
		SpellExtricate spellextricate = new SpellExtricate();
		spell_registry.put(spellextricate.getName(), spellextricate);
		SpellFertility spellfertility = new SpellFertility();
		spell_registry.put(spellfertility.getName(), spellfertility);
		SpellJudgement spelljudgement = new SpellJudgement();
		spell_registry.put(spelljudgement.getName(), spelljudgement);
		SpellCurseBreak spellcursebreak = new SpellCurseBreak();
		spell_registry.put(spellcursebreak.getName(), spellcursebreak);
		SpellHolyRecall spellrecall = new SpellHolyRecall();
		spell_registry.put(spellrecall.getName(), spellrecall);
		SpellPacify spellpacify = new SpellPacify();
		spell_registry.put(spellpacify.getName(), spellpacify);
		SpellProtect spellprotect = new SpellProtect();
		spell_registry.put(spellprotect.getName(), spellprotect);
		SpellRadiance spellradiance = new SpellRadiance();
		spell_registry.put(spellradiance.getName(), spellradiance);
		SpellVialOfSupport spellVOS = new SpellVialOfSupport();
		spell_registry.put(spellVOS.getName(), spellVOS);
		SpellHealingHands spellhealinghands = new SpellHealingHands();
		spell_registry.put(spellhealinghands.getName(), spellhealinghands);
		SpellMagicBarrage spellmbarrage = new SpellMagicBarrage();
		spell_registry.put(spellmbarrage.getName(), spellmbarrage);
		
		//VOID SPELLS
		SpellMatterReversal spellmatterreversal = new SpellMatterReversal();
		spell_registry.put(spellmatterreversal.getName(), spellmatterreversal);
		SpellVoidContainment spellvoidcontainment = new SpellVoidContainment();
		spell_registry.put(spellvoidcontainment.getName(), spellvoidcontainment);
		SpellReconfigureMatter spellRM = new SpellReconfigureMatter();
		spell_registry.put(spellRM.getName(), spellRM);
		SpellAtomicBolt spellatomicbolt = new SpellAtomicBolt();
		spell_registry.put(spellatomicbolt.getName(), spellatomicbolt);
		SpellAntimatter spellantimatter = new SpellAntimatter();
		spell_registry.put(spellantimatter.getName(), spellantimatter);
		SpellNullPointEnchantment NPEnchanting = new SpellNullPointEnchantment();
		spell_registry.put(NPEnchanting.getName(), NPEnchanting);
		SpellGravitas spellgravitas = new SpellGravitas();
		spell_registry.put(spellgravitas.getName(), spellgravitas);
		SpellAntiGravity spellantigravity = new SpellAntiGravity();
		spell_registry.put(spellantigravity.getName(), spellantigravity);
		SpellCataclysm spellcataclysm = new SpellCataclysm();
		spell_registry.put(spellcataclysm.getName(), spellcataclysm);
		SpellCrush spellcrush = new SpellCrush();
		spell_registry.put(spellcrush.getName(), spellcrush);
		SpellBanish spellbanish = new SpellBanish();
		spell_registry.put(spellbanish.getName(), spellbanish);
		SpellGate spellgate = new SpellGate();
		spell_registry.put(spellgate.getName(), spellgate);
		SpellPolarize spellpolarize = new SpellPolarize();
		spell_registry.put(spellpolarize.getName(), spellpolarize);
		SpellOverrideClimate spelloverrideclimate = new SpellOverrideClimate();
		spell_registry.put(spelloverrideclimate.getName(), spelloverrideclimate);
		SpellPrimordialShift spellpshift = new SpellPrimordialShift();
		spell_registry.put(spellpshift.getName(), spellpshift);
		SpellPull spellpull = new SpellPull();
		spell_registry.put(spellpull.getName(), spellpull);
		SpellRecallAnchor spellrecallanchor = new SpellRecallAnchor();
		spell_registry.put(spellrecallanchor.getName(), spellrecallanchor);
		SpellTeleport spellteleport = new SpellTeleport();
		spell_registry.put(spellteleport.getName(), spellteleport);
		SpellVoidShift spellvoidshift = new SpellVoidShift();
		spell_registry.put(spellvoidshift.getName(), spellvoidshift);
		SpellVectorPlate spellvectorplate = new SpellVectorPlate();
		spell_registry.put(spellvectorplate.getName(), spellvectorplate);
		SpellRift spellrift = new SpellRift();
		spell_registry.put(spellrift.getName(), spellrift);
		
		//TOX SPELL
		SpellPoisonGas spellpgas = new SpellPoisonGas();
		spell_registry.put(spellpgas.getName(), spellpgas);
		SpellCure spellcure = new SpellCure();
		spell_registry.put(spellcure.getName(), spellcure);
		SpellToxicGas spelltgas = new SpellToxicGas();
		spell_registry.put(spelltgas.getName(), spelltgas);
		SpellToxBomb spelltoxbomb = new SpellToxBomb();
		spell_registry.put(spelltoxbomb.getName(), spelltoxbomb);
		SpellToxicWaste spelltwaste = new SpellToxicWaste();
		spell_registry.put(spelltwaste.getName(), spelltwaste);
		SpellPoisonCloud spellpoisoncloud = new SpellPoisonCloud();
		spell_registry.put(spellpoisoncloud.getName(), spellpoisoncloud);
		SpellPoisonDart spellpoisondart = new SpellPoisonDart();
		spell_registry.put(spellpoisondart.getName(), spellpoisondart);
		SpellNauseate spellnauseate = new SpellNauseate();
		spell_registry.put(spellnauseate.getName(), spellnauseate);
		
		//ETHER SPELLS
		SpellEquilibrium spellequilibrium = new SpellEquilibrium();
		spell_registry.put(spellequilibrium.getName(), spellequilibrium);
		
		//cantrips
		CantripEmbers cantripembers = new CantripEmbers();
		spell_registry.put(cantripembers.getName(), cantripembers);
		CantripSoak cantripsoak = new CantripSoak();
		spell_registry.put(cantripsoak.getName(), cantripsoak);
		CantripTerraform cantripterraform = new CantripTerraform();
		spell_registry.put(cantripterraform.getName(), cantripterraform);
		CantripGust cantripgust = new CantripGust();
		spell_registry.put(cantripgust.getName(), cantripgust);
		CantripBlink cantripblink = new CantripBlink();
		spell_registry.put(cantripblink.getName(), cantripblink);
		CantripLifeSteal cantripLS = new CantripLifeSteal();
		spell_registry.put(cantripLS.getName(), cantripLS);
		CantripHealOther cantripHO = new CantripHealOther();
		spell_registry.put(cantripHO.getName(), cantripHO);
		
		for (Spell spell : spell_registry.values()) 
		{
			if (!protoregistry.containsKey(spell.getSpellType())) 
			{
				protoregistry.put(spell.getSpellType(), new ArrayList<>());
			}
			protoregistry.get(spell.getSpellType()).add(spell);
		}
	}
	public enum spelltype
	{
		FIRE("Fire", null, Set.of(
				EntityType.MAGMA_CUBE, 
				EntityType.PIGLIN,
				EntityType.BLAZE,
				EntityType.HUSK,
				EntityType.CREEPER,
				EntityType.ENDER_DRAGON,
				EntityType.PIGLIN_BRUTE,
				EntityType.STRIDER,
				EntityType.ZOGLIN,
				EntityType.SNIFFER,
				EntityType.ZOMBIFIED_PIGLIN)),
		WATER("Water", null, Set.of(
				EntityType.GUARDIAN, 
				EntityType.DOLPHIN,
				EntityType.ELDER_GUARDIAN,
				EntityType.PUFFERFISH,
				EntityType.DROWNED,
				EntityType.SQUID,
				EntityType.GLOW_SQUID,
				EntityType.AXOLOTL,
				EntityType.TURTLE)),
		GEO("Geo", null, Set.of(
				EntityType.IRON_GOLEM,
				EntityType.HUSK,
				EntityType.SNOWMAN,
				EntityType.CAVE_SPIDER,
				EntityType.SHULKER,
				EntityType.TURTLE,
				EntityType.RAVAGER,
				EntityType.FROG)),
		STORM("Storm", null, Set.of(
				EntityType.PHANTOM, 
				EntityType.ALLAY, 
				EntityType.VEX, 
				EntityType.ENDER_DRAGON, 
				EntityType.BAT,
				EntityType.VINDICATOR,
				EntityType.RAVAGER,
				EntityType.GHAST,
				EntityType.BEE,
				EntityType.PARROT)),
		HOLY("Holy", null, Set.of(
				EntityType.COW, 
				EntityType.SHEEP, 
				EntityType.PIG,
				EntityType.ALLAY,
				EntityType.FOX,
				EntityType.CAMEL,
				EntityType.DONKEY,
				EntityType.HORSE,
				EntityType.GOAT,
				EntityType.AXOLOTL,
				EntityType.GLOW_SQUID,
				EntityType.TURTLE,
				EntityType.EVOKER,
				EntityType.VEX,
				EntityType.RABBIT)),
		UNHOLY("Unholy", null, Set.of(
				EntityType.SKELETON, 
				EntityType.ZOMBIE,
				EntityType.WITHER,
				EntityType.WARDEN,
				EntityType.VEX,
				EntityType.PILLAGER,
				EntityType.ZOMBIE_HORSE,
				EntityType.ZOMBIE_VILLAGER,
				EntityType.ZOMBIFIED_PIGLIN,
				EntityType.CREEPER,
				EntityType.SPIDER,
				EntityType.DROWNED,
				EntityType.EVOKER,
				EntityType.VINDICATOR,
				EntityType.GHAST,
				EntityType.GIANT,
				EntityType.SKELETON_HORSE,
				EntityType.WITHER_SKELETON,
				EntityType.STRAY)),
		VOID("Void", null, Set.of(
				EntityType.ILLUSIONER, 
				EntityType.ENDER_DRAGON, 
				EntityType.ENDERMAN, 
				EntityType.ENDERMITE, 
				EntityType.SHULKER)),
		ETHER("Ether", null, Set.of(
				EntityType.ENDER_DRAGON, 
				EntityType.ENDERMAN, 
				EntityType.ENDERMITE, 
				EntityType.SHULKER,
				EntityType.WARDEN,
				EntityType.WITHER)),
		TOX("Tox", null, Set.of(
				EntityType.MAGMA_CUBE, 
				EntityType.SLIME, 
				EntityType.PUFFERFISH,
				EntityType.SPIDER,
				EntityType.CAVE_SPIDER,
				EntityType.BEE,
				EntityType.BAT));
		
		public String name;
		public ItemStack grimoire;
		public Set<EntityType> carriers;
		spelltype(String name, ItemStack grimoire, Set<EntityType> carriers)
		{
			this.grimoire = grimoire;
			this.name = name;
			this.carriers = carriers;
		}
		
		public void setGrimoire(ItemStack stack) 
		{
			this.grimoire = stack;
		}
	}
	public static ItemStack generateGrimoire(spelltype type)
	{
		ItemStack stack = new ItemStack(Material.BOOK);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("Tattered " + type.name + " Grimoire");
		stack.setItemMeta(meta);
		DataUtils.set("grimoire", DType.STRING, type.toString(), stack);
		return stack;
	}
}
