package org.example.controller;

import lombok.NoArgsConstructor;
import org.example.command_support.CommandManager;
import org.example.service.AppContainer;
import org.example.service.NotValidRequestException;
import org.example.service.Request;

import java.util.Scanner;

@NoArgsConstructor
public class ConsoleManager {


    public void run() {
        AppContainer app = AppContainer.getInstance();
        BufferedLineReader sc = app.getBufferedLineReader();
        CommandManager commandManager = app.getCommandManager();
        System.out.println("Программа запущена, для получения списка команд введите 'help'");
        System.out.print(">");
        while (sc.hasNextLine()) {
            try {
                Request.setLine(sc.nextLine().trim());
                try {
                    commandManager.executeCommand(Request.getCommandName());
                    System.out.print(">");
                } catch (NullPointerException e) {
                    ReqWriter.write("Команда " + Request.getCommandName() + " не найдена!");
                    System.out.print(">");
                }
            } catch (NotValidRequestException e) {
                ReqWriter.write("Неверный формат ввода команды!");
                System.out.print(">");
            }

        }
    }

}
