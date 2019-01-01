package palaiologos.HatchingChickens;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import scala.util.Random;

public class ChickenHatchEventHandler {
	private Random r = new Random();
	private int hatchChance = 100;

	@SubscribeEvent
	public void hatch(ItemExpireEvent e) {
		if (e.getEntityItem().getItem().getItem() == Items.EGG) {
			System.out.println("1. Item is an egg.");
			int stack = e.getEntityItem().getItem().getCount();
			System.out.println("2. There are " + stack + " eggs.");
			for (int i = 1; i <= stack; i++) {
				if (this.r.nextInt(100) <= this.hatchChance) {
					System.out.println("3. Egg is hatching.");
					EntityChicken chicken = new EntityChicken(e.getEntityItem().getEntityWorld());
					
					chicken.posX = e.getEntity().posX;
					chicken.posY = e.getEntity().posY+2;
					chicken.posZ = e.getEntity().posZ;

					e.getEntityItem().getEntityWorld().spawnEntity(chicken);
				}
			}
		}
	}
}
