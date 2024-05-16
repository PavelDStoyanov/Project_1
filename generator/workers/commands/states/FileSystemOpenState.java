package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.states;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.states.FileSystemState;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.Image;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.Session;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.invoker.FileSystem;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.files.FileHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FileSystemOpenState implements FileSystemState {
    private Path file;
    private Session session;
    //private Map<Integer,Session> sessionMap  = new HashMap<>();

    @Override
    public void openFile(FileSystem fileSystem, Session session, Path filePath) {
        try {
            FileHelper fileHelper = new FileHelper();
            if(Files.notExists(filePath)){
                fileHelper.createFile(filePath);
            }

            this.session = session;

            this.file = filePath;
            String file = fileHelper.read(filePath);

            System.out.println("Successfully opened " + filePath + " , file content: ");
            System.out.println(file);
        }catch(IOException e){
            System.out.println("Exception occurred: " + e);
        }

        //System.out.println("A file is already open, close the file to open a new one");
    }

    @Override
    public void closeFile(FileSystem fileSystem) {
        this.file = null;

        this.session = null;

        fileSystem.setState(new FileSystemClosedState());
        System.out.println("Successfully closed the current file");

    }

    @Override
    public void saveFile(String input) {
        try {
            FileHelper fileHelper = new FileHelper();

            this.session.applyAllTransformations();

            fileHelper.write(this.file, input);
            System.out.println("Successfully saved the current file");
        }catch(IOException e){
            System.out.println("Exception occurred: " + e);
        }


    }

    @Override
    public void saveFileAs(Path filePath, String input) {
        try {
            FileHelper fileHelper = new FileHelper();
            if(Files.notExists(filePath)){
                fileHelper.createFile(filePath);
            }

            this.session.applyAllTransformations();

            fileHelper.write(filePath, input);
            System.out.println("Successfully saved the current file to another location");
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

    @Override
    public void grayscale() {
        //this.session.addTransformation();
    }

    @Override
    public void monochrome() {
        //this.session.addTransformation();
    }

    @Override
    public void negative() {
        //this.session.addTransformation();
    }

    @Override
    public void rotate() {
        //this.session.addTransformation();
    }

    @Override
    public void undo() {
        this.session.removeLastTransformation();
    }

    @Override
    public void addImage(Image image) {
        this.session.addImage(image);
    }

    @Override
    public void sessionInfo() {
        this.session.toString();
    }

    @Override
    public void switchSession() {

    }

    @Override
    public void collage() {

    }


}
