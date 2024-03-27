package org.example.commands;

import org.example.command_support.Command;
import org.example.controller.ConsoleManager;
import org.example.controller.ReqWriter;
import org.example.service.Request;

import static java.lang.System.exit;

public class ExitCommand extends Command {
    @Override
    public void execute() {
        if (Request.isCommandArg()) {
            ReqWriter.write("У команды не дложно быть аргумента!");
        } else {
            //ConsoleManager.setIsWorking(false);
            ReqWriter.write("Завершение программы...");
            System.exit(0);
        }
    }

    @Override
    public String getDescription() {
        return "Завершить программу(без сохранения в файл)";
    }

    @Override
    public String getName() {
        return "exit";
    }
}
