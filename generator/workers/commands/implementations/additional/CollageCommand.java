package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.implementations.additional;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.Command;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.invoker.FileSystem;

import java.nio.file.Path;

public class CollageCommand implements Command {
    private FileSystem fileSystem;
    private Path filePath;

    public CollageCommand(FileSystem fileSystem, Path filePath ) {
        this.fileSystem = fileSystem;
        this.filePath = filePath;
    }

    @Override
    public void execute() {
        this.fileSystem.getState().collage(filePath);
    }
}
