package nl.tijsbeek.torchcraftexcelmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import nl.tijsbeek.torchcraftexcelmod.Event.ChatEvent;
import nl.tijsbeek.torchcraftexcelmod.Event.ClientTickEvent;
import nl.tijsbeek.torchcraftexcelmod.Gui.*;

// * The value here should match an entry in the META-INF/mods.toml file
@Mod("torchcraftexcelmod")
public class torchcraftexcelmod {

    public static final String MOD_ID = "torchcraftexcelmod" ;

    ChatEvent chatEvent = new ChatEvent();

    public torchcraftexcelmod() {
        // * Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().register(chatEvent);
        MinecraftForge.EVENT_BUS.register(new ClientTickEvent());
        MinecraftForge.EVENT_BUS.register(new RenderGuiHandler());
    }

    public static void main(String[] args) {

    }

    private void setup(final FMLCommonSetupEvent event) {
    }
}
