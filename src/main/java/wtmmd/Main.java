package wtmmd;

import net.minecraft.init.Items;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import wtmmd.util.Reference;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	
	@Instance
	public static Main instance;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
        for (DiscItem disc : ItemRegister.discs.values()) {
        	OreDictionary.registerOre("record", disc);        
        }
	}
	
	@EventHandler
	public static void Postinit(FMLPostInitializationEvent event)
	{

	}

//    @SubscribeEvent
//    public  void onLootTablesLoaded(LootTableLoadEvent event) {
//        if (LootLocationRepository.getAllowedLootLocations().contains(event.getName())) {
//            event.getTable().addPool(createDiscPool());
//        }
//    }
    
	@SubscribeEvent

	public void onLootTablesLoaded(LootTableLoadEvent e)

	{

	if (e.getName().toString().equals("minecraft:chests/simple_dungeon"))

	{

	LootEntry entry = new LootEntryItem(Items.ARROW, 15, 60, new LootFunction[0], new LootCondition[0], "biomecompass:directional_shard");

	LootPool pool1 = new LootPool(new LootEntry[]{entry}, new LootCondition[0], new RandomValueRange(1), new RandomValueRange(0,1), "biomecompass_pool_inject");

	e.getTable().addPool(pool1);

	}

	}
    
    
  
    
}
