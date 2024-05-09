package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.implementations.basics;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.Command;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.invoker.FileSystem;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.states.FileSystemOpenState;

import java.nio.file.Path;

public class OpenFileCommand implements Command {
    private FileSystem fileSystem;
    private Path filePath;

    public OpenFileCommand(FileSystem fileSystem, Path filePath) {
        this.fileSystem = fileSystem;
        this.filePath = filePath;
    }

    @Override
    public void execute() {
        this.fileSystem.getState().openFile(fileSystem, filePath);
    }
}
