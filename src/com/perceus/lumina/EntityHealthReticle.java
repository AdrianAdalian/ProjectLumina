package com.perceus.lumina;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityHealthReticle implements Listener
{
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e)
	{
		
//		new BukkitRunnable()
//		{
//			@Override
//			public void run() 
//			{
//				if (!e.getEntity().getPassengers().isEmpty() && e.getEntity().getPassengers().get(0) instanceof ArmorStand) 
//				{
//					ArmorStand s = (ArmorStand) e.getEntity().getPassengers().get(0);
//					s.setCustomName(((LivingEntity) e.getEntity()).getHealth() + " / " + ((LivingEntity) e.getEntity()).getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
//				}
//			}
//		}.runTaskTimer(Lumina.instance, 0, 20);
//		
//		if (e.getEntity() instanceof ArmorStand) 
//		{
//			return;
//		}
//		
//		if (e.getDamager() instanceof Player) 
//		{	
//			ArmorStand s = (ArmorStand) e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARMOR_STAND);
//			s.setInvisible(true);
//			s.setCustomName(((LivingEntity) e.getEntity()).getHealth() + " / " + ((LivingEntity) e.getEntity()).getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
//			e.getEntity().addPassenger(s);
//			s.setCustomNameVisible(true);
//			if (((LivingEntity) e.getEntity()).getHealth() - e.getDamage() <= 0) 
//			{
//				s.remove();
//			}
//		}
	}
}
