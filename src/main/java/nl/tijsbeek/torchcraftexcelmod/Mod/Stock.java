package nl.tijsbeek.torchcraftexcelmod.Mod;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.text.StringTextComponent;

import java.util.HashMap;

public class Stock {

    static public HashMap<String, Integer> itemAmountInventory = new HashMap<String, Integer>();
    static public HashMap<String, Double> itemPriceDataBase = new HashMap<String, Double>();
    static HashMap<String, Item> itemItems = new HashMap<String, Item>();

    static int assignValues = 0;

    static public int startCalculationsInt = 0;

    public static void main() {
        Minecraft.getInstance().player.sendMessage(new StringTextComponent("Main has been reached"));

        // * If the main is already run it won't override the old values
        if (assignValues != 1) {
            Minecraft.getInstance().player.sendMessage(new StringTextComponent("Assigning the values"));

            itemAmountInventory.put("STONE", 0);
            itemAmountInventory.put("GOLD_ORE", 0);
            itemAmountInventory.put("IRON_ORE", 1);
            itemAmountInventory.put("COAL_ORE", 0);
            itemAmountInventory.put("LAPIS_ORE", 0);
            itemAmountInventory.put("DIAMOND_ORE", 0);
            itemAmountInventory.put("EMERALD_ORE", 0);
            itemAmountInventory.put("DIORITE", 0);
            itemAmountInventory.put("ANDESITE", 0);
            itemAmountInventory.put("GRANITE", 0);
            itemAmountInventory.put("REDSTONE_ORE", 0);
            itemAmountInventory.put("PRISMARINE_BRICKS", 0);
            itemAmountInventory.put("DARK_PRISMARINE", 0);
            itemAmountInventory.put("NETHER_QUARTZ_ORE", 0);
            itemAmountInventory.put("SEA_LATERN", 0);
            itemAmountInventory.put("RED_SANDSTONE", 0);
            itemAmountInventory.put("SANDSTONE", 0);
            itemAmountInventory.put("GRAVEL", 0);
            itemAmountInventory.put("OAK_LOG", 0);
            itemAmountInventory.put("COAL_BLOCKS", 0);

            itemPriceDataBase.put("STONE", 1.1);
            itemPriceDataBase.put("GOLD_ORE", 16.406);
            itemPriceDataBase.put("IRON_ORE", 14.063);
            itemPriceDataBase.put("COAL_ORE", 4.0);
            itemPriceDataBase.put("LAPIS_ORE", 140.0);
            itemPriceDataBase.put("DIAMOND_ORE", 32.0);
            itemPriceDataBase.put("EMERALD_ORE", 24.0);
            itemPriceDataBase.put("DIORITE", 2.0);
            itemPriceDataBase.put("ANDESITE", 3.0);
            itemPriceDataBase.put("GRANITE", 3.0);
            itemPriceDataBase.put("REDSTONE_ORE_PRICE", 28.0);
            itemPriceDataBase.put("PRISMARINE_BRICKS", 25.0);
            itemPriceDataBase.put("DARK_PRISMARINE", 12.0);
            itemPriceDataBase.put("NETHER_QUARTZ_ORE", 5.0);
            itemPriceDataBase.put("SEA_LATERN", 35.0);
            itemPriceDataBase.put("RED_SANDSTONE", 6.0);
            itemPriceDataBase.put("SANDSTONE", 5.0);
            itemPriceDataBase.put("GRAVEL", 1.0);
            itemPriceDataBase.put("OAK_LOG", 1.0);
            itemPriceDataBase.put("COAL_BLOCKS", 19.0);

            itemItems.put("STONE", Items.STONE);
            itemItems.put("GOLD_ORE", Items.GOLD_ORE);
            itemItems.put("IRON_ORE", Items.IRON_ORE);
            itemItems.put("COAL_ORE", Items.COAL_ORE);
            itemItems.put("LAPIS_ORE", Items.LAPIS_ORE);
            itemItems.put("DIAMOND_ORE", Items.DIAMOND_ORE);
            itemItems.put("EMERALD_ORE", Items.EMERALD_ORE);
            itemItems.put("DIORITE", Items.DIORITE);
            itemItems.put("ANDESITE", Items.ANDESITE);
            itemItems.put("GRANITE", Items.GRANITE);
            itemItems.put("REDSTONE_ORE", Items.REDSTONE_ORE);
            itemItems.put("PRISMARINE_BRICKS", Items.PRISMARINE_BRICKS);
            itemItems.put("DARK_PRISMARINE", Items.DARK_PRISMARINE);
            itemItems.put("NETHER_QUARTZ_ORE", Items.NETHER_QUARTZ_ORE);
            itemItems.put("SEA_LANTERN", Items.SEA_LANTERN);
            itemItems.put("RED_SANDSTONE", Items.RED_SANDSTONE);
            itemItems.put("SANDSTONE", Items.SANDSTONE);
            itemItems.put("GRAVEL", Items.GRAVEL);
            itemItems.put("OAK_LOG", Items.OAK_LOG);
            itemItems.put("COAL_BLOCK", Items.COAL_BLOCK);

            assignValues = 1;
            Minecraft.getInstance().player.sendMessage(new StringTextComponent("The values have been assigned."));
        }
    }

    static double inventoryWorth = 0;

    public static double getInventoryWorth(){
        return inventoryWorth;
    }

    public static void CalculateInventoryWorth(){

        // * For every item it checks how many items of in your inventory are
        itemItems.forEach((key, value)-> {
            itemAmountInventory.replace(key, count(value));
        });

        // * How many items someone has * the price it's worth
        itemAmountInventory.forEach((key, value)-> {
            inventoryWorth += value * itemPriceDataBase.getOrDefault(key, 0.0);
        });

//        Minecraft.getInstance().player.sendMessage(new StringTextComponent("Total inventory worth :" + getInventoryWorth()));
    }

    // * Clear's all items that should be in his inv, if there're any errors
    public static void clearInventory(){
        itemItems.forEach((key, value)-> {
            itemAmountInventory.replace(key, 0);
        });
    }

    // * Counts the items in inventory
    public static int count(Item item) {
        return Minecraft.getInstance().player.inventory.count(item);
    }
}
