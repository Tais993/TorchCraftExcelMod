package nl.tijsbeek.torchcraftexcelmod.Mod;

import net.minecraft.item.Item;
import nl.tijsbeek.torchcraftexcelmod.event.ChatEvent;

public class Stock {

    ChatEvent chatEvent = new ChatEvent();

    public Item item = null;

    public int stone = 0;
    public int gold_ore = 0;
    public int iron_ore = 0;
    public int coal_ore = 0;
    public int lapis_ore = 0;
    public int diamond_ore = 0;
    public int emerald_ore = 0;
    public int diorite = 0;
    public int andesite = 0;
    public int granite = 0;
    public int redstone_ore = 0;
    public int prismarine_bricks = 0;
    public int dark_prismarine = 0;
    public int nether_quartz_ore = 0;
    public int sea_latern = 0;
    public int red_sandstone = 0;
    public int sandstone = 0;
    public int gravel = 0;
    public int oak_log = 0;
    public int coal_blocks = 0;

    double stonePrice = 1.1;
    double gold_ore_price = 16.406;
    double iron_ore_price = 14.063;
    double coal_ore_price = 4;
    double lapis_ore_price = 140;
    double diamond_ore_price = 32;
    double emerald_ore_price = 24;
    double diorite_price = 2;
    double andesite_price = 3;
    double granite_price = 3;
    double redstone_ore_price = 28;
    double prismarine_bricks_price = 25;
    double dark_prismarine_price = 12;
    double nether_quartz_ore_price = 5;
    double sea_latern_price = 35;
    double red_sandstone_price = 6;
    double sandstone_price = 5;
    double gravel_price = 1;
    double oak_log_price = 1;
    double coal_blocks_price = 19;

    public double inventoryWorth = 0;

    void CalculateInventoryWorth(){
        inventoryWorth = (stone * stonePrice) + (gold_ore * gold_ore_price) + (iron_ore * iron_ore_price) + (coal_ore * coal_ore_price) + (lapis_ore * lapis_ore_price) + (diamond_ore * diamond_ore_price) + (emerald_ore * emerald_ore_price) + (diorite * diorite_price) + (andesite * andesite_price) + (granite * granite_price) + (redstone_ore * redstone_ore_price) + (prismarine_bricks * prismarine_bricks_price) + (dark_prismarine * dark_prismarine_price) + (nether_quartz_ore * nether_quartz_ore_price) + (sea_latern * sea_latern_price) + (red_sandstone * red_sandstone_price) + (sandstone * sandstone_price) + (gravel * gravel_price) + (oak_log * oak_log_price) + (coal_blocks * coal_blocks_price);
        chatEvent.sendMessage("Total inventory worth :" + inventoryWorth);
    }
}
