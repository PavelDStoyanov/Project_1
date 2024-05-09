package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.implementations.additional;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.Command;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.invoker.FileSystem;

public class MonochromeCommand implements Command {
    private FileSystem fileSystem;

    public MonochromeCommand(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public void execute() {
        this.fileSystem.getState().monochrome();
    }
}
