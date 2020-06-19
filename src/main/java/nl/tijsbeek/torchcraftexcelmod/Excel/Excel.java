package nl.tijsbeek.torchcraftexcelmod.Excel;

import org.apache.commons.io.FileUtils;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import static nl.tijsbeek.torchcraftexcelmod.Mod.Stock.*;

public class Excel{
    private static Scanner x;


    // ! Export function is broken, hashmaps are random? Will look for a different method. (Maybe arrays?
    // ! Export function isn't well coded, will get revamped!

    public static void excelExport() throws IOException {
        String filePath2 = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\TorchCraftExcelMod";
        System.out.println(filePath2);

        File file = new File(filePath2);

        if (!file.exists()) {
            file.mkdir();
            System.err.println("Directory should be made");
        }
        editRecord();
    }

    public static void editRecord() throws IOException {
        File sourceTemplate = new File(FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\TorchCraftExcelMod\\template.csv");
        String filePath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\TorchCraftExcelMod\\output.csv";
        File copyTemplate = new File(filePath);

        System.err.println(filePath);
        File csvFile = new File(filePath);

        FileUtils.copyFile(sourceTemplate, copyTemplate);
        System.err.println("Copy should be done.");

        FileWriter fw = new FileWriter(filePath, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        x = new Scanner(new File(filePath));
        x.useDelimiter("[,\n]");

        x.nextLine();

        try {

            itemOrderedKeys.forEach((value) -> {
                pw.print(itemAmountInventory.get(value) + " " + value + " ;");
            });
            pw.print(";" + getInventoryWorth() + ";");

            pw.println(itemAmountInventory.size());

        } catch (Exception e){
            System.err.println("Error" + e);
        }

        x.close();
        pw.flush();
        pw.close();
    }

    // ! This is important, if this is done I can start rolling the mod out to others.

    public static void importExcel(){

    }
}