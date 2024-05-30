package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.states;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.states.FileSystemState;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.Direction;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.Image;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.Session;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.invoker.FileSystem;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.files.FileHelper;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSystemClosedState implements FileSystemState {

    @Override
    public void openFile(FileSystem fileSystem, Path filePath) {
        FileSystemOpenState fileSystemOpenState = new FileSystemOpenState();
        fileSystemOpenState.openFile(fileSystem, filePath);
        fileSystem.setState(fileSystemOpenState);
    }

    @Override
    public void closeFile(FileSystem fileSystem) {
        System.out.println("A file should be opened first");

    }

    @Override
    public void saveFile(String input) {
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



    @Override
    public void grayscale() {
        System.out.println("A file should be opened first");
    }

    @Override
    public void monochrome() {
        System.out.println("A file should be opened first");
    }

    @Override
    public void negative() {
        System.out.println("A file should be opened first");
    }

    @Override
    public void rotate(Direction direction) {
        System.out.println("A file should be opened first");
    }

    @Override
    public void undo() {
        System.out.println("A file should be opened first");
    }

    @Override
    public void addImage(Path filepath) {
        System.out.println("A file should be opened first");
    }

    @Override
    public void sessionInfo() {
        System.out.println("A file should be opened first");
    }

    @Override
    public void switchSession(int sessionId) {
        System.out.println("A file should be opened first");
    }

    @Override
    public void collage(Path filePath) {
        System.out.println("A file should be opened first");
    }


}
