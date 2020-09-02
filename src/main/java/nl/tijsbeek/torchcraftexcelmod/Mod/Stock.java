package nl.tijsbeek.torchcraftexcelmod.Mod;

import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.MinecraftForge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static nl.tijsbeek.torchcraftexcelmod.Settings.Settings.*;

public class Stock {

    static public LinkedList<String> itemOrderedKeys = new LinkedList<>();
    static public HashMap<String, Stocks> itemData = new HashMap<>();

    static public int assignValues = 0;
    static public int startCalculationsInt = 0;
    static public double balWorth = 0.0;

    public static void main() {

        if (Minecraft.getInstance().player != null) {
            Minecraft.getInstance().player.sendMessage(new StringTextComponent("Main has been reached"));
        }

        // * If the main is already run it won't override the old values
        if (assignValues != 1) {
            if (Minecraft.getInstance().player != null) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("Assigning the values"));
            }

            // * Assign's how many times the specified item is inside the inventory (default is 0
            // ! Add a GUI or a import from excel function

            // * Imports the names, so I everything will be in tZhe right order.

            itemOrderedKeys.add("DIAMOND");
            itemOrderedKeys.add("LAPIS_LAZULI");
            itemOrderedKeys.add("EMERALD");
            itemOrderedKeys.add("REDSTONE");
            itemOrderedKeys.add("GOLD");
            itemOrderedKeys.add("IRON");
            itemOrderedKeys.add("COAL");

            itemOrderedKeys.add("DIAMOND_ORE");
            itemOrderedKeys.add("LAPIS_ORE");
            itemOrderedKeys.add("EMERALD_ORE");
            itemOrderedKeys.add("REDSTONE_ORE");
            itemOrderedKeys.add("GOLD_ORE");
            itemOrderedKeys.add("IRON_ORE");
            itemOrderedKeys.add("COAL_ORE");

            itemOrderedKeys.add("DIAMOND_BLOCK");
            itemOrderedKeys.add("LAPIS_BLOCK");
            itemOrderedKeys.add("EMERALD_BLOCK");
            itemOrderedKeys.add("REDSTONE_BLOCK");
            itemOrderedKeys.add("GOLD_BLOCK");
            itemOrderedKeys.add("IRON_BLOCK");
            itemOrderedKeys.add("COAL_BLOCK");

            itemOrderedKeys.add("COBBLESTONE");
            itemOrderedKeys.add("STONE");
            itemOrderedKeys.add("DIORITE");
            itemOrderedKeys.add("ANDESITE");
            itemOrderedKeys.add("GRANITE");
            itemOrderedKeys.add("QUARTZ");
            itemOrderedKeys.add("NETHER_QUARTZ_ORE");
            itemOrderedKeys.add("QUARTZ_BLOCK");
            itemOrderedKeys.add("END_STONE");

            itemOrderedKeys.add("OAK_LOG");
            itemOrderedKeys.add("LEATHER");
            itemOrderedKeys.add("GOLDEN_APPLE");
            itemOrderedKeys.add("PACKED_ICE");
            itemOrderedKeys.add("RED_SANDSTONE");
            itemOrderedKeys.add("PRISMARINE_BRICKS");
            itemOrderedKeys.add("DARK_PRISMARINE");
            itemOrderedKeys.add("SEA_LATERN");
            itemOrderedKeys.add("SAND");
            itemOrderedKeys.add("SANDSTONE");
            itemOrderedKeys.add("GRAVEL");
            itemOrderedKeys.add("STRING");
            itemOrderedKeys.add("FLINT");

            // * Imports all data to a object

            itemData.put("DIAMOND", new Stocks(0, 17.0, Items.DIAMOND));
            itemData.put("LAPIS_LAZULI", new Stocks(0, 18.0, Items.LAPIS_LAZULI));
            itemData.put("EMERALD", new Stocks(0, 12.0, Items.EMERALD));
            itemData.put("REDSTONE", new Stocks(0, 14.0, Items.REDSTONE));
            itemData.put("GOLD", new Stocks(0, 12.0, Items.GOLD_INGOT));
            itemData.put("IRON", new Stocks(0, 7.0, Items.IRON_INGOT));
            itemData.put("COAL", new Stocks(0, 2.375, Items.COAL));

            itemData.put("DIAMOND_ORE", new Stocks(0, 32.0, Items.DIAMOND_ORE));
            itemData.put("LAPIS_ORE", new Stocks(0, 140.0, Items.LAPIS_ORE));
            itemData.put("EMERALD_ORE", new Stocks(0, 24.0, Items.EMERALD_ORE));
            itemData.put("REDSTONE_ORE", new Stocks(0, 28.0, Items.REDSTONE_ORE));
            itemData.put("GOLD_ORE", new Stocks(0, 16.406, Items.GOLD_ORE));
            itemData.put("IRON_ORE", new Stocks(0, 14.063, Items.IRON_ORE));
            itemData.put("COAL_ORE", new Stocks(0, 4.0, Items.COAL_ORE));

            itemData.put("DIAMOND_BLOCK", new Stocks(0, 149.0, Items.DIAMOND_BLOCK));
            itemData.put("LAPIS_BLOCK", new Stocks(0, 168.0, Items.LAPIS_BLOCK));
            itemData.put("EMERALD_BLOCK", new Stocks(0, 111.0, Items.EMERALD_BLOCK));
            itemData.put("REDSTONE_BLOCK", new Stocks(0, 130.0, Items.DIAMOND));
            itemData.put("GOLD_BLOCK", new Stocks(0, 92.0, Items.GOLD_BLOCK));
            itemData.put("IRON_BLOCK", new Stocks(0, 55.0, Items.IRON_BLOCK));
            itemData.put("COAL_BLOCK", new Stocks(0, 20.0, Items.COAL_BLOCK));

            itemData.put("COBBLESTONE", new Stocks(0, 0.1, Items.COBBLESTONE));
            itemData.put("STONE", new Stocks(0, 1.1, Items.STONE));
            itemData.put("DIORITE", new Stocks(0, 2.0, Items.DIORITE));
            itemData.put("ANDESITE", new Stocks(0, 3.0, Items.ANDESITE));
            itemData.put("GRANITE", new Stocks(0, 3.0, Items.GRANITE));
            itemData.put("QUARTZ", new Stocks(0, 5.00, Items.QUARTZ));
            itemData.put("NETHER_QUARTZ_ORE", new Stocks(0, 10.0, Items.NETHER_QUARTZ_ORE));
            itemData.put("QUARTZ_BLOCK", new Stocks(0, 20.0, Items.QUARTZ_BLOCK));
            itemData.put("END_STONE", new Stocks(0, 50.0, Items.END_STONE));

            itemData.put("OAK_LOG", new Stocks(0, 1.0, Items.OAK_LOG));
            itemData.put("LEATHER", new Stocks(0, 2.50, Items.LEATHER));
            itemData.put("GOLDEN_APPLE", new Stocks(0, 50.0, Items.GOLDEN_APPLE));
            itemData.put("PACKED_ICE", new Stocks(0, 50.0, Items.PACKED_ICE));
            itemData.put("RED_SANDSTONE", new Stocks(0, 1.9, Items.RED_SANDSTONE));
            itemData.put("PRISMARINE_BRICKS", new Stocks(0, 6.0, Items.PRISMARINE_BRICKS));
            itemData.put("DARK_PRISMARINE", new Stocks(0, 25.0, Items.DARK_PRISMARINE));
            itemData.put("SEA_LATERN", new Stocks(0, 35.0, Items.SEA_LANTERN));
            itemData.put("SAND", new Stocks(0, 1.0, Items.SAND));
            itemData.put("SANDSTONE", new Stocks(0, 5.0, Items.SANDSTONE));
            itemData.put("GRAVEL", new Stocks(0, 1.0, Items.GRAVEL));
            itemData.put("STRING", new Stocks(0, 7500.0, Items.STRING));
            itemData.put("FLINT", new Stocks(0, 1.2, Items.FLINT));

            assignValues = 1;

            if (Minecraft.getInstance().player != null) {
                Minecraft.getInstance().player.sendMessage(new StringTextComponent("The values have been assigned."));
            }
        }
    }

    // * Speaks for itself, this is the inventory worth.
    public static double inventoryWorth = 0;

    // * Update the settings, so they will get applied.
    public static void updateValueSettings () {

        if (showCobblestoneAsStone) {
            itemData.get("COBBLESTONE").setItemPrice(itemData.get("STONE").getItemPrice());
        } else {
            itemData.get("COBBLESTONE").setItemPrice(0.1);
        }

        if (showCoalOreAsCoal) {
            if (showCoalAsCoalBlocks) {
                itemData.get("COAL_ORE").setItemPrice(2.22);
            } else {
                itemData.get("COAL_ORE").setItemPrice(itemData.get("COAL").getItemPrice());
            }
        } else {
            itemData.get("COAL").setItemPrice(2.22);
        }

        if (showLapisOreAsLapis) {
            itemData.get("LAPIS_ORE").setItemPrice(itemData.get("LAPIS_LAZULI").getItemPrice());
        } else {
            itemData.get("COBBLESTONE").setItemPrice(2.375);
        }
    }
}
