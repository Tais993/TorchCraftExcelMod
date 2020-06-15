package nl.tijsbeek.torchcraftexcelmod.Mod;

import net.minecraft.item.Item;
import nl.tijsbeek.torchcraftexcelmod.Event.ChatEvent;

import java.util.HashMap;
import java.util.Map;

public class Stock {

    HashMap<String, Integer> itemAmountInventory = new HashMap<String, Integer>();
    HashMap<String, Double> itemPriceDataBase = new HashMap<String, Double>();
    HashMap<String, Integer> itemKey = new HashMap<String, Integer>();

    ChatEvent chatEvent = new ChatEvent();

    public Item item = null;

    public void main(String[] args) {
        itemAmountInventory.put("STONE", 0);
        itemAmountInventory.put("GOLD_ORE", 0);
        itemAmountInventory.put("IRON_ORE", 0);
        itemAmountInventory.put("COAL_ORE", 0);
        itemAmountInventory.put("LAPIS_ORE", 0);
        itemAmountInventory.put("DIAMOND_ORE", 0);
        itemAmountInventory.put("EMERALD_ORE", 0);
        itemAmountInventory.put("DIORITE", 0);
        itemAmountInventory.put("andesite", 0);
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

        /*
        itemKey.put("STONE", 1.1);
        itemKey.put("GOLD_ORE", 16.406);
        itemKey.put("IRON_ORE", 14.063);
        itemKey.put("COAL_ORE", 4.0);
        itemKey.put("LAPIS_ORE", 140.0);
        itemKey.put("DIAMOND_ORE", 32.0);
        itemKey.put("EMERALD_ORE", 24.0);
        itemKey.put("DIORITE", 2.0);
        itemKey.put("ANDESITE", 3.0);
        itemKey.put("GRANITE", 3.0);
        itemKey.put("REDSTONE_ORE_PRICE", 28.0);
        itemKey.put("PRISMARINE_BRICKS", 25.0);
        itemKey.put("DARK_PRISMARINE", 12.0);
        itemKey.put("NETHER_QUARTZ_ORE", 5.0);
        itemKey.put("SEA_LATERN", 35.0);
        itemKey.put("RED_SANDSTONE", 6.0);
        itemKey.put("SANDSTONE", 5.0);
        itemKey.put("GRAVEL", 1.0);
        itemKey.put("OAK_LOG", 1.0);
        itemKey.put("COAL_BLOCKS", 19.0); */
    }

    double inventoryWorth = 0;

    public double getInventoryWorth(){
        return inventoryWorth;
    }

    public

    void CalculateInventoryWorth(){

        for (Map.Entry<String, Integer> entry : itemAmountInventory.entrySet()){
            String key = entry.getKey();
            int value = entry.getValue();
            inventoryWorth += value * itemPriceDataBase.get(key);
        }

        chatEvent.sendMessage("Total inventory worth :" + getInventoryWorth());
    }
}
