package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.states;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.states.FileSystemState;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.files.FileHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSystemClosedState implements FileSystemState {
    private Path file;
    @Override
    public void openFile(Path filePath) {
//        try {
//            FileHelper fileHelper = new FileHelper();
//            if(Files.notExists(filePath)){
//                fileHelper.createDirectory(filePath);
//            }
//            this.file = filePath;
//            fileHelper.read(filePath);
//            System.out.println("Successfully opened file.xml");
//        }catch(IOException e){
//            System.out.println("Exception occurred: " + e);
//        }
        System.out.println("Op");
    }

    @Override
    public void closeFile() {
        System.out.println("A file should be opened first");
    }

    @Override
    public void saveFile(Path filePath, String input) {
        System.out.println("A file should be opened first");
    }

    @Override
    public void saveFileAs(Path filePath, String input) {
        System.out.println("A file should be opened first");
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
