package bg.tu_varna.sit.b1.f22621682.project1.Project_1;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.FileSystem;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.implementations.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String choice = null;
        FileSystem fileSystem = null;

        do {
            System.out.println("Choose a command:");
            System.out.println("open, close, save, save as, help, exit");
            Scanner scanner = new Scanner(System.in);
            switch (choice) {
                case "open": new OpenFileCommand(fileSystem);
                    break;
                case "close": new CloseFileCommand(fileSystem);
                    break;
                case "save": new SaveFileCommand(fileSystem);
                    break;
                case "save as": new SaveFileAsCommand(fileSystem);
                    break;
                case "help": new HelpCommand(fileSystem);
                    break;
                case "exit": new ExitCommand(fileSystem);
                    break;

            }
        } while (choice != "exit");
    }
}
