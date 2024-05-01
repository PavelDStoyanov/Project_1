package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.implementations;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.Command;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.FileSystem;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.request.FileSystemImpl;

import java.nio.file.Path;

public class SaveFileAsCommand implements Command {
    private FileSystemImpl fileSystem;
    private Path filePath;

    public SaveFileAsCommand(FileSystemImpl fileSystem, Path filePath) {
        this.fileSystem = fileSystem;
        this.filePath = filePath;
    }

    @Override
    public void execute() {
        this.fileSystem.saveFileAs(filePath,"Draft");
    }
}
