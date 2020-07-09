package nl.tijsbeek.torchcraftexcelmod.Mod;

import net.minecraft.item.Item;

public class Stocks {
    // * Defines the variables of the object
    int itemsInInventory;
    double itemPrice;
    Item item;

    // * When someone makes a new "Stocks" object, they'll have to give the Item

    public Stocks (int itemsInInventoryGiven, double itemPriceGiven, Item itemGiven) {
        this.itemsInInventory = itemsInInventoryGiven;
        this.itemPrice = itemPriceGiven;
        this.item = itemGiven;
    }

    // * This function sets the Items in inventory.
    // * Why this.itemsInInvetory?
    // * Because it's a object, for every block I want the value to be different.

    public void setItemsInInventory(int itemsInInventoryGiven) {
        this.itemsInInventory = itemsInInventoryGiven;
    }

    // * This function sets the item price.

    public void setItemPrice(double itemPriceGiven) {
        this.itemPrice = itemPriceGiven;
    }

    // * This function sets the Item. Never being used, but still have it.

    public void setItem(Item itemGiven) {
        this.item = itemGiven;
    }

    // * This function gets how many items of a item are in the user's inventory

    public int getItemsInInventory() {
        return this.itemsInInventory;
    }

    // * This function gets the price of the item

    public double getItemPrice() {
        return this.itemPrice;
    }

    // * This function get's the item, never being used but still.

    public Item getItem() {
        return this.item;
    }
}
