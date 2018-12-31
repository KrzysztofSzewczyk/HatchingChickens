package palaiologos.HatchingChickens;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "hatchingchickens", name = "Hatching Chickens", version = "1.0.0", acceptedMinecraftVersions = "[1.12.2]")
public class HatchingChickens {
	public static final String modId = "hatchingchickens";
	public static final String name = "Hatching Chickens";
	public static final String version = "1.0.0";
	public static final String mcversion = "[1.12.2]";
	@Mod.Instance("hatchingchickens")
	public static HatchingChickens instance;
	@SidedProxy(serverSide = "palaiologos.HatchingChickens.CommonProxy", clientSide = "palaiologos.HatchingChickens.ClientProxy")
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		FMLCommonHandler.instance().bus().register(new ChickenHatchEventHandler());
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}

}
