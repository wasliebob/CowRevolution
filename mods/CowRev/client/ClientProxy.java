package mods.CowRev.client;

import mods.CowRev.CommonProxy;
import mods.CowRev.cows.BlazeCow;
import mods.CowRev.cows.CreeperCow;
import mods.CowRev.cows.EnderCow;
import mods.CowRev.models.ModelCow2;
import mods.CowRev.particle.ParticleRegistry;
import mods.CowRev.renders.RenderCow2;
import mods.CowRev.renders.RenderCow3;
import mods.CowRev.renders.RenderCow4;
import net.minecraft.client.particle.EntityHeartFX;
import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.client.particle.EntitySmokeFX;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ClientProxy extends CommonProxy {
        @Override
        public void registerRenderThings() {
        	
        	//Cows
            MinecraftForgeClient.preloadTexture(BLUECOW_PNG);
            MinecraftForgeClient.preloadTexture(GREENCOW_PNG);
            MinecraftForgeClient.preloadTexture(WHITECOW_PNG);
            MinecraftForgeClient.preloadTexture(AGENTCOW_PNG);
            MinecraftForgeClient.preloadTexture(CREEPERCOW_PNG);
            MinecraftForgeClient.preloadTexture(ENDERCOW_PNG);
            MinecraftForgeClient.preloadTexture(MILKACOW_PNG);
            MinecraftForgeClient.preloadTexture(ZOMBIECOW_PNG);
            MinecraftForgeClient.preloadTexture(BLAZECOW_PNG);
            
            //Leather
            MinecraftForgeClient.preloadTexture(BLUELEATHER_PNG);
            MinecraftForgeClient.preloadTexture(GREENLEATHER_PNG);
            MinecraftForgeClient.preloadTexture(WHITELEATHER_PNG);
            
            //Special Leather
            MinecraftForgeClient.preloadTexture(SECRETLEATHER_PNG);
            MinecraftForgeClient.preloadTexture(ENDERLEATHER_PNG);
            
            //Food
            MinecraftForgeClient.preloadTexture(GREENBEEF_PNG);
            MinecraftForgeClient.preloadTexture(BLUEBEEF_PNG);
            MinecraftForgeClient.preloadTexture(MILKA_PNG);
            MinecraftForgeClient.preloadTexture(WHITEBEEF_PNG);

            //Cheat Sword
            MinecraftForgeClient.preloadTexture(CHEAT_PNG);

            //Swords
            MinecraftForgeClient.preloadTexture(BASIC_PNG);
            MinecraftForgeClient.preloadTexture(ENDERSWORD_PNG);

            //Parts
            MinecraftForgeClient.preloadTexture(BLADE_PNG);
            MinecraftForgeClient.preloadTexture(HANDLE_PNG);
            MinecraftForgeClient.preloadTexture(BINDING_PNG);
            
            //Guns
            MinecraftForgeClient.preloadTexture(GUN_PNG);
            MinecraftForgeClient.preloadTexture(BGUN_PNG);
            MinecraftForgeClient.preloadTexture(CGUN_PNG);

            //Lamp
            MinecraftForgeClient.preloadTexture(LAMP_PNG);
            
        		RenderingRegistry.registerEntityRenderingHandler(BlazeCow.class, new RenderCow2(new ModelCow2(), 0.3F));
            	RenderingRegistry.registerEntityRenderingHandler(CreeperCow.class, new RenderCow3(new ModelCow2(), 0.3F));
            	RenderingRegistry.registerEntityRenderingHandler(EnderCow.class, new RenderCow4(new ModelCow2(), 0.3F));       

        }
        @Override
    	public void registerParticles()
    	{
    		ParticleRegistry.registerParticle("smoke", EntitySmokeFX.class);
    		ParticleRegistry.registerParticle("portal", EntityPortalFX.class);
    		ParticleRegistry.registerParticle("heart", EntityHeartFX.class);	

    	}
}