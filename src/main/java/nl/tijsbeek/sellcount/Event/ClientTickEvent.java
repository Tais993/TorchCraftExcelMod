package nl.tijsbeek.sellcount.Event;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import nl.tijsbeek.sellcount.sellcount;

import static nl.tijsbeek.sellcount.Gui.RenderGuiHandler.chestOpenedBefore;
import static nl.tijsbeek.sellcount.Mod.CalculateTotalWorth.*;
import static nl.tijsbeek.sellcount.Mod.Stock.startCalculationsInt;
import static nl.tijsbeek.sellcount.Settings.Settings.ticksUntilUpdate;

@Mod.EventBusSubscriber(modid = sellcount.MOD_ID)
public class ClientTickEvent extends Event {

    int tick = 0;
    int ticksChest = 0;
    int ticksChestGui = 0;

    static boolean checkChest = false;

    // ! If the ticksUntilUpdate is low, the player will have big lag spikes when opening a chest.

    @SubscribeEvent
    public void clientTickEvent(TickEvent.ClientTickEvent event) {
        // * If the game is still in the mainscreen or something like that it returns a null, so if it's not a null it can go trough
        if (Minecraft.getInstance().player != null) {
            // * allows you to turn the calculations on or off
            if (startCalculationsInt == 1) {
                tick++;
                // * Set's a tick waiter, so you can say per .. ticks it calculates everything.
                if (tick >= ticksUntilUpdate) {
                    CountInventory();
                    CalculateInventoryWorth();
                    tick = 0;
                }

                if (checkChest) {
                    if (ticksChest >= 3) {
                        CountChest();
                        ticksChest = 0;
                        checkChest = false;
                    }
                    ticksChest++;
                }

                if (chestOpenedBefore) {
                    if (Minecraft.getInstance().player.openContainer.inventorySlots.size() == 46 && ticksChestGui >= 20) {
                        chestOpenedBefore = false;
                        ticksChestGui = 0;
                    }
                    Minecraft.getInstance().player.sendMessage(new StringTextComponent(Minecraft.getInstance().player.openContainer.inventorySlots.size() + ""));
                    ticksChestGui++;
                }
            }
        }
    }
}
