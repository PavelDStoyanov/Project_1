package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.states;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.states.FileSystemState;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.invoker.FileSystem;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.files.FileHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSystemOpenState implements FileSystemState {
    private Path file;


    @Override
    public void openFile(FileSystem fileSystem, Path filePath) {
        try {
            FileHelper fileHelper = new FileHelper();
            if(Files.notExists(filePath)){
                fileHelper.createDirectory(filePath);
            }
            this.file = filePath;
            String file = fileHelper.read(filePath);

            System.out.println("Successfully opened file.xml, file content: ");
            System.out.println(file);
        }catch(IOException e){
            System.out.println("Exception occurred: " + e);
        }

        //System.out.println("A file is already open, close the file to open a new one");
    }

    @Override
    public void closeFile(FileSystem fileSystem) {

        this.file = null;
        fileSystem.setState(new FileSystemClosedState());
        System.out.println("Successfully closed file.xml");

    }

    @Override
    public void saveFile(Path filePath, String input) {
        try {
            FileHelper fileHelper = new FileHelper();
            fileHelper.write(this.file, input);
            System.out.println("Successfully saved file.xml");
        }catch(IOException e){
            System.out.println("Exception occurred: " + e);
        }


    }

    @Override
    public void saveFileAs(Path filePath, String input) {
        try {
            FileHelper fileHelper = new FileHelper();
            if(Files.notExists(filePath)){
                fileHelper.createDirectory(filePath);
            }
            fileHelper.write(filePath, input);
            System.out.println("Successfully saved another file.xml");
        }catch(IOException e){
        System.out.println("Exception occurred: " + e);
    }

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
