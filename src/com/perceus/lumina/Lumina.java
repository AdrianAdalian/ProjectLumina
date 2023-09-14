package com.perceus.lumina;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.perceus.lumina.listeners.EntityDeathListener;
import com.perceus.lumina.listeners.FireRobeListener;
import com.perceus.lumina.listeners.GeoRobeListener;
import com.perceus.lumina.listeners.HolyRobeListener;
import com.perceus.lumina.listeners.LuminaOnJoinOnQuitEvent;
import com.perceus.lumina.listeners.StormRobeListener;
import com.perceus.lumina.listeners.UnholyRobeListener;
import com.perceus.lumina.listeners.VoidRobeListener;
import com.perceus.lumina.listeners.WandHoldEvent;
import com.perceus.lumina.listeners.WaterRobeListener;
import com.perceus.lumina.robes.recipes.FireBoots_Recipe;
import com.perceus.lumina.robes.recipes.FireHat_Recipe;
import com.perceus.lumina.robes.recipes.FirePants_Recipe;
import com.perceus.lumina.robes.recipes.FireTunic_Recipe;
import com.perceus.lumina.robes.recipes.GeoBoots_Recipe;
import com.perceus.lumina.robes.recipes.GeoHat_Recipe;
import com.perceus.lumina.robes.recipes.GeoPants_Recipe;
import com.perceus.lumina.robes.recipes.GeoTunic_Recipe;
import com.perceus.lumina.robes.recipes.HolyBoots_Recipe;
import com.perceus.lumina.robes.recipes.HolyHat_Recipe;
import com.perceus.lumina.robes.recipes.HolyPants_Recipe;
import com.perceus.lumina.robes.recipes.HolyTunic_Recipe;
import com.perceus.lumina.robes.recipes.StormBoots_Recipe;
import com.perceus.lumina.robes.recipes.StormHat_Recipe;
import com.perceus.lumina.robes.recipes.StormPants_Recipe;
import com.perceus.lumina.robes.recipes.StormTunic_Recipe;
import com.perceus.lumina.robes.recipes.UnholyBoots_Recipe;
import com.perceus.lumina.robes.recipes.UnholyHat_Recipe;
import com.perceus.lumina.robes.recipes.UnholyPants_Recipe;
import com.perceus.lumina.robes.recipes.UnholyTunic_Recipe;
import com.perceus.lumina.robes.recipes.VoidBoots_Recipe;
import com.perceus.lumina.robes.recipes.VoidHat_Recipe;
import com.perceus.lumina.robes.recipes.VoidPants_Recipe;
import com.perceus.lumina.robes.recipes.VoidTunic_Recipe;
import com.perceus.lumina.robes.recipes.WaterBoots_Recipe;
import com.perceus.lumina.robes.recipes.WaterHat_Recipe;
import com.perceus.lumina.robes.recipes.WaterPants_Recipe;
import com.perceus.lumina.robes.recipes.WaterTunic_Recipe;
import com.perceus.lumina.utils.PrintUtils;
import com.perceus.lumina.wand.MagicWand_Recipe;

public class Lumina extends JavaPlugin
{
	public static Lumina instance;
	
	@Override
	public void onEnable() 
	{
		this.getCommand("wand").setExecutor(new LuminaCommand());
		this.getCommand("givespell").setExecutor(new SpellCommand());
		this.getCommand("kit").setExecutor(new SpellKitCommand());
		Bukkit.getPluginManager().registerEvents(new SpellControlSystem(), this);
		Bukkit.getPluginManager().registerEvents(new LuminaGui(), this);
		Bukkit.getPluginManager().registerEvents(new WandHoldEvent(), this);
		Bukkit.getPluginManager().registerEvents(new EntityDeathListener(), this);
		Bukkit.getPluginManager().registerEvents(new HolyRobeListener(), this);
		Bukkit.getPluginManager().registerEvents(new StormRobeListener(), this);
		Bukkit.getPluginManager().registerEvents(new FireRobeListener(), this);
		Bukkit.getPluginManager().registerEvents(new VoidRobeListener(), this);
		Bukkit.getPluginManager().registerEvents(new WaterRobeListener(), this);
		Bukkit.getPluginManager().registerEvents(new GeoRobeListener(), this);
		Bukkit.getPluginManager().registerEvents(new UnholyRobeListener(), this);
		Bukkit.getPluginManager().registerEvents(new LuminaOnJoinOnQuitEvent(), this);
		instance = this;
		
		MagicWand_Recipe.Init();
		MagicWand_Recipe.RegisterRecipe();
		
		//Robe Recipes
		HolyTunic_Recipe.Init();
		HolyTunic_Recipe.Register();
		HolyBoots_Recipe.Init();
		HolyBoots_Recipe.Register();
		HolyHat_Recipe.Init();
		HolyHat_Recipe.Register();
		HolyPants_Recipe.Init();
		HolyPants_Recipe.Register();
		
		StormHat_Recipe.Init();
		StormHat_Recipe.Register();
		StormTunic_Recipe.Init();
		StormTunic_Recipe.Register();
		StormPants_Recipe.Init();
		StormPants_Recipe.Register();
		StormBoots_Recipe.Init();
		StormBoots_Recipe.Register();
		
		FireHat_Recipe.Init();
		FireHat_Recipe.Register();
		FireTunic_Recipe.Init();
		FireTunic_Recipe.Register();
		FirePants_Recipe.Init();
		FirePants_Recipe.Register();
		FireBoots_Recipe.Init();
		FireBoots_Recipe.Register();
		
		VoidHat_Recipe.Init();
		VoidHat_Recipe.Register();
		VoidTunic_Recipe.Init();
		VoidTunic_Recipe.Register();
		VoidPants_Recipe.Init();
		VoidPants_Recipe.Register();
		VoidBoots_Recipe.Init();
		VoidBoots_Recipe.Register();
		
		WaterHat_Recipe.Init();
		WaterHat_Recipe.Register();
		WaterTunic_Recipe.Init();
		WaterTunic_Recipe.Register();
		WaterPants_Recipe.Init();
		WaterPants_Recipe.Register();
		WaterBoots_Recipe.Init();
		WaterBoots_Recipe.Register();
		
		GeoHat_Recipe.Init();
		GeoHat_Recipe.Register();
		GeoTunic_Recipe.Init();
		GeoTunic_Recipe.Register();
		GeoPants_Recipe.Init();
		GeoPants_Recipe.Register();
		GeoBoots_Recipe.Init();
		GeoBoots_Recipe.Register();
		
		UnholyHat_Recipe.Init();
		UnholyHat_Recipe.Register();
		UnholyTunic_Recipe.Init();
		UnholyTunic_Recipe.Register();
		UnholyPants_Recipe.Init();
		UnholyPants_Recipe.Register();
		UnholyBoots_Recipe.Init();
		UnholyBoots_Recipe.Register();
		
		SpellControlSystem.init();
		PrintUtils.Print("&aLumina, ONLINE.");
		PrintUtils.Print("&c<&l&4" + SpellControlSystem.spell_registry.size() + "&r&c SPELLS REGISTERED>");
	}
	
	@Override
	public void onDisable() 
	{
		
	}
	
}
