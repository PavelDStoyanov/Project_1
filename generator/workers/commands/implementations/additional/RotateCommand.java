package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.implementations.additional;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.Command;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.Direction;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.invoker.FileSystem;

public class RotateCommand implements Command {
    private FileSystem fileSystem;
    private Direction direction;

    public RotateCommand(FileSystem fileSystem, Direction direction) {
        this.fileSystem = fileSystem;
        this.direction = direction;
    }

    @Override
    public void execute() {
        this.fileSystem.getState().rotate(this.direction);
    }
}
