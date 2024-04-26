package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.request;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.FileSystem;

import java.io.File;

public class FileSystemImpl implements FileSystem {


    @Override
    public void openFile(File file, String input) {
        System.out.println("Successfully opened file.xml");
    }

    @Override
    public void closeFile() {
        System.out.println("Successfully closed file.xml");

    }

    @Override
    public void saveFile() {
        System.out.println("Successfully saved file.xml");
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
