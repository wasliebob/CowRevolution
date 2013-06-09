package mods.CowRev;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityHeartFX;
import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.client.particle.EntitySmokeFX;
import mods.CowRev.cows.BlazeCow;
import mods.CowRev.cows.CreeperCow;
import mods.CowRev.cows.EnderCow;
import mods.CowRev.models.ModelCow2;
import mods.CowRev.particle.ParticleRegistry;
import mods.CowRev.renders.RenderCow2;
import mods.CowRev.renders.RenderCow3;
import mods.CowRev.renders.RenderCow4;
import cpw.mods.fml.client.registry.RenderingRegistry;


public class CommonProxy {
	
	//Cows
    public static String BLUECOW_PNG = "/mods/CowRev/textures/mobs/bluecow.png";
    public static String GREENCOW_PNG = "/mods/CowRev/textures/mobs/greencow.png";
    public static String WHITECOW_PNG = "/mods/CowRev/textures/mobs/whitecow.png";
    public static String AGENTCOW_PNG = "/mods/CowRev/textures/mobs/agentcow.png";
    public static String CREEPERCOW_PNG = "/mods/CowRev/textures/mobs/creepercow.png";
    public static String ENDERCOW_PNG = "/mods/CowRev/textures/mobs/endercow.png";
    public static String MILKACOW_PNG = "/mods/CowRev/textures/mobs/milkacow.png";
    public static String ZOMBIECOW_PNG = "/mods/CowRev/textures/mobs/zombiecow.png";
    public static String BLAZECOW_PNG = "/mods/CowRev/textures/mobs/blazecow.png";

    //Leathers
    public static String BLUELEATHER_PNG = "/mods/CowRev/textures/items/blueleather.png";
    public static String WHITELEATHER_PNG = "/mods/CowRev/textures/items/whiteleather.png";
    public static String GREENLEATHER_PNG = "/mods/CowRev/textures/items/greenleather.png";
    public static String SECRETLEATHER_PNG = "/mods/CowRev/textures/items/secretleather.png";
    public static String ENDERLEATHER_PNG = "/mods/CowRev/textures/items/enderleather.png";

    //Food
    public static String GREENBEEF_PNG = "/mods/CowRev/textures/items/greenbeef.png";
    public static String BLUEBEEF_PNG = "/mods/CowRev/textures/items/bluebeef.png";
    public static String WHITEBEEF_PNG = "/mods/CowRev/textures/items/whitebeef.png";
    public static String MILKA_PNG = "/mods/CowRev/textures/items/milka.png";

    //Cheat Sword
    public static String CHEAT_PNG = "/mods/CowRev/textures/items/cheat.png";

    //Sword parts
    public static String BINDING_PNG = "/mods/CowRev/textures/items/binding.png";
    public static String BLADE_PNG = "/mods/CowRev/textures/items/blade.png";
    public static String HANDLE_PNG = "/mods/CowRev/textures/items/handle.png";

    //Swords
    public static String BASIC_PNG = "/mods/CowRev/textures/items/basic.png";
    public static String ENDERSWORD_PNG = "/mods/CowRev/textures/items/endersword.png";

    //Guns
    public static String GUN_PNG = "/mods/CowRev/textures/items/gun.png";
    public static String BGUN_PNG = "/mods/CowRev/textures/items/bgun.png";
    public static String CGUN_PNG = "/mods/CowRev/textures/items/cgun.png";

    //Lamp
    public static String LAMP_PNG = "/mods/CowRev/textures/blocks/lampwhite.png";

    public void registerRenderThings() {
    	RenderingRegistry.registerEntityRenderingHandler(BlazeCow.class, new RenderCow2(new ModelCow2(), 0.3F));
    	RenderingRegistry.registerEntityRenderingHandler(CreeperCow.class, new RenderCow3(new ModelCow2(), 0.3F));
    	RenderingRegistry.registerEntityRenderingHandler(EnderCow.class, new RenderCow4(new ModelCow2(), 0.3F));
    }
    
	public void registerParticles()
	{
		ParticleRegistry.registerParticle("smoke", EntitySmokeFX.class);
		ParticleRegistry.registerParticle("portal", EntityPortalFX.class);	
		ParticleRegistry.registerParticle("heart", EntityHeartFX.class);	
	}
    
}