package nl.tijsbeek.torchcraftexcelmod.Mod;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import nl.tijsbeek.torchcraftexcelmod.Event.ChatEvent;
import nl.tijsbeek.torchcraftexcelmod.torchcraftexcelmod;

import java.util.Map;

import static nl.tijsbeek.torchcraftexcelmod.Mod.Stock.CalculateInventoryWorth;

public class Inventory {

    Stock stock = new Stock();
    ChatEvent chatEvent = new ChatEvent();


    boolean checkItemStackinInventory(Block block) {
        return Minecraft.getInstance().player.inventory.hasItemStack(new ItemStack(block));
    }
}
