package org.example.commands;

import com.ctc.wstx.exc.WstxOutputException;
import org.example.command_support.Command;
import org.example.command_support.CommandManager;
import org.example.command_support.StopExecuteScriptException;
import org.example.controller.BufferedLineReader;
import org.example.controller.ConsoleManager;
import org.example.controller.ReqWriter;
import org.example.service.NotValidRequestException;
import org.example.service.Request;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExecuteScriptCommand extends Command {
    private boolean isError = false;

    @Override
    public void execute() {
        if (!Request.isCommandArg()) {
            ReqWriter.write("У команды должен быть аргумент!");
        } else {
            File scriptFile = new File(Request.getCommandName());
            if (this.app.getScriptsStack().contains(scriptFile)) {
                ReqWriter.write("Попытка вызвать скрипт, который уже исполняется!");
                isError = true;
            } else {
                this.app.getScriptsStack().add(scriptFile);
                try (FileInputStream input = new FileInputStream("src/main/java/org/example/data/" + scriptFile + ".txt")) {
                    BufferedLineReader bufferedLineReader = new BufferedLineReader(input);
                    this.app.setBufferedLineReader(bufferedLineReader);
                    while (bufferedLineReader.hasNextLine()) {
                        try {
                            try {
                                Request.setLine(bufferedLineReader.nextLine().trim());
                            } catch (NotValidRequestException e) {
                                ReqWriter.write("Неверный формат ввода команды!");
                                Request.setLine(bufferedLineReader.nextLine().trim());
                            }
                            try {
                                this.app.getCommandManager().executeCommand(Request.getCommandName());
                            } catch (NullPointerException e) {
                                ReqWriter.write("Команда " + Request.getCommandName() + " не найдена!");
                            }
                            /*String line = bufferedLineReader.nextLine().trim();
                            String[] str = line.trim().split("\\s+");
                            while (str.length == 0 || str.length > 2) {
                                line = bufferedLineReader.nextLine().trim();
                                str = line.split("\\s+");
                            }
                            String command = str[0];
                            ConsoleManager.setIsCommandArg(false);
                            if (str.length == 2) {
                                commandArg = str[1];
                                ConsoleManager.setIsCommandArg(true);
                                ConsoleManager.setCommandArg(commandArg);
                            }
                            this.app.getCommandManager().executeCommand(command);*/
                        } catch (StopExecuteScriptException e) {
                            ReqWriter.write("Ошибка при исполнении скрипта!");
                            isError = true;
                            break;
                        }
                    }

                } catch (FileNotFoundException e) {
                    ReqWriter.write("Такого файла не существует!");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                this.app.getScriptsStack().removeLast();
                if (!isError) ReqWriter.write("✓Скрипт " + scriptFile + " выполнен");

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
