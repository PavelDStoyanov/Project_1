package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.states;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.states.FileSystemState;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.Direction;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.Image;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.Session;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.transformations.*;
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
                //System.out.println("The file doesn't exist");
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

            /*String file = fileHelper.read(filePath);
            //System.out.println(file);
            Image image = new Image(bufferedImage,filePath,file);*/

            /*int x, y, z = 0;

            //String[] inputs = file.split(" ");
            String[] fileLines = file.split("\r\n");

            //String dimensions = file.substring(0,3);
            String image = file.substring(5,file.length());
            String[] imageLines = image.split("\r\n");
            //String[] imageArray = image.split(" ");

            //int[] intImageArray = new int[imageArray.length];
            //String[] dimensionsArray = dimensions.split(" ");
            String[] dimensionsArray = fileLines[0].split(" ");
            //System.out.println(image);
//            for(int i = 0; i < fileLines.length; i++){
//                intImageArray[i] = Integer.parseInt(imageArray[i]);
//                System.out.println(intImageArray[i]);
//
//            }
            //System.out.println(dimensions);
            x = Integer.parseInt(dimensionsArray[0]);
            y = Integer.parseInt(dimensionsArray[1]);
            System.out.println(x);
            System.out.println(y);
            String[][] stringMatrix = new String[y][x];
            int[][] intMatrix = new int[y][x];

           for (int i = 0; i < y; i++) {
                // length returns number of rows
                String[] line = imageLines[i].split(" ");
                z = 0;
                //System.out.print("row " + i + " : ");
                for (int j = 0; j < x; j++) {

                    // here length returns # of columns corresponding to current row
                    stringMatrix[i][j] = line[z];
                    z++;
                    intMatrix[i][j] = Integer.parseInt(stringMatrix[i][j]);
                    //System.out.print("col " + j + "  ");
                }
            }*/

            //y = Integer.parseInt(inputs[1]);
            //System.out.println(x);
            //System.out.println(y);
            //x =Integer.valueOf(inputs[0]);
            //y =Integer.valueOf(inputs[1]);
//            for(int i = 0; i < 2; i++){
//
//            }

//            for(int i = 0; i < inputs.length; i++){
//                System.out.println(inputs[i]);
//            }




            //System.out.println("Successfully opened " + filePath.getFileName() + ", file content: ");

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
            ImageHelper imageHelper = new ImageHelper();

            this.session.applyAllTransformations();

            for(Image image : this.session.getImages()){
                //imageHelper.write(image.getFilePath(),image.getBufferedImage());
                fileHelper.write(image.getFilePath(),image.getFileContent());
            }

            //fileHelper.write(this.file, input);
            System.out.println("Successfully saved the current file");
        }catch(Exception e){
            System.out.println("Exception occurred: " + e);
        }


    }

    @Override
    public void saveFileAs(Path filePath, String input) {
        try {
            FileHelper fileHelper = new FileHelper();
            ImageHelper imageHelper = new ImageHelper();

            if(Files.notExists(filePath)){
                fileHelper.createFile(filePath);
            }

            this.session.applyAllTransformations();
            //imageHelper.write(filePath,this.session.getImages().stream().findFirst().get().getBufferedImage());
            //System.out.println(this.session.getImages().stream().findFirst().get());
            fileHelper.write(filePath, this.session.getImages().stream().findFirst().get().getFileContent());
            System.out.println("Successfully saved the current file to another location: \"" + filePath.getFileName() + "\"");
        }catch(Exception e){
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
                "exit           exists the program \n" +

                "grayscale      transforms the image into grayscale format \n" +
                "monochrome     transforms the image into monochrome format \n" +
                "negative       transforms the image into negative color format \n" +
                "rotate         rotates the image to the left \n" +
                "undo           undo the last transformation \n" +
                "add            adds an image to the session \n" +
                "sessioninfo    prints the information about the current session \n" +
                "switchsession <id>     switches the session to session with id <id> \n" +
                "collage <file>         makes a collage from the images in the current session and saves it into <file> \n");
    }

    @Override
    public void exit() {
        System.out.println("Exiting the program...");
    }

    @Override
    public void grayscale() {
        Transformation transformation = new GrayscaleTransformation();
        this.session.addTransformation(transformation);

        //this.session.applyAllTransformations();

    }

    @Override
    public void monochrome() {
        Transformation transformation = new MonochromeTransformation();
        this.session.addTransformation(transformation);

        //this.session.applyAllTransformations();

    }

    @Override
    public void negative() {
        Transformation transformation = new NegativeTransformation();
        this.session.addTransformation(transformation);
        //this.session.addTransformation();
    }

    @Override
    public void rotate(Direction direction) {
        Transformation transformation = new RotateTransformation(direction);
        this.session.addTransformation(transformation);
        //this.session.addTransformation();
    }

    @Override
    public void undo() {
        this.session.removeLastTransformation();
    }

    @Override
    public void addImage(Path filepath) {

        try {
            BufferedImage bufferedImage;
            ImageHelper imageHelper = new ImageHelper();
            bufferedImage = imageHelper.read(filepath);

            FileHelper fileHelper = new FileHelper();
            String file = fileHelper.read(filepath);
            Image image = new Image(bufferedImage,filepath,file);
//            for (int i = 0; i < 9; i++) {
//                // length returns number of rows
//
//                System.out.print("row " + i + " : ");
//                for (int j = 0; j < 6; j++) {
//
//                    // here length returns # of columns corresponding to current row
//
//                    System.out.println("col " + j + ": " + image.getIntMatrix()[i][j]);
//                }
//            }
            //if (bufferedImage != null){

                //Image image = new Image(bufferedImage, filepath);
            this.session.addImage(image);
            System.out.println("Image \"" + filepath.getFileName() + "\" added");
            System.out.println("Image content: \r\n" + image.getFileContent());
            //}

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
    public void collage(Path filePath) {
        String collage = "";
        for(Image element : this.session.getImages()){
            collage = collage + element.getFileContent() + "\r\n";
        }
        System.out.println(collage);
        try {
            FileHelper fileHelper = new FileHelper();

            if(Files.notExists(filePath)){
                fileHelper.createFile(filePath);
            }

            fileHelper.write(filePath, collage);
            System.out.println("Successfully saved the current file to another location: \"" + filePath.getFileName() + "\"");
        }catch(Exception e){
            System.out.println("Exception occurred: " + e);
        }
    }


}
