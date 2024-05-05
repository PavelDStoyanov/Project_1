package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.files;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.files.ReadFile;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.files.WriteFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileHelper implements ReadFile, WriteFile {
    //File file = new File("graphics.txt");
    //Scanner scanner = new Scanner(file);

    public FileHelper() throws FileNotFoundException {}

    @Override
    public void write(Path filePath, String data) throws IOException {
        try {
            Files.write(filePath, data.getBytes());
            //Files.write(file.toPath(), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public String read(Path filePath) throws IOException{
        try {
            return Files.readString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

    }

    public void createDirectory(Path path) throws IOException{
        if(Files.notExists(path)){
            Files.createDirectory(path);
        }
    }

    public void createFile(Path path) throws IOException {
        if(Files.notExists(path)){
            Files.createFile(path);
        }
    }


}
