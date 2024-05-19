package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.implementations.additional;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.Command;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.invoker.FileSystem;

public class SwitchSessionCommand implements Command {
    private FileSystem fileSystem;
    private int sessionId;

    public SwitchSessionCommand(FileSystem fileSystem, int sessionId) {
        this.fileSystem = fileSystem;
        this.sessionId = sessionId;
    }

    @Override
    public void execute() {
        this.fileSystem.getState().switchSession( sessionId);
    }
}
