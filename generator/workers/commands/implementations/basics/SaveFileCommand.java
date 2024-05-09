package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.implementations.basics;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.Command;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.invoker.FileSystem;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.states.FileSystemOpenState;

import java.nio.file.Path;

public class SaveFileCommand implements Command {
    private FileSystem fileSystem;
    private String input;

    public SaveFileCommand(FileSystem fileSystem,String input) {
        this.fileSystem = fileSystem;
        this.input = input;
    }

    @Override
    public void execute() {
        this.fileSystem.getState().saveFile(input);
    }
}
