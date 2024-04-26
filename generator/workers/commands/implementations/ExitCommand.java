package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.implementations;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.Command;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.FileSystem;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.request.FileSystemImpl;

public class ExitCommand implements Command {
    private FileSystemImpl fileSystem;

    public ExitCommand(FileSystemImpl fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public void execute() {
        this.fileSystem.exit();
    }
}
