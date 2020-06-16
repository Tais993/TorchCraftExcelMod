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

    static public int assignValues = 0;

    static public int startCalculationsInt = 0;

    public static void main(int i) {
        Minecraft.getInstance().player.sendMessage(new StringTextComponent("Main has been reached"));

        // * If the main is already run it won't override the old values
        if (assignValues != 1) {
            Minecraft.getInstance().player.sendMessage(new StringTextComponent("Assigning the values"));

            // * Assign's how many times the specified item is inside the inventory (default is 0
            // ! Add a GUI or a import from excel function

            if(i == 1){
                itemAmountInventory.put("GRAVEL", 0);
                itemAmountInventory.put("FLINT", 0);
            }

            itemAmountInventory.put("STONE", 0);
            itemAmountInventory.put("COBBLESTONE", 0);
            itemAmountInventory.put("DIORITE", 0);
            itemAmountInventory.put("ANDESITE", 0);
            itemAmountInventory.put("GRANITE", 0);

            itemAmountInventory.put("DIAMOND", 0);
            itemAmountInventory.put("LAPIS", 0);
            itemAmountInventory.put("EMERALD", 0);
            itemAmountInventory.put("REDSTONE", 0);
            itemAmountInventory.put("GOLD", 0);
            itemAmountInventory.put("IRON", 0);
            itemAmountInventory.put("COAL", 0);

            itemAmountInventory.put("DIAMOND_ORE", 0);
            itemAmountInventory.put("LAPIS_ORE", 0);
            itemAmountInventory.put("EMERALD_ORE", 0);
            itemAmountInventory.put("REDSTONE_ORE", 0);
            itemAmountInventory.put("GOLD_ORE", 0);
            itemAmountInventory.put("IRON_ORE", 0);
            itemAmountInventory.put("COAL_ORE", 0);

            itemAmountInventory.put("DIAMOND_BLOCK", 0);
            itemAmountInventory.put("LAPIS_BLOCK", 0);
            itemAmountInventory.put("EMERALD_BLOCK", 0);
            itemAmountInventory.put("REDSTONE_BLOCK", 0);
            itemAmountInventory.put("GOLD_BLOCK", 0);
            itemAmountInventory.put("IRON_BLOCK", 0);
            itemAmountInventory.put("COAL_BLOCK", 0);

            itemAmountInventory.put("PRISMARINE_BRICKS", 0);
            itemAmountInventory.put("DARK_PRISMARINE", 0);
            itemAmountInventory.put("QUARTZ", 0);
            itemAmountInventory.put("NETHER_QUARTZ_ORE", 0);
            itemAmountInventory.put("QUARTZ_BLOCK", 0);
            itemAmountInventory.put("SEA_LATERN", 0);
            itemAmountInventory.put("RED_SANDSTONE", 0);
            itemAmountInventory.put("SANDSTONE", 0);
            itemAmountInventory.put("GRAVEL", 0);
            itemAmountInventory.put("OAK_LOG", 0);

            // * Set's the prices of the products

            // * 0 for normal
            // * 1 for EGS

            if(i == 1){
                itemPriceDataBase.put("STONE", 3.90625);
                itemPriceDataBase.put("COBBLESTONE", 0.78125);
                itemPriceDataBase.put("GRAVEL", 1.5625);
                itemPriceDataBase.put("FLINT", 2.734375);
                itemPriceDataBase.put("COAL", 1.953125);
            } else {
                itemPriceDataBase.put("COAL", 2.375);
                itemPriceDataBase.put("STONE", 1.1);
                itemPriceDataBase.put("COBBLESTONE", 0.1);
            }

            itemPriceDataBase.put("DIORITE", 2.0);
            itemPriceDataBase.put("ANDESITE", 3.0);
            itemPriceDataBase.put("GRANITE", 3.0);
            itemPriceDataBase.put("DIAMOND", 17.0);
            itemPriceDataBase.put("LAPIS", 18.0);
            itemPriceDataBase.put("EMERALD", 12.0);
            itemPriceDataBase.put("REDSTONE", 14.0);
            itemPriceDataBase.put("GOLD", 12.0);
            itemPriceDataBase.put("IRON", 7.0);

            itemPriceDataBase.put("DIAMOND_ORE", 32.0);
            itemPriceDataBase.put("LAPIS_ORE", 140.0);
            itemPriceDataBase.put("EMERALD_ORE", 24.0);
            itemPriceDataBase.put("REDSTONE_ORE", 28.0);
            itemPriceDataBase.put("GOLD_ORE", 16.406);
            itemPriceDataBase.put("IRON_ORE", 14.063);
            itemPriceDataBase.put("COAL_ORE", 4.0);

            itemPriceDataBase.put("DIAMOND_BLOCK", 149.0);
            itemPriceDataBase.put("LAPIS_BLOCK", 168.0);
            itemPriceDataBase.put("EMERALD_BLOCK", 111.0);
            itemPriceDataBase.put("REDSTONE_BLOCK", 130.0);
            itemPriceDataBase.put("GOLD_BLOCK", 92.0);
            itemPriceDataBase.put("IRON_BLOCK", 55.0);
            itemPriceDataBase.put("COAL_BLOCK", 20.0);

            itemPriceDataBase.put("PRISMARINE_BRICKS", 25.0);
            itemPriceDataBase.put("DARK_PRISMARINE", 12.0);
            itemPriceDataBase.put("QUARTZ", 5.0);
            itemPriceDataBase.put("NETHER_QUARTZ_ORE", 10.0);
            itemPriceDataBase.put("QUARTZ_BLOCK", 20.0);
            itemPriceDataBase.put("SEA_LATERN", 35.0);
            itemPriceDataBase.put("RED_SANDSTONE", 6.0);
            itemPriceDataBase.put("SANDSTONE", 5.0);
            itemPriceDataBase.put("GRAVEL", 1.0);
            itemPriceDataBase.put("OAK_LOG", 1.0);

            // * Set's the item
            if(i == 1) {
                itemItems.put("GRAVEL", Items.GRAVEL);
                itemItems.put("FLINT", Items.FLINT);
            }

            itemItems.put("STONE", Items.STONE);
            itemItems.put("COBBLESTONE", Items.COBBLESTONE);
            itemItems.put("DIORITE", Items.DIORITE);
            itemItems.put("ANDESITE", Items.ANDESITE);
            itemItems.put("GRANITE", Items.GRANITE);

            itemItems.put("DIAMOND", Items.DIAMOND);
            itemItems.put("LAPIS", Items.LAPIS_LAZULI);
            itemItems.put("EMERALD", Items.EMERALD);
            itemItems.put("REDSTONE", Items.REDSTONE);
            itemItems.put("GOLD", Items.GOLD_INGOT);
            itemItems.put("IRON", Items.IRON_INGOT);
            itemItems.put("COAL", Items.COAL);

            itemItems.put("DIAMOND_ORE", Items.DIAMOND_ORE);
            itemItems.put("LAPIS_ORE", Items.LAPIS_ORE);
            itemItems.put("EMERALD_ORE", Items.EMERALD_ORE);
            itemItems.put("REDSTONE_ORE", Items.REDSTONE_ORE);
            itemItems.put("GOLD_ORE", Items.GOLD_ORE);
            itemItems.put("IRON_ORE", Items.IRON_ORE);
            itemItems.put("COAL_ORE", Items.COAL_ORE);

            itemItems.put("DIAMOND_BLOCK", Items.DIAMOND_BLOCK);
            itemItems.put("LAPIS_BLOCK", Items.LAPIS_BLOCK);
            itemItems.put("EMERALD_BLOCK", Items.EMERALD_BLOCK);
            itemItems.put("REDSTONE_BLOCK", Items.REDSTONE_BLOCK);
            itemItems.put("GOLD_BLOCK", Items.GOLD_BLOCK);
            itemItems.put("IRON_BLOCK", Items.IRON_BLOCK);
            itemItems.put("COAL_BLOCK", Items.COAL_BLOCK);

            itemItems.put("PRISMARINE_BRICKS", Items.PRISMARINE_BRICKS);
            itemItems.put("DARK_PRISMARINE", Items.DARK_PRISMARINE);
            itemItems.put("QUARTZ", Items.QUARTZ);
            itemItems.put("NETHER_QUARTZ_ORE", Items.NETHER_QUARTZ_ORE);
            itemItems.put("QUARTZ_BLOCK", Items.QUARTZ_BLOCK);
            itemItems.put("SEA_LANTERN", Items.SEA_LANTERN);
            itemItems.put("RED_SANDSTONE", Items.RED_SANDSTONE);
            itemItems.put("SANDSTONE", Items.SANDSTONE);
            itemItems.put("GRAVEL", Items.GRAVEL);
            itemItems.put("OAK_LOG", Items.OAK_LOG);

            assignValues = 1;
            Minecraft.getInstance().player.sendMessage(new StringTextComponent("The values have been assigned."));
        }
    }

    static double inventoryWorth = 0;

    public static double getInventoryWorth(){
        return inventoryWorth;
    }

    public static void CalculateInventoryWorth(){
        inventoryWorth = 0;
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
        inventoryWorth = 0;
    }

    // * Counts the items in inventory
    public static int count(Item item) {
        return Minecraft.getInstance().player.inventory.count(item);
    }
}
