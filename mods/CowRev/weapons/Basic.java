package mods.CowRev.weapons;

import mods.CowRev.CowRev;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.Event;

public class Basic extends Item {

        public Basic(int id) {
                super(id);
                
             // Constructor Configuration
                setMaxStackSize(1);
                setCreativeTab(CreativeTabs.tabMisc);
                setUnlocalizedName("CowRev:basic");
                setFull3D();
        }
        
        public void updateIcons(IconRegister par1IconRegister) {
            this.itemIcon = par1IconRegister.registerIcon("CowRev:basic");
            
        }
}