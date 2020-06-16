package nl.tijsbeek.torchcraftexcelmod.Excel;


import java.io.*;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.commons.io.FileUtils;

import javax.swing.filechooser.FileSystemView;

public class Excel {

    void CopyingFile() throws IOException {

        File source = new File("src/main/resources/excel/template/torchcraft_prison.xlsx");
        File dest = new File(FileSystemView.getFileSystemView().getDefaultDirectory().getPath());

        FileUtils.copyFile(source, dest);
    }

    void main() throws IOException {

    }
}