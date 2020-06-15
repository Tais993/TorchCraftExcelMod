package nl.tijsbeek.torchcraftexcelmod.Event;

import net.minecraft.client.Minecraft;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import nl.tijsbeek.torchcraftexcelmod.Gui.RenderGuiHandler;
import nl.tijsbeek.torchcraftexcelmod.Mod.Inventory;
import nl.tijsbeek.torchcraftexcelmod.torchcraftexcelmod;

import static nl.tijsbeek.torchcraftexcelmod.Event.ChatEvent.sendMessage;

@Mod.EventBusSubscriber(modid = torchcraftexcelmod.MOD_ID)
public class ClientTickEvent extends Event {

    int timesChanged = 0;
    boolean calculationsStarted = true;
    Inventory inventory = new Inventory();
    RenderGuiHandler renderGuiHandler = new RenderGuiHandler();

    @SubscribeEvent
    public void clientTickEvent(TickEvent.ClientTickEvent event) throws InterruptedException {
        /*
        if (Minecraft.getInstance().player != null) {
            if (Minecraft.getInstance().player.inventory.getTimesChanged() > timesChanged) {
                inventory.countInventory();
                timesChanged = Minecraft.getInstance().player.inventory.getTimesChanged();
                sendMessage("Your inventory has been changed: " + timesChanged + "times");
            }
        }
        */
    }
}
