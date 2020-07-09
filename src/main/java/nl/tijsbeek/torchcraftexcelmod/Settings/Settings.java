package nl.tijsbeek.torchcraftexcelmod.Settings;

import javax.swing.filechooser.FileSystemView;
import java.io.*;

public class Settings {
    public static int ticksToUpdate = 1;
    public static boolean autoPricesImport = false;

    static void makeSettingsFile() throws IOException {
        String filePath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\TorchCraftExcelMod\\Settings\\settings.txt";
        File settingsFile = new File(filePath);

        FileWriter myWriter = new FileWriter(settingsFile);

        myWriter.write("Ticks to update: 1 \n");
        myWriter.write("Auto prices import: true");
        myWriter.write("Show cobblestone as stone: false");
        myWriter.write("Show coal as coal blocks: false");
        myWriter.write("Show coal ore as coal: true");
        myWriter.close();
    }

    public static void settings() throws IOException {
        String filePath2 = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\TorchCraftExcelMod\\Settings";
        System.out.println(filePath2);

        File file = new File(filePath2);

        if (!file.exists()) {
            file.mkdir();
            System.err.println("Directory should be made");
            makeSettingsFile();
        }
    }

    public static void importSettings() throws IOException {
        String filePath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\TorchCraftExcelMod\\Settings\\settings.txt";
        File settingsFile = new File(filePath);

        FileReader fileReader = new FileReader(settingsFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // * How many ticks until updating the values

        String[] firstLine = bufferedReader.readLine().replaceAll(" ", "").split(":");

        System.err.println("READING SETTINGS FILE");
        System.out.println(firstLine[0]);
        System.out.println(firstLine[1]);

        ticksToUpdate = Integer.parseInt(firstLine[1]);
        System.err.println("ticksToUpdate." + ticksToUpdate);

        // * On startup, import prices?

        String[] secondLine = bufferedReader.readLine().replaceAll(" ", "").split(":");

        System.err.println("READING SETTINGS FILE");
        System.out.println(secondLine[0]);
        System.out.println(secondLine[1]);

        autoPricesImport = Boolean.parseBoolean(secondLine[1]);
        System.err.println("autoPricesImport." + autoPricesImport);
    }
}
