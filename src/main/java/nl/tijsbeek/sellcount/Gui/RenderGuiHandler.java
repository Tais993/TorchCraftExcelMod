package nl.tijsbeek.sellcount.Gui;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.awt.*;

import static nl.tijsbeek.sellcount.Mod.Stock.inventoryWorth;
import static nl.tijsbeek.sellcount.Settings.Settings.*;

public class RenderGuiHandler {

    public static boolean chestOpenedBefore = false;

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent event) {
        if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {

            double renderInventoryWorth = inventoryWorth;

            if (roundNumbersOn2Decimals) {
                renderInventoryWorth = (double) Math.round(inventoryWorth * 100) / 100;
            }

            // * Renders at the top left the amount of money the inventory is worth

            // ! Going to add a class, to render the settings.

            // ! I'm NOT going to add a drag function, I'll make it so the player can give a value for this text to be displayed at. Dragging will take too much time.


            if (showTextBeforeNumberGUI) {
                Minecraft.getInstance().fontRenderer.drawString("Total inventory worth: " + renderInventoryWorth, locationInventoryWorthX, locationInventoryWorthY, -1);
            } else {
                Minecraft.getInstance().fontRenderer.drawString("" + renderInventoryWorth, locationInventoryWorthX, locationInventoryWorthY, -1);
            }

            if (chestOpenedBefore) {
                renderChestModGui();
            }
        }
    }

    public static void renderChestModGui() {
        Minecraft.getInstance().fontRenderer.drawString("Chest has been opened", 50, 50, Color.GREEN.getRGB());
    }
}