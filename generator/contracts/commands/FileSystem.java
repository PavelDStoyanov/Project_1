package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands;

import java.io.File;
import java.nio.file.Path;

public interface FileSystem {
    void openFile(Path filePath, String input);
    void closeFile();
    void saveFile();
    void saveFileAs();
    void help();
    void exit();
}
