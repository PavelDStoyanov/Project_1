package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.Command;

public class FileInvoker {
    public Command command;

    public FileInvoker(Command command) {
        this.command = command;
    }

    public void execute(){
        this.command.execute();
    }
}
