package org.example.commands;

import com.ctc.wstx.exc.WstxOutputException;
import org.example.command_support.Command;
import org.example.command_support.CommandManager;
import org.example.controller.BufferedLineReader;
import org.example.controller.ConsoleManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExecuteScriptCommand extends Command {
    String commandArg;

    @Override
    public void execute() {
        if (!ConsoleManager.getIsCommandArg()) {
            System.out.println("У команды должен быть аргумент!");
        } else {
            File scriptFile = new File(ConsoleManager.getCommandArg());
            if (this.app.getScriptsStack().contains(scriptFile)) {
                System.out.println("Попытка вызвать скрипт, который уже исполняется!");

            } else {
                this.app.getScriptsStack().add(scriptFile);
                try (FileInputStream input = new FileInputStream("src/main/java/org/example/data/" + scriptFile + ".txt")) {
                    BufferedLineReader bufferedLineReader = new BufferedLineReader(input);
                    while (bufferedLineReader.hasNextLine()) {
                        String line = bufferedLineReader.nextLine().trim();
                        String[] str = line.trim().split(" ");
                        while (str.length == 0 || str.length > 2) {
                            line = bufferedLineReader.nextLine().trim();
                            str = line.split(" ");
                        }
                        String command = str[0];
                        ConsoleManager.setIsCommandArg(false);
                        if (str.length == 2) {
                            commandArg = str[1];
                            ConsoleManager.setIsCommandArg(true);
                            ConsoleManager.setCommandArg(commandArg);
                        }
                        System.out.print("[" + scriptFile + "] ");
                        this.app.getCommandManager().executeCommand(command);
                    }

                } catch (FileNotFoundException e) {
                    System.out.println("Такого файла не существует!");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                this.app.getScriptsStack().removeLast();
                System.out.println("✓Скрипт " + scriptFile + " выполнен");

            }
        }


    }

    @Override
    public String getDescription() {
        return "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }

    @Override
    public String getName() {
        return "execute_script";
    }
}
