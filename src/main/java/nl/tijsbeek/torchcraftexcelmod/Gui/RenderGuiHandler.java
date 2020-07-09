package nl.tijsbeek.torchcraftexcelmod.Gui;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static nl.tijsbeek.torchcraftexcelmod.Mod.Stock.inventoryWorth;

public class RenderGuiHandler {

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent event) {
        if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.TEXT){

            // * Renders at the top left the amount of money the inventory is worth

            // ! Going to add a class, to render the settings.
            // ! I'll first make a settings file. Not going to do it using JSON.
            // ! I'll have to manually code it, and it's probably going to be shit but sure.

            // ! I'm NOT going to add a drag function, I'll make it so the player can give a value for this text to be displayed at. Dragging will take too much time.
            Minecraft.getInstance().fontRenderer.drawString("Total inventory worth: " + inventoryWorth, 0, 0, -1);
        }
    }
}