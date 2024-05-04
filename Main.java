package bg.tu_varna.sit.b1.f22621682.project1.Project_1;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.Command;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.BasicCommands;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.implementations.*;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.invoker.FileSystem;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.states.FileSystemOpenState;

import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String choice;
        FileSystem fileSystem = new FileSystem();
        Scanner scanner = new Scanner(System.in);
        BasicCommands basicCommands;

        Path filePath = Path.of("D:\\tu varna\\OOP1\\project1\\src\\bg\\tu_varna\\sit\\b1\\f22621682\\project1\\Project_1\\files\\graphics.txt");


        do {
            System.out.println("\nChoose a command:");
            System.out.println("open, close, save, saveas, help, exit");
            System.out.print("> ");
            choice = scanner.nextLine();
            basicCommands = BasicCommands.valueOf(choice);
            switch (basicCommands) {
                case open:
                    Command openFileCommand = new OpenFileCommand(fileSystem, filePath);
                    //openFileCommand.execute();
                    fileSystem.execute(openFileCommand);
                    break;
                case close:
                    Command closeFileCommand = new CloseFileCommand(fileSystem);
                    //closeFileCommand.execute();
                    fileSystem.execute(closeFileCommand);
                    break;
                case save:
                    Command saveFileCommand = new SaveFileCommand(fileSystem, filePath);
                    //saveFileCommand.execute();
                    fileSystem.execute(saveFileCommand);
                    break;
                case saveas:
                    Command saveFileAsCommand =  new SaveFileAsCommand(fileSystem, filePath);
                    //saveFileAsCommand.execute();
                    fileSystem.execute(saveFileAsCommand);
                    break;
                case help:
                    Command helpCommand = new HelpCommand(fileSystem);
                    //helpCommand.execute();
                    fileSystem.execute(helpCommand);
                    break;
                case exit:
                    Command exitCommand = new ExitCommand(fileSystem);
                    //exitCommand.execute();
                    fileSystem.execute(exitCommand);
                    break;

            }
        } while (!basicCommands.equals(BasicCommands.exit));
    }
}
