package nl.tijsbeek.torchcraftexcelmod.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import nl.tijsbeek.torchcraftexcelmod.Mod.Stock;

import static nl.tijsbeek.torchcraftexcelmod.Mod.Stock.getInventoryWorth;

public class RenderGuiHandler {

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent event) {
        if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.TEXT){
            Minecraft mc = Minecraft.getInstance();

            int screenHeight = event.getWindow().getScaledHeight();
            int textLength = Minecraft.getInstance().fontRenderer.getStringWidth(getInventoryWorth() + "");

            // * Renders at the top left the amount of money the inventory is worth
            Minecraft.getInstance().fontRenderer.drawString("Total inventory worth: " + getInventoryWorth(), 0, 0, -1);
        }
    }
}