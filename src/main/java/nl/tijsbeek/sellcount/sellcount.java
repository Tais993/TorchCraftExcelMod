package nl.tijsbeek.sellcount;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import nl.tijsbeek.sellcount.Event.ChatEvent;
import nl.tijsbeek.sellcount.Event.ClientChatReceived;
import nl.tijsbeek.sellcount.Event.ClientTickEvent;
import nl.tijsbeek.sellcount.Event.PlayerInteract;
import nl.tijsbeek.sellcount.Excel.Excel;
import nl.tijsbeek.sellcount.Gui.RenderGuiHandler;
import nl.tijsbeek.sellcount.Mod.Stock;
import nl.tijsbeek.sellcount.Settings.Settings;

import java.io.IOException;

import static nl.tijsbeek.sellcount.Mod.Stock.startCalculationsInt;
import static nl.tijsbeek.sellcount.Settings.Settings.autoPricesImport;

// * The value here should match an entry in the META-INF/mods.toml file
@Mod("sellcount")
public class sellcount {

    public static final String MOD_ID = "sellcount";

    public sellcount() throws IOException {
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

        if (autoPricesImport) {
            Excel.importExcel();
        }
    }

    public static void main(String[] args) {
    }

    private void setup(final FMLCommonSetupEvent event) {
    }
}
