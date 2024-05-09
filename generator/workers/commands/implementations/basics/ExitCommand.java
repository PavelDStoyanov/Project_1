package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.implementations.basics;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.Command;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.invoker.FileSystem;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.states.FileSystemOpenState;

public class ExitCommand implements Command {
    private FileSystem fileSystem;

    public ExitCommand(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }
    @Override
    public void execute() {
        this.fileSystem.getState().exit();
    }
}
