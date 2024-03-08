package org.example.commands;

import org.example.command_support.Command;
import org.example.controller.ConsoleManager;

import static java.lang.System.exit;

public class ExitCommand extends Command {
    @Override
    public void execute() {
        if (ConsoleManager.getIsCommandArg()) {
            System.out.println("У команды не дложно быть аргумента!");
        } else {
            //ConsoleManager.setIsWorking(false);
            System.out.println("Завершение программы...");
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
