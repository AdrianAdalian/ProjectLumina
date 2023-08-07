package com.perceus.lumina;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.perceus.lumina.wand.MagicWand_Recipe;

public class Lumina extends JavaPlugin
{
	public static Lumina instance;
	
	@Override
	public void onEnable() 
	{
		this.getCommand("wand").setExecutor(new LuminaCommand());
		this.getCommand("givespell").setExecutor(new SpellCommand());
		Bukkit.getPluginManager().registerEvents(new SpellControlSystem(), this);
		Bukkit.getPluginManager().registerEvents(new LuminaGui(), this);
		Bukkit.getPluginManager().registerEvents(new WandHoldEvent(), this);
		Bukkit.getPluginManager().registerEvents(new EntityDeathListener(), this);
		instance = this;
		
		MagicWand_Recipe.Init();
		MagicWand_Recipe.RegisterRecipe();
		SpellControlSystem.init();
		PrintUtils.Print("&cYou're a wizard, Harry!");
		PrintUtils.Print("&c<&l&4" + SpellControlSystem.spell_registry.size() + "&r&c SPELLS REGISTERED>");
	}
	
	@Override
	public void onDisable() 
	{
		
	}
	
}
