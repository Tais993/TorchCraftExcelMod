package nl.tijsbeek.sellcount.Mod;

import net.minecraft.item.Item;

public class Stocks {
    // * Defines the variables of the object
    int itemsInInventory;
    int itemsInChests;
    double itemPrice;
    Item item;

    // * When someone makes a new "Stocks" object, they'll have to give the Item

    public Stocks(int itemsInInventoryGiven, double itemPriceGiven, Item itemGiven) {
        this.itemsInInventory = itemsInInventoryGiven;
        this.itemsInChests = 0;
        this.itemPrice = itemPriceGiven;
        this.item = itemGiven;
    }

    // * This function sets the Items in inventory.

    public void setItemsInInventory(int itemsInInventoryGiven) {
        this.itemsInInventory = itemsInInventoryGiven;
    }

    // * This functions sets the item amount in chests

    public void setItemsInChests(int ItemsInChestGiven) {
        this.itemsInChests = ItemsInChestGiven;
    }

    // * This functions adds the item amount in chests

    public void addsItemsInChests(int ItemsInChestGiven) {
        this.itemsInChests = this.itemsInChests + ItemsInChestGiven;
    }

    // * This functions clears the item amount in chests

    public void clearsItemsInChests() {
        this.itemsInChests = 0;
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

    // * This functions gets how many items are in all chests

    public int getItemsInChests() {
        return this.itemsInChests;
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
