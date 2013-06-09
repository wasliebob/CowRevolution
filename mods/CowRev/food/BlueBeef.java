package mods.CowRev.food;

import mods.CowRev.CowRev;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class BlueBeef extends ItemFood{

 public BlueBeef(int par1, int par2, float par3, boolean par4) {
  super(par1, par2, par3, par4);
  setCreativeTab(CreativeTabs.tabMisc);
  this.setFull3D();
  this.setUnlocalizedName("CowRev:bluebeef");

 }
 
 public void updateIcons(IconRegister iconRegister) {
    itemIcon = iconRegister.registerIcon("CowRev:bluebeef");
 }
}