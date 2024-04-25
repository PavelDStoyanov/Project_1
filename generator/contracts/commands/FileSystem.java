package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands;

import java.io.File;

public interface FileSystem {
    String openFile(File file, String input);
    String closeFile();
    String saveFile();
    String saveFileAs();
    String help();
    String exit();
}
