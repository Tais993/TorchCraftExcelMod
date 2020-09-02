package nl.tijsbeek.torchcraftexcelmod.Settings;

import javax.swing.filechooser.FileSystemView;
import java.io.*;

import static nl.tijsbeek.torchcraftexcelmod.Mod.Stock.updateValueSettings;

public class Settings {

    public static int ticksUntilUpdate = 1;
    public static boolean autoPricesImport = false;
    public static boolean showCobblestoneAsStone = false;
    public static boolean showCoalAsCoalBlocks = false;
    public static boolean showCoalOreAsCoal = false;
    public static boolean showLapisOreAsLapis = false;
    public static boolean showTextBeforeNumberGUI = true;
    public static boolean roundNumbersOn2Decimals = false;
    public static boolean includeBalInCalculations = false;
    public static boolean includeChestsInCalculations = false;

    public static int locationInventoryWorthX = 0;
    public static int locationInventoryWorthY = 0;

    public static int locationChestOpenedX = 0;
    public static int locationChestOpenedY = 0;

    static void createSettingsFile() throws IOException {
        String filePath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\TorchCraftExcelMod\\Settings\\settings.txt";
        File settingsFile = new File(filePath);

        FileWriter myWriter = new FileWriter(settingsFile);

        myWriter.write("Ticks until update: 1 \n");
        myWriter.write("Auto prices import: true \n");
        myWriter.write("Show cobblestone as stone: false\n");
        myWriter.write("Show coal as coal blocks: false\n");
        myWriter.write("Show coal ore as coal: false\n");
        myWriter.write("Show lapis ore as lapis: false\n");
        myWriter.write("Show text before number (top left screen): true\n");
        myWriter.write("Location inventory worth X: 0\n");
        myWriter.write("Location inventory worth Y: 0\n");
        myWriter.write("Location chest opened X: 0\n");
        myWriter.write("Location chest opened Y: 0\n");
        myWriter.write("Round numbers on 2 decimals: false\n");
        myWriter.write("Include your bal in the calculations: false\n");
        myWriter.write("Include chests in the calculations: false");
        myWriter.close();
    }

    public static void settings() throws IOException {
        String filePath1 = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\TorchCraftExcelMod\\Settings";
        System.out.println(filePath1);
        File file1 = new File(filePath1);


        String filePath2 = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\TorchCraftExcelMod\\Settings\\settings.txt";
        File file2 = new File(filePath2);

        if (!file1.exists()) {
            file1.mkdir();
            System.err.println("Directory should be made");
            createSettingsFile();
        } else if (!file2.exists()) {
            createSettingsFile();
        }
    }

    public static void importSettings() throws IOException {
        String filePath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\TorchCraftExcelMod\\Settings\\settings.txt";
        File settingsFile = new File(filePath);

        FileReader fileReader = new FileReader(settingsFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (true) {
            if (bufferedReader.readLine().isEmpty()) return;
            // ! Order fixed, it keeps reading until the next row is empty.

            String[] line = bufferedReader.readLine().replaceAll(" ", "").split(":");

            switch (line[0]) {
                case "Ticksuntilupdate":
                    // * How many ticks until updating
                    ticksUntilUpdate = Integer.parseInt(line[1]);
                    System.err.println("ticksToUpdate." + ticksUntilUpdate);
                    break;
                case "Autopricesimport":
                    // * Import the prices automatically
                    autoPricesImport = Boolean.parseBoolean(line[1]);
                    System.err.println("autoPricesImport." + autoPricesImport);
                    break;
                case "Showcobblestoneasstone":
                    // * Show cobblestone as stone
                    showCobblestoneAsStone = Boolean.parseBoolean(line[1]);
                    System.err.println("showCobblestoneAsStone." + showCobblestoneAsStone);
                    break;
                case "Showcoalascoalblocks":
                    // * Show coal as coal blocks
                    showCoalAsCoalBlocks = Boolean.parseBoolean(line[1]);
                    System.err.println("showCoalAsCoalBlocks." + showCoalAsCoalBlocks);
                    break;
                case "Showcoaloreascoal":
                    // * show coal ore as coal
                    showCoalOreAsCoal = Boolean.parseBoolean(line[1]);
                    System.err.println("showCoalOreAsCoal." + showCoalOreAsCoal);
                    break;
                case "Showlapisoreaslapis":
                    // * show lapis ore as lapis
                    showLapisOreAsLapis = Boolean.parseBoolean(line[1]);
                    System.err.println("showLapisOreAsOre." + showLapisOreAsLapis);
                    break;
                case "Showtextbeforenumber(topleftscreen)":
                    // * Show the text before the number GUI
                    showTextBeforeNumberGUI = Boolean.parseBoolean(line[1]);
                    System.err.println("showTextBeforeNumberGUI." + showTextBeforeNumberGUI);
                    break;
                case "LocationinventoryworthX":
                    // * Location X coords of inventory worth
                    locationInventoryWorthX = Integer.parseInt(line[1]);
                    System.err.println("locationInventoryWorthX." + locationInventoryWorthX);
                    break;
                case "LocationinventoryworthY":
                    // * Location Y coords of inventory worth
                    locationInventoryWorthY = Integer.parseInt(line[1]);
                    System.err.println("locationInventoryWorthX." + locationInventoryWorthY);
                    break;
                case "LocationchestopenedX":
                    // * Location X coords of chest opened GUI
                    locationChestOpenedX = Integer.parseInt(line[1]);
                    System.err.println("locationChestOpenedX." + locationChestOpenedX);
                    break;
                case "LocationchestopenedY":
                    // * Location Y coords of chest opened GUI
                    locationChestOpenedY = Integer.parseInt(line[1]);
                    System.err.println("locationChestOpenedY." + locationChestOpenedY);
                    break;
                case "Roundnumberson2decimals":
                    // * Round numbers to 2 decimals.
                    roundNumbersOn2Decimals = Boolean.parseBoolean(line[1]);
                    System.err.println("roundNumbersOn2Decimals." + roundNumbersOn2Decimals);
                    break;
                case "Includeyourbalinthecalculations":
                    // * Include bal in top-left
                    includeBalInCalculations = Boolean.parseBoolean(line[1]);
                    System.err.println("includeBalInCalculations." + includeBalInCalculations);
                    break;
                case "Includechestsinthecalculations":
                    // * Include chests in calculations
                    includeChestsInCalculations = Boolean.parseBoolean(line[1]);
                    System.err.println("includeChestsInCalculations." + includeChestsInCalculations);
                    break;
            }
            updateValueSettings();
        }
    }
}
