package nl.tijsbeek.sellcount.Event;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import nl.tijsbeek.sellcount.sellcount;

import java.util.ArrayList;

import static nl.tijsbeek.sellcount.Event.ClientTickEvent.checkChest;
import static nl.tijsbeek.sellcount.Gui.RenderGuiHandler.chestOpenedBefore;

@Mod.EventBusSubscriber(modid = sellcount.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerInteract extends Event {

    static public ArrayList<BlockPos> chestOpened = new ArrayList<>();

    @SubscribeEvent
    public void playerInteractEvent(PlayerInteractEvent.RightClickBlock event) {

        // * Player is not sneaking

        if (!event.getEntity().isSneaking()) {

            Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
            BlockPos blockPosition = event.getPos();

            if (block == Blocks.CHEST && !chestOpened.contains(blockPosition)) {
                chestOpened.add(blockPosition);
                checkChest = true;
            } else if (chestOpened.contains(blockPosition)) {
                chestOpenedBefore = true;
            }
        }
    }
}