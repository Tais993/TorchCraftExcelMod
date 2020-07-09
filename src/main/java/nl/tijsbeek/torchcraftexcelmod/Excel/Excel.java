package nl.tijsbeek.torchcraftexcelmod.Excel;

import org.apache.commons.io.FileUtils;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.Scanner;

import static nl.tijsbeek.torchcraftexcelmod.Mod.Stock.*;

public class Excel{
    private static Scanner x;

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

            itemOrderedKeys.forEach((value) -> pw.print(itemData.get(value).getItemsInInventory()));
            pw.print(";" + inventoryWorth + ";");

        } catch (Exception e){
            System.err.println("Error" + e);
        }

        x.close();
        pw.flush();
        pw.close();
    }

    public static void importExcel() throws IOException {
        String filePath2 = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\TorchCraftExcelMod";
        System.out.println(filePath2);

        File file = new File(filePath2);

        if (!file.exists()) {
            file.mkdir();
            System.err.println("Directory should be made");
        }
        importPrice();
    }

    public static void importPrice() throws IOException {
        String filePathImport = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\TorchCraftExcelMod\\prices.csv";
        String row = null;

        System.err.println(filePathImport);

        File file = new File(filePathImport);

        System.err.println(file);


        if (!file.exists()) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        }

        FileReader fileReader = new FileReader(file);
        BufferedReader csvReader = new BufferedReader(fileReader);

        x = new Scanner(new File(filePathImport));
        x.useDelimiter("[,\n]");

        while (true) {
            try {
                if ((row = (csvReader.readLine())) == null) {
                    System.err.println("file was empty");
                    break;
                } else {
                    itemOrderedKeys.forEach((value) -> {
                        String line;
                        try {
                            if(((line = (csvReader.readLine())) != null)) {
                                itemData.get(value).setItemPrice( Double.parseDouble(line));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
                System.err.println("file wasn't empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        x.close();
        csvReader.close();
    }

    public static void makeFolder() {

    }
}