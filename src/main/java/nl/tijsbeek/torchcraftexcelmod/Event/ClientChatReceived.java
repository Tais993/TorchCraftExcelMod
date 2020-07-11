package nl.tijsbeek.torchcraftexcelmod.Event;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import nl.tijsbeek.torchcraftexcelmod.torchcraftexcelmod;

import static nl.tijsbeek.torchcraftexcelmod.Mod.Stock.balWorth;

@Mod.EventBusSubscriber(modid = torchcraftexcelmod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ClientChatReceived extends Event {

    static boolean getMessage = false;

    @SubscribeEvent
    public static void clientChatReceived(ClientChatReceivedEvent event) {

        if (getMessage) {

            String messageString = event.getMessage().getString();

            Minecraft.getInstance().player.sendMessage(new StringTextComponent("Message has been recieved"));

            String balBeforeDecimals = (event.getMessage().getString().replaceAll("[^0-9.]", ""));

            Minecraft.getInstance().player.sendMessage(new StringTextComponent("Bal: " + balBeforeDecimals));

            balWorth = Double.parseDouble(balBeforeDecimals);
            getMessage = false;
        }
    }
}
