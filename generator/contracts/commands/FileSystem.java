package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands;

import java.io.File;
import java.nio.file.Path;

public interface FileSystem {
    void openFile(Path filePath);
    void closeFile();
    void saveFile(Path filePath, String input);
    void saveFileAs(Path filePath, String input);
    void help();
    void exit();
}
