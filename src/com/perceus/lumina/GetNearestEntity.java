package com.perceus.lumina;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.RayTraceResult;

public class GetNearestEntity
{
//	public static Entity getNearestEntityInSight2(Player player, int range) 
//	{
//		
//	    ArrayList<Entity> entities = (ArrayList<Entity>) player.getNearbyEntities(range, range, range);
//	    ArrayList<Block> sightBlock = null;
//	    try 
//	    {
//	        sightBlock = (ArrayList<Block>) player.getLineOfSight(null, range);
//	    } catch (IllegalStateException error) 
//	    {
//	        return null;
//	    }
//	     
//	    ArrayList<Location> sight = new ArrayList<Location>();
//	    for (int i = 0;i<sightBlock.size();i++)
//	        sight.add(sightBlock.get(i).getLocation());
//	    for (int i = 0;i<sight.size();i++) {
//	        for (int k = 0;k<entities.size();k++) {
//	            if (entities.get(k) instanceof LivingEntity && !(entities.get(k) instanceof ArmorStand)) {
//	                if (Math.abs(entities.get(k).getLocation().getX()-sight.get(i).getX())<1.3) {
//	                    if (Math.abs(entities.get(k).getLocation().getY()-sight.get(i).getY())<1.5) {
//	                        if (Math.abs(entities.get(k).getLocation().getZ()-sight.get(i).getZ())<1.3) {
//	                                
//	                        	return entities.get(k);
//	                        	
//	                        }
//	                    }
//	                }
//	            }
//	        }
//	    }
//	    	return null; // Return null if no entity was found
//	}
	
	/**
	 * Gets the entity the player is looking at
	 * @param p Player
	 * @return Entity player is looking at. If player is not looking at an entity it will return null
	 */
	public static Entity getNearestEntityInSight(Player p, int range)
	{
	    RayTraceResult result = p.getLocation().getWorld().rayTraceEntities(p.getEyeLocation().add(p.getEyeLocation().getDirection().normalize().multiply(2)),p.getEyeLocation().getDirection(),range);
	    
	    if(result == null) { return null; }
	    if(result.getHitEntity() == null) { return null; }
	    return result.getHitEntity();
	}
	
}
