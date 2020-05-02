package wtmmd;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;

public class DiscItem extends ItemRecord {
    protected DiscItem(String name, SoundEvent sound) {
        super(name, sound);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(wtmmdTab);
    }
    
	static final CreativeTabs wtmmdTab = (new CreativeTabs("wtmmdTab") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemRegister.discs.get("record_dog"));
		}
		
	});
}
