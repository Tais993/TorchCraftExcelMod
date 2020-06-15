package nl.tijsbeek.torchcraftexcelmod.Gui;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import nl.tijsbeek.torchcraftexcelmod.Mod.Stock;

public class RenderGuiHandler {

    Stock stock = new Stock();

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent event) {
        if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.TEXT){
            Minecraft mc = Minecraft.getInstance();

            int screenHeight = event.getWindow().getScaledHeight();
            int textLength = Minecraft.getInstance().fontRenderer.getStringWidth(stock.getInventoryWorth() + "");

            Minecraft.getInstance().fontRenderer.drawString("Total inventory worth: " + stock.getInventoryWorth(), 0, 0, -1);
        }
    }
}