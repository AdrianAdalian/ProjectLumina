package com.perceus.lumina.utils;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class SpellParticle
{
	
	public static <T> void drawLine(Location source, Location target, int interval, Particle p, T data) 
	{
		if (!source.getWorld().equals(target.getWorld())) 
		{
			return;
		}
		
		World w = source.getWorld();
		
		Vector v1 = source.toVector();
		Vector v2 = target.toVector();
		Vector vPrime = v2.subtract(v1).normalize().multiply(interval);
		
		double d1 = source.distance(target);
		double d2 = 0;
		
		for (;d2 < d1; v1.add(vPrime)) 
		{
			w.spawnParticle(p, v1.getX(), v1.getY(), v1.getZ(), 0, 0, 0, 0, data);
			d2 += interval;
		}
	}
	
	public static <T> void drawCircle(Location location, double radius, double density, Particle particle, T data)
    {
        World world = location.getWorld();

        double increment = (2 * Math.PI) / density;
        ArrayList<Location> locations = new ArrayList<Location>();

        for (int i = 0; i < density; i++)
        {
            double angle = i * increment;
            double x = location.getX() + (radius * Math.cos(angle));
            double z = location.getZ() + (radius * Math.sin(angle));

            locations.add(new Location(world, x, location.getY(), z));
        }

        locations.forEach(loc -> {
            world.spawnParticle(particle, loc.setDirection(new Vector(0, 0, 0)), 0, 0, 0, 0, data);
        });
    }
	
	public static <T> void drawCylinder(Location location, double radius, int density, int stacks, double distance, Particle particle, T data)
    {
        Location buffer = location.clone();

        for (int i = 0; i < stacks; i++)
        {
            drawCircle(buffer, radius, density, particle, data);
            buffer = buffer.add(0, distance, 0);
        }
    }
}
