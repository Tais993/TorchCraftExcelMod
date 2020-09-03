package nl.tijsbeek.sellcount.Mod;

import net.minecraft.client.Minecraft;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.util.text.StringTextComponent;

import java.util.List;

import static nl.tijsbeek.sellcount.Mod.Stock.*;
import static nl.tijsbeek.sellcount.Settings.Settings.includeBalInCalculations;

public class CalculateTotalWorth {

    public static void CountInventory() {
        // * It checks how many items of every item there are in your inventory
        itemOrderedKeys.forEach((value) -> itemData.get(value).setItemsInInventory(count(itemData.get(value).getItem())));
    }

    public static void CountChest() {

        List<Slot> inventorySlots = Minecraft.getInstance().player.openContainer.inventorySlots;

        int sizeInventory = 0;

        Minecraft.getInstance().player.sendMessage(new StringTextComponent("Inventory size: " + inventorySlots.size()));

        if (inventorySlots.size() == 90) sizeInventory = 54;
        if (inventorySlots.size() == 63) sizeInventory = 27;

        int finalSizeInventory = sizeInventory;

        itemOrderedKeys.forEach((value) -> {
            Item item = itemData.get(value).getItem();

            int itemsFound = 0;

            for (int i = 0; i != finalSizeInventory; i++) {
                if (inventorySlots.get(i).getStack().getItem() == item)
                    itemsFound += inventorySlots.get(i).getStack().getCount();
                System.out.println(itemsFound + " found of " + itemData.get(value).getItem());
            }

            itemData.get(value).addsItemsInChests(itemsFound);
        });
    }

    public static void CalculateInventoryWorth() {
        inventoryWorth = 0;

        if (includeBalInCalculations) inventoryWorth = balWorth;

        // * How many items someone has * the price it's worth
        itemOrderedKeys.forEach((value) -> inventoryWorth += itemData.get(value).getItemsInInventory() * itemData.get(value).getItemPrice());

        // * How many items someone has * the price it's worth
        itemOrderedKeys.forEach((value) -> inventoryWorth += itemData.get(value).getItemsInChests() * itemData.get(value).getItemPrice());
    }

    // * Counts the items in inventory
    public static int count(Item item) {
        if (Minecraft.getInstance().player != null) {
            return Minecraft.getInstance().player.inventory.count(item);
        }
        return 0;
    }


    // * Clear's all items that should be in his inv, if there're any errors
    public static void clearInventory() {
        itemOrderedKeys.forEach((value) -> itemData.get(value).setItemsInInventory(0));
        inventoryWorth = 0;
    }
}
