package nl.tijsbeek.torchcraftexcelmod.Event;

import net.minecraft.client.Minecraft;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import nl.tijsbeek.torchcraftexcelmod.torchcraftexcelmod;

import static nl.tijsbeek.torchcraftexcelmod.Mod.Stock.*;
import static nl.tijsbeek.torchcraftexcelmod.Settings.Settings.ticksToUpdate;

@Mod.EventBusSubscriber(modid = torchcraftexcelmod.MOD_ID)
public class ClientTickEvent extends Event {

    int tick = 0;

    // ! If I switch servers, it takes a few seconds / minutes to start it again. Don't understand why or how?

    @SubscribeEvent
    public void clientTickEvent(TickEvent.ClientTickEvent event) {
        // * If the game is still in the mainscreen or something like that it returns a null, so if it's not a null it can go trough
        if (Minecraft.getInstance().player != null) {
            // * allows you to turn the calculations on or off
            if (startCalculationsInt == 1) {
                tick++;
                // * Set's a tick waiter, so you can say per .. ticks it calculates everything.
                if (tick >= ticksToUpdate) {
                    CalculateInventoryWorth();
                    tick = 0;
                }
            }
        }
    }
}
