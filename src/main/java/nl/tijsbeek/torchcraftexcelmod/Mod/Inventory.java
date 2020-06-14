package nl.tijsbeek.torchcraftexcelmod.Mod;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class Inventory {

    Stock stock = new Stock();

    public void countInventory() {

            stock.stone = Minecraft.getInstance().player.inventory.count(Item.getItemFromBlock(Blocks.STONE));
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


        /*
        ITextComponent iTextComponent = new StringTextComponent(
       "stock.stone(" + stock.stone + ")\n" +
            "stock.gold_ore(" + stock.gold_ore + ")\n" +
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
    }

    boolean checkItemStackinInventory(Block block) {
        return Minecraft.getInstance().player.inventory.hasItemStack(new ItemStack(block));
    }
}
