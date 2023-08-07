package com.perceus.lumina;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.perceus.lumina.wand.MagicWand;
import com.perceus.lumina.wand.Wand;

public class LuminaCommand implements CommandExecutor, TabCompleter
{
	
	public LuminaCommand() 
	{
		Bukkit.getPluginCommand("wand").setTabCompleter(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args)
	{
		if (!(sender instanceof Player)) 
		{
			return false;
		}
		Player player = (Player) sender;
		if (!sender.isOp()) 
		{
			sender.sendMessage("[!] You do not have permission to use this command.");
			return false;
		}
		if (args.length == 0) 
		{
			ItemStack wandstack = new MagicWand().getAsItemStack();
			wandstack.setAmount(1);
			player.getInventory().addItem(wandstack);
			return true;
		}
		
		if (args[0].equals("setdurability")) 
		{
			if (!Wand.isWand(player.getInventory().getItemInMainHand())) 
			{
				player.sendMessage("You are not holding a Magic Wand. Please try again.");
				return false;
			}
			
			Wand wand = new Wand(player.getInventory().getItemInMainHand());
			wand.addMana(Integer.MAX_VALUE);
			player.getInventory().setItemInMainHand(wand.getAsItemStack());
			return true;
		}
		
		if (args[0].equals("setspell") && args.length == 3) 
		{
			int slot;
			
			try 
			{
				slot = Integer.parseInt(args[2]);	
				if (slot < 1 || slot > 5) 
				{
					player.sendMessage("You did not input a valid integer. Please input an integer between 1 and 5 inclusively.");
					return true;
				}
			}
			catch(Exception e ) 
			{
				e.printStackTrace();
				return false;
			}
			
			if (!Wand.isWand(player.getInventory().getItemInMainHand())) 
			{
				player.sendMessage("You are not holding a Magic Wand. Please try again.");
				return true;
			}
			
			if (SpellControlSystem.spell_registry.containsKey(args[1])) 
			{
				
				Spell spell = SpellControlSystem.spell_registry.get(args[1]);
				Wand wand = new Wand(player.getInventory().getItemInMainHand());
				
				wand.setSpell(spell, slot - 1);				
				player.getInventory().setItemInMainHand(wand.getAsItemStack());
				
				return true;
			}
		}
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args)
	{

		return switch (args.length) 
		{
			case 0 -> List.of("setspell", "setdurability");
			case 1 -> List.of("setspell", "setdurability");
			case 2 -> {
				yield switch(args[0]) 
				{
				case "setspell" -> new ArrayList<>(SpellControlSystem.spell_registry.keySet());
				case "setdurability" -> List.of();
				default -> List.of();
				};
			}
			
			case 3 -> List.of("slot");
			default -> List.of();
		};
	}
}
