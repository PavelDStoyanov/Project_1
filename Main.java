package bg.tu_varna.sit.b1.f22621682.project1.Project_1;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.Command;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.CommandType;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.Direction;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.Image;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.Session;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.implementations.additional.*;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.implementations.basics.*;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.invoker.FileSystem;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String choice;
        FileSystem fileSystem = new FileSystem();
        Scanner scanner = new Scanner(System.in);
        CommandType commands = CommandType.HELP;
        String input = "Test";
        String filePathFolder = "D:\\tu varna\\OOP1\\project1\\src\\bg\\tu_varna\\sit\\b1\\f22621682\\project1\\Project_1\\files\\";
        Path defaultFilePath = Path.of("D:\\tu varna\\OOP1\\project1\\src\\bg\\tu_varna\\sit\\b1\\f22621682\\project1\\Project_1\\files\\default.txt");
        //Path filePath2 = Path.of("D:\\tu varna\\OOP1\\project1\\src\\bg\\tu_varna\\sit\\b1\\f22621682\\project1\\Project_1\\files\\new.txt");
        Path filePath = defaultFilePath;
        Map<CommandType,Command> menu = new HashMap<>();
        //System.out.println(defaultFilePath.toFile());

       //Session session = new Session(4);/*should be changed*/
        //Image image = new Image(defaultFilePath);/*should be changed*/



        do{
            System.out.println("\nChoose a command:");
            System.out.println("open <file>, close, save, saveas <file>, help, exit");
            System.out.println("grayscale, monochrome, negative, rotate, undo, add, sessioninfo, switchsession, collage");
            System.out.print("> ");
            choice = scanner.nextLine().toUpperCase();
            String[] inputs = choice.split(" ");
            try{
                commands = CommandType.valueOf(inputs[0]);
            }catch (Exception e){
                System.out.println("This command does not exist");
                continue;
            }
            if(inputs.length > 1) {
                filePath = Path.of(filePathFolder + inputs[1]);
            }else{
                filePath = defaultFilePath;
            }
            menu.put(CommandType.OPEN, new OpenFileCommand(fileSystem, filePath));
            menu.put(CommandType.CLOSE, new CloseFileCommand(fileSystem));
            menu.put(CommandType.SAVE, new SaveFileCommand(fileSystem, input));
            menu.put(CommandType.SAVEAS, new SaveFileAsCommand(fileSystem, filePath,input));
            menu.put(CommandType.HELP, new HelpCommand(fileSystem));
            menu.put(CommandType.EXIT, new ExitCommand(fileSystem));

            menu.put(CommandType.MONOCHROME, new MonochromeCommand(fileSystem));
            menu.put(CommandType.GRAYSCALE, new GrayscaleCommand(fileSystem));
            menu.put(CommandType.NEGATIVE, new NegativeCommand(fileSystem));
            menu.put(CommandType.ROTATE, new RotateCommand(fileSystem, Direction.LEFT));
            menu.put(CommandType.UNDO, new UndoCommand(fileSystem));
            menu.put(CommandType.ADD, new AddImageCommand(fileSystem, filePath));
            menu.put(CommandType.SESSIONINFO, new SessionInfoCommand(fileSystem));
            menu.put(CommandType.SWITCHSESSION, new SwitchSessionCommand(fileSystem, 1 /*should be changed*/));
            menu.put(CommandType.COLLAGE, new CollageCommand(fileSystem, filePath));



//            if(menu.containsKey(basicCommands)){
//                fileSystem.execute(menu.get(basicCommands));
//            }else{
//                System.out.println("/This command does not exist");
//            }

            fileSystem.execute(menu.get(commands));

        }while(!commands.equals(CommandType.EXIT));


        /*do {
            System.out.println("\nChoose a command:");
            System.out.println("open <file>, close, save, saveas <file>, help, exit");
            System.out.print("> ");
            choice = scanner.nextLine();
            String[] inputs = choice.split(" ");

            try{
                basicCommands = BasicCommands.valueOf(inputs[0]);
            }catch (IllegalArgumentException e){
                System.out.println("This command does not exist");
                continue;
            }
            switch (basicCommands) {
                case open:
                    if(inputs.length > 1){
                    filePath = Path.of(filePathFolder + inputs[1]);

                    Command openFileCommand = new OpenFileCommand(fileSystem, filePath);
                    //openFileCommand.execute();
                    fileSystem.execute(openFileCommand);
                    }else{
                        System.out.println("Wrong input format");
                    }
                    break;
                case close:
                    Command closeFileCommand = new CloseFileCommand(fileSystem);
                    //closeFileCommand.execute();
                    fileSystem.execute(closeFileCommand);
                    break;
                case save:
                    Command saveFileCommand = new SaveFileCommand(fileSystem, input);
                    //saveFileCommand.execute();
                    fileSystem.execute(saveFileCommand);
                    break;
                case saveas:
                    if(inputs.length > 1) {
                        filePath = Path.of(filePathFolder + inputs[1]);
                        Command saveFileAsCommand = new SaveFileAsCommand(fileSystem, filePath, input);
                        //saveFileAsCommand.execute();
                        fileSystem.execute(saveFileAsCommand);
                    }
                    else{
                        System.out.println("Wrong input format");
                    }

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
        } while (!basicCommands.equals(BasicCommands.exit));*/
    }
}
