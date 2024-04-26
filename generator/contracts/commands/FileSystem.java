package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands;

import java.io.File;

public interface FileSystem {
    void openFile(File file, String input);
    void closeFile();
    void saveFile();
    void saveFileAs();
    void help();
    void exit();
}
