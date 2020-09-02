package nl.tijsbeek.torchcraftexcelmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import nl.tijsbeek.torchcraftexcelmod.Event.ChatEvent;
import nl.tijsbeek.torchcraftexcelmod.Event.ClientChatReceived;
import nl.tijsbeek.torchcraftexcelmod.Event.ClientTickEvent;
import nl.tijsbeek.torchcraftexcelmod.Event.PlayerInteract;
import nl.tijsbeek.torchcraftexcelmod.Excel.Excel;
import nl.tijsbeek.torchcraftexcelmod.Gui.*;
import nl.tijsbeek.torchcraftexcelmod.Mod.Stock;
import nl.tijsbeek.torchcraftexcelmod.Settings.Settings;

import java.io.IOException;

import static nl.tijsbeek.torchcraftexcelmod.Mod.Stock.startCalculationsInt;
import static nl.tijsbeek.torchcraftexcelmod.Settings.Settings.autoPricesImport;

// * The value here should match an entry in the META-INF/mods.toml file
@Mod("torchcraftexcelmod")
public class torchcraftexcelmod {

    public static final String MOD_ID = "torchcraftexcelmod" ;

    public torchcraftexcelmod() throws IOException {
        // * Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().register(new ChatEvent());
        MinecraftForge.EVENT_BUS.register(new ClientTickEvent());
        MinecraftForge.EVENT_BUS.register(new ClientChatReceived());
        MinecraftForge.EVENT_BUS.register(new RenderGuiHandler());
        MinecraftForge.EVENT_BUS.register(new PlayerInteract());

        Stock.main();
        startCalculationsInt = 1;

        Settings.settings();
        Settings.importSettings();

        if (autoPricesImport){
            Excel.importExcel();
        }
    }

    public static void main(String[] args) {
    }

    private void setup(final FMLCommonSetupEvent event) {
    }
}
