package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileHelper {
    File file = new File("graphics.txt");
    Scanner scanner = new Scanner(file);

    public FileHelper() throws FileNotFoundException {
    }

    public String read(Path filePath) throws IOException{
        return Files.readString(filePath);
    }

    private void createDirectory(Path path) throws IOException{
        if(Files.notExists(path)){
            Files.createDirectory(path);
        }
    }
}
