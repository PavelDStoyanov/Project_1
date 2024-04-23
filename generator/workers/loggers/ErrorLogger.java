package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.loggers;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.loggers.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ErrorLogger implements Logger{
    private final String logFile = "LocalErrors.txt";
    private static Logger logger;
    private PrintWriter printWriter;

    public ErrorLogger() throws IOException{
        FileWriter fileWriter = new FileWriter(logFile);
        printWriter = new PrintWriter(fileWriter, true);
    }

    @Override
    public void log(String message) throws IOException {
        printWriter.println(message);
    }
}
