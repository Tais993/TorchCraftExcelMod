package nl.tijsbeek.torchcraftexcelmod.Gui;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static nl.tijsbeek.torchcraftexcelmod.Mod.Stock.inventoryWorth;
import static nl.tijsbeek.torchcraftexcelmod.Settings.Settings.*;

public class RenderGuiHandler {

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent event) {
        if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.TEXT){

            double roundedInventoryWorth = inventoryWorth;

            if (roundNumbersOn2Decimals) {
                roundedInventoryWorth = (double) Math.round(inventoryWorth * 100) / 100;
            }

            // * Renders at the top left the amount of money the inventory is worth

            // ! Going to add a class, to render the settings.

            // ! I'm NOT going to add a drag function, I'll make it so the player can give a value for this text to be displayed at. Dragging will take too much time.

            if (showTextBeforeNumberGUI) {
                Minecraft.getInstance().fontRenderer.drawString("Total inventory worth: " + roundedInventoryWorth, locationTextX, locationTextY, -1);
            } else {
                Minecraft.getInstance().fontRenderer.drawString("" + roundedInventoryWorth, locationTextX, locationTextY, -1);
            }
        }
    }
}