package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.states;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.states.FileSystemState;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.Image;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.Session;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.transformations.GrayscaleTransformation;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.transformations.Transformation;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.invoker.FileSystem;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.files.FileHelper;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.files.ImageHelper;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FileSystemOpenState implements FileSystemState {
    private Path file;
    private Session session;
    private Map<Integer,Session> sessionMap  = new HashMap<>();
    //private Set<Integer> sessionIds = new HashSet<>();
    int count = 1;

    @Override
    public void openFile(FileSystem fileSystem, Path filePath) {
        /*iterates all images*/
        //for(Path path : filePaths) {
        try {
            FileHelper fileHelper = new FileHelper();
            ImageHelper imageHelper = new ImageHelper();
            if(Files.notExists(filePath)){
                fileHelper.createFile(filePath);
            }



            /*creates new session with unique ID*/
            /*sessionIds.add(this.sessionIds.size());
            this.session = new Session(sessionIds.size());*/
            System.out.println("Session with ID " + count /*sessionIds.size()*/ + " started");
            this.session = new Session(count);
            count++;

            /*puts the new session into the map of sessions*/
            if (!sessionMap.containsKey(this.session.getId())) {
                sessionMap.put(session.getId(), this.session);
            }

            /*adds an image to the current session*/
            this.addImage(filePath);
            /*BufferedImage bufferedImage = imageHelper.read(filePath);
            Image image = new Image(bufferedImage,filePath.getFileName().toString());
            //System.out.println(image.getFileName());
            this.session.addImage(image);*/

            this.file = filePath;
            String file = fileHelper.read(filePath);

            //System.out.println("Successfully opened " + filePath.getFileName() + ", file content: ");
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
        Transformation transformation = new GrayscaleTransformation();
        this.session.addTransformation(transformation);
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
    public void addImage(Path filepath) {
        BufferedImage bufferedImage = null;
        try {
            ImageHelper imageHelper = new ImageHelper();
            bufferedImage = imageHelper.read(filepath);

            Image image = new Image(bufferedImage, filepath.getFileName().toString());
            this.session.addImage(image);
            System.out.println("Image \"" + filepath.getFileName() + "\" added");
        }catch(IOException e){
            System.out.println("Exception occurred: " + e);
        }
//        Image image = new Image(bufferedImage, filepath.toFile().toString());
//        this.session.addImage(image);
    }

    @Override
    public void sessionInfo() {
        //System.out.println(this.session.toString());
        System.out.println("Session ID: " + this.session.getId());
        System.out.println("Images in the session: " + this.session.getImages());
        System.out.println("Pending transformations: " + this.session.getTransformations());
    }

    @Override
    public void switchSession(int sessionId) {
        if (!sessionMap.containsKey(session.getId())) {
            System.out.println("There is no such session");
        }
        else {
            this.session = sessionMap.get(sessionId);
            //System.out.println("");
            System.out.println("You switched to a session with ID: " + this.sessionMap.get(sessionId).getId());
            System.out.println("Images in the session: " + this.session.getImages());
            System.out.println("Pending transformations: " + this.session.getTransformations());
        }
    }

    @Override
    public void collage() {

    }


}
