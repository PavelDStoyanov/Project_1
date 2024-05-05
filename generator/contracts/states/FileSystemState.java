package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.states;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.invoker.FileSystem;

import java.nio.file.Path;

public interface FileSystemState {
    void openFile(FileSystem fileSystem, Path filePath);
    void closeFile(FileSystem fileSystem);
    void saveFile(String input);
    void saveFileAs(Path filePath, String input);
    void help();
    void exit();
}
