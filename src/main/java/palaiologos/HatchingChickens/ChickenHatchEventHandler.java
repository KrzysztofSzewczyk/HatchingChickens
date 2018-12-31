package palaiologos.HatchingChickens;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import scala.util.Random;

public class ChickenHatchEventHandler {
	private Random r = new Random();
	private int hatchChance = 20;

	@SubscribeEvent
	public void hatch(ItemExpireEvent e) {
		if (e.getEntityItem().getItem().getItem() == Items.EGG) {
			int stack = e.getEntityItem().getItem().getCount();
			for (int i = 1; i <= stack; i++) {
				if (this.hatchChance == 0) {
					this.hatchChance = 25;
				}
				if (this.r.nextInt(100) <= this.hatchChance) {
					EntityChicken chicken = new EntityChicken(e.getEntityItem().getEntityWorld());
					chicken.posX = e.getEntity().posX;
					chicken.posY = e.getEntity().posY;
					chicken.posZ = e.getEntity().posZ;

					e.getEntityItem().getEntityWorld().setBlockToAir(new BlockPos(e.getEntity().posX, e.getEntity().posY, e.getEntity().posZ));
					e.getEntityItem().getEntityWorld().spawnEntity(chicken);
				}
			}
		}
	}
}
