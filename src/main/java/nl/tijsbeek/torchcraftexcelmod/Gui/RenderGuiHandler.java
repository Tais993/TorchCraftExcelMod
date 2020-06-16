package nl.tijsbeek.torchcraftexcelmod.Gui;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static nl.tijsbeek.torchcraftexcelmod.Mod.Stock.getInventoryWorth;

public class RenderGuiHandler {

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent event) {
        if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.TEXT){

            // * Renders at the top left the amount of money the inventory is worth
            Minecraft.getInstance().fontRenderer.drawString("Total inventory worth: " + getInventoryWorth(), 0, 0, -1);
        }
    }
}