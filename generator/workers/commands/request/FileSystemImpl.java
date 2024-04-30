package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.request;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.FileSystem;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.files.FileHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSystemImpl implements FileSystem {


    @Override
    public void openFile(Path filePath, String input) {
        try {
            FileHelper fileHelper = new FileHelper();
            if(Files.notExists(filePath)){
                fileHelper.createDirectory(filePath);
            }
            fileHelper.read(filePath);
            System.out.println("Successfully opened file.xml");
        }catch(IOException e){
            System.out.println("Exception ocured: " + e);
        }

    }

    @Override
    public void closeFile() {
        System.out.println("Successfully closed file.xml");

    }

    @Override
    public void saveFile(Path filePath, String input) {
        try {
            FileHelper fileHelper = new FileHelper();
            if(Files.notExists(filePath)){
                fileHelper.createDirectory(filePath);
            }
            fileHelper.write(input);
            System.out.println("Successfully saved file.xml");
        }catch(IOException e){
            System.out.println("Exception ocured: " + e);
        }

    }

    @Override
    public void saveFileAs() {
        System.out.println("Successfully saved another file.xml");
    }

    @Override
    public void help() {
        System.out.println("The following commands are supported: \n" +
                "open <file>    opens file \n" +
                "close          closes currently opened file \n" +
                "save           saves the currently open file \n" +
                "saveas <file>  saves the currently open file in <file> \n" +
                "help           prints this information \n" +
                "exit           exists the program \n");
    }

    @Override
    public void exit() {
        System.out.println("Exiting the program...");
    }


}
