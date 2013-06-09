package mods.CowRev;

import java.util.ArrayList;

import mods.CowRev.cows.AgentCow;
import mods.CowRev.cows.BlazeCow;
import mods.CowRev.cows.BlueCow;
import mods.CowRev.cows.CreeperCow;
import mods.CowRev.cows.EnderCow;
import mods.CowRev.cows.GreenCow;
import mods.CowRev.cows.MilkaCow;
import mods.CowRev.cows.WhiteCow;
import mods.CowRev.cows.ZombieCow;
import mods.CowRev.food.BlueBeef;
import mods.CowRev.food.GreenBeef;
import mods.CowRev.food.WhiteBeef;
import mods.CowRev.guns.BasicGun;
import mods.CowRev.guns.BoomGun;
import mods.CowRev.items.BlueLeather;
import mods.CowRev.items.EnderLeather;
import mods.CowRev.items.GreenLeather;
import mods.CowRev.items.SecretLeather;
import mods.CowRev.items.WhiteLeather;
import mods.CowRev.models.ModelCow2;
import mods.CowRev.renders.RenderCow2;
import mods.CowRev.renders.RenderCow3;
import mods.CowRev.renders.RenderCow4;
import mods.CowRev.weaponparts.Binding;
import mods.CowRev.weaponparts.Blade;
import mods.CowRev.weaponparts.Handle;
import mods.CowRev.weapons.Basic;
import mods.CowRev.weapons.CheatSword;
import mods.CowRev.weapons.EnderSword;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="CowRev", name="Cow Revolution", version="1.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class CowRev {

        // The instance of your mod that Forge uses.
        @Instance("CowRev")
        
        public static CowRev instance;
        
        //Sword
    	public final static Item cheat = new CheatSword(7941, EnumToolMaterial.EMERALD, "Cheat Sword");

    	//Item
    	public final static Item blueleather = new BlueLeather(6941);
    	public final static Item enderleather = new EnderLeather(6942);
    	public final static Item greenleather = new GreenLeather(6943);
    	public final static Item secretleather = new SecretLeather(6945);
    	public final static Item whiteleather = new WhiteLeather(6946);

    	//Food
    	public final static Item bluebeef = new BlueBeef(6847, 2, 4F, false).setFull3D();    	
    	public final static Item greenbeef = new GreenBeef(6848, 2, 4F, false).setFull3D();    	
    	//public final static Item milka = new Milka(6849, 2, 4F, false).setFull3D();    	
    	public final static Item whitebeef = new WhiteBeef(6849, 2, 4F, false).setFull3D();    	


    	//Swords
    	public final static Item binding = new Binding(6850);
    	public final static Item blade = new Blade(6851);
    	public final static Item handle = new Handle(6852);

    	//Swords
    	public final static Item basic = new Basic(7852);
    	public final static Item endersword = new EnderSword(7853, EnumToolMaterial.IRON, "Ender Sword");

    	//Guns
    	public final static Item gun = new BasicGun(8850, EnumToolMaterial.IRON, "Gun");
    	public final static Item boom = new BoomGun(8851, EnumToolMaterial.IRON, "ExplosiveGun");
    	//public final static Item cowgun = new CowGun(8852, EnumToolMaterial.IRON, "CowGun");

    	//Amulet

        @SidedProxy(clientSide="mods.CowRev.client.ClientProxy", serverSide="mods.CowRev.CommonProxy")
        public static CommonProxy proxy;
        

        //Creative Tab
    	//public static final CreativeTabs tabCustom = new CreativeTabCustom(12,
    		//	"CowRev");
    	
        static int startEntityId = 300;
        public static int modelID;	
        @PreInit
        public void preInit(FMLPreInitializationEvent event) {

        }
        
   
        @Init
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderThings();
                proxy.registerParticles();
        		
                //Leather
                GameRegistry.registerItem(blueleather, "BlueLeather");
                LanguageRegistry.addName(blueleather, "Blue Leather");
                
                GameRegistry.registerItem(enderleather, "EnderLeather");
                LanguageRegistry.addName(enderleather, "Ender Leather");
                
                GameRegistry.registerItem(greenleather, "GreenLeather");
                LanguageRegistry.addName(greenleather, "Green Leather");
                
                GameRegistry.registerItem(secretleather, "SecretLeather");
                LanguageRegistry.addName(secretleather, "Secret Leather");
                
                GameRegistry.registerItem(whiteleather, "WhiteLeather");
                LanguageRegistry.addName(whiteleather, "White Leather");
                
                //Beef
                GameRegistry.registerItem(bluebeef, "BlueBeef");
                LanguageRegistry.addName(bluebeef, "Blue Beef");
                
                GameRegistry.registerItem(greenbeef, "GreenBeef");
                LanguageRegistry.addName(greenbeef, "Green Beef");      
                
                GameRegistry.registerItem(whitebeef, "WhiteBeef");
                LanguageRegistry.addName(whitebeef, "White Beef");    

               // GameRegistry.registerItem(milka, "Milka");
               // LanguageRegistry.addName(milka, "Milka");
                
                GameRegistry.registerItem(binding, "Binding");
                LanguageRegistry.addName(binding, "Binding");
                        		
                GameRegistry.registerItem(blade, "Blade");
                LanguageRegistry.addName(blade, "Blade");
                
                GameRegistry.registerItem(handle, "Handle");
                LanguageRegistry.addName(handle, "Handle");
                
                
                //Swords
                GameRegistry.registerItem(endersword, "Ender Sword");
                LanguageRegistry.addName(endersword, "Ender Sword"); 
                
                //Guns
                GameRegistry.registerItem(gun, "Gun");
                LanguageRegistry.addName(gun, "Gun"); 
                
                GameRegistry.registerItem(boom, "ExplosiveGun");
                LanguageRegistry.addName(boom, "Explosive Gun"); 
                
                //GameRegistry.registerItem(cowgun, "CowGun");
                //LanguageRegistry.addName(cowgun, "Cow Gun"); 
                
                //Creative Tab
        		//LanguageRegistry.instance().addStringLocalization("itemGroup.CowRev",
        			//	"Cow Revolution");
        		
            
                
        		GameRegistry.addRecipe(new ItemStack(basic), 
        				"  B", 
        				" T ", 
        				"H  ",
        				'H', handle,
        				'T', binding,
        				'B', blade);
                
        		GameRegistry.addRecipe(new ItemStack(gun), 
        				"   ", 
        				"SII", 
        				"SA ",
        				'A', Item.stick,
        				'I', Item.ingotIron,
        				'S', secretleather);
                
        		GameRegistry.addShapelessRecipe(new ItemStack(endersword), basic, enderleather, enderleather, enderleather, enderleather, enderleather, enderleather, enderleather, enderleather);
        		GameRegistry.addShapelessRecipe(new ItemStack(handle), Item.stick, Item.stick);
        		GameRegistry.addShapelessRecipe(new ItemStack(binding), Item.ingotIron, Item.leather, Item.leather);
        		GameRegistry.addShapelessRecipe(new ItemStack(blade), Item.ingotIron, Item.ingotIron);
        		GameRegistry.addShapelessRecipe(new ItemStack(boom), gun, Item.gunpowder, Item.gunpowder, Item.gunpowder, Item.gunpowder, Item.gunpowder, Item.gunpowder, Item.gunpowder, Item.gunpowder);
        		//GameRegistry.addShapelessRecipe(new ItemStack(cowgun), gun, Item.beefRaw, Item.gunpowder, Item.gunpowder, Item.gunpowder, Item.gunpowder, Item.gunpowder, Item.gunpowder, Item.gunpowder);

        		//Agent Cow
                EntityRegistry.registerModEntity(AgentCow.class, "AgentCow", 1,
        				this, 70, 3, true);
        		EntityRegistry.addSpawn(AgentCow.class, 1, 2, 4, EnumCreatureType.monster,
        						BiomeGenBase.beach, BiomeGenBase.extremeHills,
        						BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest,
        						BiomeGenBase.forestHills, BiomeGenBase.jungle,
        						BiomeGenBase.jungleHills, BiomeGenBase.mushroomIsland,
        						BiomeGenBase.mushroomIslandShore, BiomeGenBase.ocean,
        						BiomeGenBase.plains, BiomeGenBase.river,
        						BiomeGenBase.swampland);
        		
        		//Blue Cow
                EntityRegistry.registerModEntity(BlueCow.class, "BlueCow", 2,
        				this, 70, 3, true);
        		EntityRegistry.addSpawn(BlueCow.class, 3, 2, 4, EnumCreatureType.monster,
        						BiomeGenBase.beach, BiomeGenBase.extremeHills,
        						BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest,
        						BiomeGenBase.forestHills, BiomeGenBase.jungle,
        						BiomeGenBase.jungleHills, BiomeGenBase.mushroomIsland,
        						BiomeGenBase.mushroomIslandShore, BiomeGenBase.ocean,
        						BiomeGenBase.plains, BiomeGenBase.river,
        						BiomeGenBase.swampland);
        		
        		//Creeper Cow
                EntityRegistry.registerModEntity(CreeperCow.class, "CreeperCow", 3,
        				this, 70, 3, true);
        		EntityRegistry.addSpawn(CreeperCow.class, 2, 2, 4, EnumCreatureType.monster,
        						BiomeGenBase.beach, BiomeGenBase.extremeHills,
        						BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest,
        						BiomeGenBase.forestHills, BiomeGenBase.jungle,
        						BiomeGenBase.jungleHills, BiomeGenBase.mushroomIsland,
        						BiomeGenBase.mushroomIslandShore, BiomeGenBase.ocean,
        						BiomeGenBase.plains, BiomeGenBase.river,
        						BiomeGenBase.swampland);
                
        		//Ender Cow
                EntityRegistry.registerModEntity(EnderCow.class, "EnderCow", 4,
        				this, 70, 3, true);
        		EntityRegistry.addSpawn(EnderCow.class, 2, 2, 4, EnumCreatureType.monster,
        						BiomeGenBase.beach, BiomeGenBase.extremeHills,
        						BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest,
        						BiomeGenBase.forestHills, BiomeGenBase.jungle,
        						BiomeGenBase.jungleHills, BiomeGenBase.mushroomIsland,
        						BiomeGenBase.mushroomIslandShore, BiomeGenBase.ocean,
        						BiomeGenBase.plains, BiomeGenBase.river,
        						BiomeGenBase.swampland);
        		
        		//Green cow
                EntityRegistry.registerModEntity(GreenCow.class, "GreenCow", 5,
        				this, 70, 3, true);
        		EntityRegistry.addSpawn(GreenCow.class, 3, 2, 4, EnumCreatureType.monster,
        						BiomeGenBase.beach, BiomeGenBase.extremeHills,
        						BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest,
        						BiomeGenBase.forestHills, BiomeGenBase.jungle,
        						BiomeGenBase.jungleHills, BiomeGenBase.mushroomIsland,
        						BiomeGenBase.mushroomIslandShore, BiomeGenBase.ocean,
        						BiomeGenBase.plains, BiomeGenBase.river,
        						BiomeGenBase.swampland);
        		
        		//Milka Cow
                EntityRegistry.registerModEntity(MilkaCow.class, "MilkaCow", 6,
        				this, 70, 3, true);
        		EntityRegistry.addSpawn(MilkaCow.class, 1, 2, 4, EnumCreatureType.monster,
        						BiomeGenBase.beach, BiomeGenBase.extremeHills,
        						BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest,
        						BiomeGenBase.forestHills, BiomeGenBase.jungle,
        						BiomeGenBase.jungleHills, BiomeGenBase.mushroomIsland,
        						BiomeGenBase.mushroomIslandShore, BiomeGenBase.ocean,
        						BiomeGenBase.plains, BiomeGenBase.river,
        						BiomeGenBase.swampland);
        		
        		//White Cow
                EntityRegistry.registerModEntity(WhiteCow.class, "WhiteCow", 7,
        				this, 70, 3, true);
        		EntityRegistry.addSpawn(WhiteCow.class, 3, 2, 4, EnumCreatureType.monster,
        						BiomeGenBase.beach, BiomeGenBase.extremeHills,
        						BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest,
        						BiomeGenBase.forestHills, BiomeGenBase.jungle,
        						BiomeGenBase.jungleHills, BiomeGenBase.mushroomIsland,
        						BiomeGenBase.mushroomIslandShore, BiomeGenBase.ocean,
        						BiomeGenBase.plains, BiomeGenBase.river,
        						BiomeGenBase.swampland);
        		
        		//Zombie Cow
                EntityRegistry.registerModEntity(ZombieCow.class, "ZombieCow", 8,
        				this, 70, 3, true);
        		EntityRegistry.addSpawn(ZombieCow.class, 3, 2, 4, EnumCreatureType.monster,
        						BiomeGenBase.beach, BiomeGenBase.extremeHills,
        						BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest,
        						BiomeGenBase.forestHills, BiomeGenBase.jungle,
        						BiomeGenBase.jungleHills, BiomeGenBase.mushroomIsland,
        						BiomeGenBase.mushroomIslandShore, BiomeGenBase.ocean,
        						BiomeGenBase.plains, BiomeGenBase.river,
        						BiomeGenBase.swampland);
        		
        		//Blaze Cow
                EntityRegistry.registerModEntity(BlazeCow.class, "BlazeCow", 9,
        				this, 70, 3, true);
        		EntityRegistry.addSpawn(BlazeCow.class, 3, 2, 4, EnumCreatureType.monster,
        						BiomeGenBase.hell);
        		
        		//Cheat Sword
                GameRegistry.registerItem(cheat, "CheatSword");
                LanguageRegistry.addName(cheat, "Cheat Sword"); 
                
                //Swords
                GameRegistry.registerItem(basic, "BasicSword");
                LanguageRegistry.addName(basic, "Basic Sword"); 
                
                //entity egg
        		registerEntityEgg(BlueCow.class, 0x3366CC, 0x3366CC);
        		LanguageRegistry.instance().addStringLocalization(
        				"entity.CowRev.BlueCow.name", "Blue Cow");
        		
        		registerEntityEgg(AgentCow.class, 0xffffff, 0x000000);
        		LanguageRegistry.instance().addStringLocalization(
        				"entity.CowRev.AgentCow.name", "Agent Cow");	
        		
        		registerEntityEgg(CreeperCow.class, 0x00CC00, 0x00CC00);
        		LanguageRegistry.instance().addStringLocalization(
        				"entity.CowRev.CreeperCow.name", "Creeper Cow");	

        		registerEntityEgg(EnderCow.class, 0xCC3366, 0xCC3366);
        		LanguageRegistry.instance().addStringLocalization(
        				"entity.CowRev.EnderCow.name", "Ender Cow");	
        		
        		registerEntityEgg(GreenCow.class, 0x66FF00, 0x66FF00);
        		LanguageRegistry.instance().addStringLocalization(
        				"entity.CowRev.GreenCow.name", "Green Cow");	
        		
        		registerEntityEgg(MilkaCow.class, 0xCC00CC, 0xCC00CC);
        		LanguageRegistry.instance().addStringLocalization(
        				"entity.CowRev.MilkaCow.name", "Choco Cow");
        		
        		registerEntityEgg(WhiteCow.class, 0xFFFFFF, 0xFFFFFF);
        		LanguageRegistry.instance().addStringLocalization(
        				"entity.CowRev.WhiteCow.name", "White Cow");
        		
        		registerEntityEgg(ZombieCow.class, 0x339900, 0x339900);
        		LanguageRegistry.instance().addStringLocalization(
        				"entity.CowRev.ZombieCow.name", "Zombie Cow");
        		
        		registerEntityEgg(BlazeCow.class, 0xCC0000, 0xFF0000);
        		LanguageRegistry.instance().addStringLocalization(
        				"entity.CowRev.BlazeCow.name", "Blaze Cow");
        		
        }
        		public static int getUniqueEntityId() {
        			do {
        				startEntityId++;
        			} while (EntityList.getStringFromID(startEntityId) != null);

        			return startEntityId;
        		}

        		public static int registerEntityEgg(Class<? extends Entity> entity,
        				int primaryColor, int secondaryColor) {
        			int id = getUniqueEntityId();
        			EntityList.IDtoClassMapping.put(id, entity);
        			EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor,
        					secondaryColor));
        			return id;
        		}
        		
        		ArrayList<BiomeGenBase> biomeList = new ArrayList<BiomeGenBase>();{
        		for(int i = 0; i < BiomeGenBase.biomeList.length; i++)
        		{
        		if(BiomeGenBase.biomeList[i] != null && BiomeGenBase.biomeList[i].biomeID != 17)
        		{
        		biomeList.add(BiomeGenBase.biomeList[i]);
        		}
        		}
        		}
        		
        		        
        @PostInit
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}
        
