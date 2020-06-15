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

public class Inventory {

    Stock stock = new Stock();
    ChatEvent chatEvent = new ChatEvent();

    public void countInventory() {

        /*
        for (Map.Entry<String, Integer> entry : stock.itemAmountInventory.entrySet()) {
            String key = entry.getKey();
            entry.setValue(Minecraft.getInstance().player.inventory.count(Item.getItemFromBlock(Blocks.STONE)));
        }
         */

        chatEvent.sendMessage("Item: " + Item.getItemFromBlock(Blocks.GOLD_ORE) + " ID: " + Item.getIdFromItem(Item.getItemFromBlock(Blocks.GOLD_ORE)));
        chatEvent.sendMessage("Item: " + Item.getItemFromBlock(Blocks.IRON_ORE) + " ID: " + Item.getIdFromItem(Item.getItemFromBlock(Blocks.IRON_ORE)));
        chatEvent.sendMessage("Item: " + Item.getItemFromBlock(Blocks.COAL_ORE) + " ID: " + Item.getIdFromItem(Item.getItemFromBlock(Blocks.COAL_ORE)));
        chatEvent.sendMessage("Item: " + Item.getItemFromBlock(Blocks.LAPIS_ORE) + " ID: " + Item.getIdFromItem(Item.getItemFromBlock(Blocks.LAPIS_ORE)));
        chatEvent.sendMessage("Item: " + Item.getItemFromBlock(Blocks.DIAMOND_ORE) + " ID: " + Item.getIdFromItem(Item.getItemFromBlock(Blocks.DIAMOND_ORE)));
        chatEvent.sendMessage("Item: " + Item.getItemFromBlock(Blocks.EMERALD_ORE) + " ID: " + Item.getIdFromItem(Item.getItemFromBlock(Blocks.EMERALD_ORE)));
        chatEvent.sendMessage("Item: " + Item.getItemFromBlock(Blocks.DIORITE) + " ID: " + Item.getIdFromItem(Item.getItemFromBlock(Blocks.DIORITE)));
        chatEvent.sendMessage("Item: " + Item.getItemFromBlock(Blocks.ANDESITE) + " ID: " + Item.getIdFromItem(Item.getItemFromBlock(Blocks.ANDESITE)));
        chatEvent.sendMessage("Item: " + Item.getItemFromBlock(Blocks.GRANITE) + " ID: " + Item.getIdFromItem(Item.getItemFromBlock(Blocks.GRANITE)));
        chatEvent.sendMessage("Item: " + Item.getItemFromBlock(Blocks.REDSTONE_ORE) + " ID: " + Item.getIdFromItem(Item.getItemFromBlock(Blocks.REDSTONE_ORE)));
        chatEvent.sendMessage("Item: " + Item.getItemFromBlock(Blocks.PRISMARINE_BRICKS) + " ID: " + Item.getIdFromItem(Item.getItemFromBlock(Blocks.PRISMARINE_BRICKS)));
        chatEvent.sendMessage("Item: " + Item.getItemFromBlock(Blocks.DARK_PRISMARINE) + " ID: " + Item.getIdFromItem(Item.getItemFromBlock(Blocks.DARK_PRISMARINE)));
        chatEvent.sendMessage("Item: " + Item.getItemFromBlock(Blocks.NETHER_QUARTZ_ORE) + " ID: " + Item.getIdFromItem(Item.getItemFromBlock(Blocks.NETHER_QUARTZ_ORE)));
        chatEvent.sendMessage("Item: " + Item.getItemFromBlock(Blocks.SEA_LANTERN) + " ID: " + Item.getIdFromItem(Item.getItemFromBlock(Blocks.SEA_LANTERN)));
        chatEvent.sendMessage("Item: " + Item.getItemFromBlock(Blocks.RED_SANDSTONE) + " ID: " + Item.getIdFromItem(Item.getItemFromBlock(Blocks.RED_SANDSTONE)));
        chatEvent.sendMessage("Item: " + Item.getItemFromBlock(Blocks.SANDSTONE) + " ID: " + Item.getIdFromItem(Item.getItemFromBlock(Blocks.SANDSTONE)));
        chatEvent.sendMessage("Item: " + Item.getItemFromBlock(Blocks.GRAVEL) + " ID: " + Item.getIdFromItem(Item.getItemFromBlock(Blocks.GRAVEL)));
        chatEvent.sendMessage("Item: " + Item.getItemFromBlock(Blocks.OAK_LOG) + " ID: " + Item.getIdFromItem(Item.getItemFromBlock(Blocks.OAK_LOG)));
        chatEvent.sendMessage("Item: " + Item.getItemFromBlock(Blocks.COAL_BLOCK) + " ID: " + Item.getIdFromItem(Item.getItemFromBlock(Blocks.COAL_BLOCK)));


        /*
        stock.gold_ore = Minecraft.getInstance().player.inventory.count(Item.getItemFromBlock(Blocks.GOLD_ORE));
            stock.iron_ore = Minecraft.getInstance().player.inventory.count(Item.getItemFromBlock(Blocks.IRON_ORE));
            stock.coal_ore = Minecraft.getInstance().player.inventory.count(Item.getItemFromBlock(Blocks.COAL_ORE));
            stock.lapis_ore = Minecraft.getInstance().player.inventory.count(Item.getItemFromBlock(Blocks.LAPIS_ORE));
            stock.diamond_ore = Minecraft.getInstance().player.inventory.count(Item.getItemFromBlock(Blocks.DIAMOND_ORE));
            stock.emerald_ore = Minecraft.getInstance().player.inventory.count(Item.getItemFromBlock(Blocks.EMERALD_ORE));
            stock.diorite = Minecraft.getInstance().player.inventory.count(Item.getItemFromBlock(Blocks.DIORITE));
            stock.andesite = Minecraft.getInstance().player.inventory.count(Item.getItemFromBlock(Blocks.ANDESITE));
            stock.granite = Minecraft.getInstance().player.inventory.count(Item.getItemFromBlock(Blocks.GRANITE));
            stock.redstone_ore = Minecraft.getInstance().player.inventory.count(Item.getItemFromBlock(Blocks.REDSTONE_ORE));
            stock.prismarine_bricks = Minecraft.getInstance().player.inventory.count(Item.getItemFromBlock(Blocks.PRISMARINE_BRICKS));
            stock.dark_prismarine = Minecraft.getInstance().player.inventory.count(Item.getItemFromBlock(Blocks.DARK_PRISMARINE));
            stock.nether_quartz_ore = Minecraft.getInstance().player.inventory.count(Item.getItemFromBlock(Blocks.NETHER_QUARTZ_ORE));
            stock.sea_latern = Minecraft.getInstance().player.inventory.count(Item.getItemFromBlock(Blocks.SEA_LANTERN));
            stock.red_sandstone = Minecraft.getInstance().player.inventory.count(Item.getItemFromBlock(Blocks.RED_SANDSTONE));
            stock.sandstone = Minecraft.getInstance().player.inventory.count(Item.getItemFromBlock(Blocks.SANDSTONE));
            stock.gravel = Minecraft.getInstance().player.inventory.count(Item.getItemFromBlock(Blocks.GRAVEL));
            stock.oak_log = Minecraft.getInstance().player.inventory.count(Item.getItemFromBlock(Blocks.OAK_LOG));
            stock.coal_blocks = Minecraft.getInstance().player.inventory.count(Item.getItemFromBlock(Blocks.COAL_BLOCK));



        ITextComponent iTextComponent = new StringTextComponent(
       "stock.stone(" + stock.stone + ")\n" +
            "stock.gold_ore(" + stock.gold_ore + ")\n" +
            "stock.coal_ore(" + stock.coal_ore + ")\n" +
            "stock.iron_ore(" + stock.iron_ore + ")\n" +
            "stock.lapis_ore(" + stock.lapis_ore + ")\n" +
            "stock.diamond_ore(" + stock.diamond_ore + ")\n" +
            "stock.emerald_ore(" + stock.emerald_ore + ")\n" +
            "stock.diorite(" + stock.diorite + ")\n" +
            "stock.andesite(" + stock.andesite + ")\n" +
            "stock.granite(" + stock.granite + ")\n" +
            "stock.redstone_ore(" + stock.redstone_ore + ")\n" +
            "stock.prismarine_bricks(" + stock.prismarine_bricks + ")\n" +
            "stock.dark_prismarine(" + stock.dark_prismarine + ")\n" +
            "stock.nether_quartz_ore(" + stock.nether_quartz_ore + ")\n" +
            "stock.sea_latern(" + stock.sea_latern + ")\n" +
            "stock.red_sandstone(" + stock.red_sandstone + ")\n" +
            "stock.sandstone(" + stock.sandstone + ")\n" +
            "stock.gravel(" + stock.gravel + ")\n" +
            "stock.oak_log(" + stock.oak_log + ")\n" +
            "stock.coal_blocks(" + stock.coal_blocks + ")");
        Minecraft.getInstance().player.sendMessage(iTextComponent);

   */

        stock.CalculateInventoryWorth();
    }

    public void clearStock(){
        /*
        stock.stone = 0;
        stock.gold_ore = 0;
        stock.iron_ore = 0;
        stock.coal_ore = 0;
        stock.lapis_ore = 0;
        stock.diamond_ore = 0;
        stock.emerald_ore = 0;
        stock.diorite = 0;
        stock.andesite = 0;
        stock.granite = 0;
        stock.redstone_ore = 0;
        stock.prismarine_bricks = 0;
        stock.dark_prismarine = 0;
        stock.nether_quartz_ore = 0;
        stock.sea_latern = 0;
        stock.red_sandstone= 0;
        stock.sandstone = 0;
        stock.gravel= 0;
        stock.oak_log = 0;
        stock.coal_blocks = 0;

        checkItemStackinInventory(Blocks.SEA_LANTERN);
         */
    }

    boolean checkItemStackinInventory(Block block) {
        return Minecraft.getInstance().player.inventory.hasItemStack(new ItemStack(block));
    }
}
