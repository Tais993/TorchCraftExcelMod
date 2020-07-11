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

    public static int locationTextX = 0;
    public static int locationTextY = 0;

    static void makeSettingsFile() throws IOException {
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
        myWriter.write("Location text X: 0\n");
        myWriter.write("Location text Y: 0\n");
        myWriter.write("Round numbers on 2 decimals: false\n");
        myWriter.write("Include your bal in the calculations: false");
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
            makeSettingsFile();
        } else if (!file2.exists()) {
            makeSettingsFile();
        }
    }

    public static void importSettings() throws IOException {
        String filePath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\TorchCraftExcelMod\\Settings\\settings.txt";
        File settingsFile = new File(filePath);

        FileReader fileReader = new FileReader(settingsFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int readState = 0;
        while (true) {
            System.out.println("Run: " + readState);
            if (readState == 11){
                break;
            }

            String[] line = bufferedReader.readLine().replaceAll(" ", "").split(":");

            switch (readState) {
                case 0:
                    // * How many ticks until updating
                    ticksUntilUpdate = Integer.parseInt(line[1]);
                    System.err.println("ticksToUpdate." + ticksUntilUpdate);
                    break;
                case 1:
                    // * Import the prices automatically
                    autoPricesImport = Boolean.parseBoolean(line[1]);
                    System.err.println("autoPricesImport." + autoPricesImport);
                    break;
                case 2:
                    // * Show cobblestone as stone
                    showCobblestoneAsStone = Boolean.parseBoolean(line[1]);
                    System.err.println("showCobblestoneAsStone." + showCobblestoneAsStone);
                    break;
                case 3:
                    // * Show coal as coal blocks
                    showCoalAsCoalBlocks = Boolean.parseBoolean(line[1]);
                    System.err.println("showCoalAsCoalBlocks." + showCoalAsCoalBlocks);
                    break;
                case 4:
                    // * show coal ore as coal
                    showCoalOreAsCoal = Boolean.parseBoolean(line[1]);
                    System.err.println("showCoalOreAsCoal." + showCoalOreAsCoal);
                    break;
                case 5:
                    // * show lapis ore as lapis
                    showLapisOreAsLapis = Boolean.parseBoolean(line[1]);
                    System.err.println("showLapisOreAsOre." + showLapisOreAsLapis);
                    break;
                case 6:
                    // * Show the text before the number GUI
                    showTextBeforeNumberGUI = Boolean.parseBoolean(line[1]);
                    System.err.println("showTextBeforeNumberGUI." + showTextBeforeNumberGUI);
                    break;
                case 7:
                    // * Location X coords of text / number
                    locationTextX = Integer.parseInt(line[1]);
                    System.err.println("locationTextX." + locationTextX);
                    break;
                case 8:
                    // * Location Y coords of text/number
                    locationTextY = Integer.parseInt(line[1]);
                    System.err.println("locationTextY." + locationTextY);
                    break;
                case 9:
                    // * Round numbers to 2 decimals.
                    roundNumbersOn2Decimals = Boolean.parseBoolean(line[1]);
                    System.err.println("roundNumbersOn2Decimals." + roundNumbersOn2Decimals);
                    break;
                case 10:
                    // * Include bal in top-left
                    includeBalInCalculations = Boolean.parseBoolean(line[1]);
                    System.err.println("includeBalInCalculations." + includeBalInCalculations);
                    break;
            }
            readState++;

            updateValueSettings();
        }
    }
}
