package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHelper {
    File file = new File("graphics.txt");
    Scanner scanner = new Scanner(file);

    public FileHelper() throws FileNotFoundException {
    }
}
