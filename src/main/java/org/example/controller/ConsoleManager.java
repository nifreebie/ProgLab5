package org.example.controller;

import lombok.NoArgsConstructor;
import org.example.command_support.CommandManager;
import org.example.service.AppContainer;

import java.util.Scanner;

@NoArgsConstructor
public class ConsoleManager {
    private static String commandArg;
    private static boolean isCommandArg = false;


    public void run() {
        Scanner sc = new Scanner(System.in);
        AppContainer app = AppContainer.getInstance();
        CommandManager commandManager = app.getCommandManager();
        System.out.println("Программа запущена, для получения списка команд введите 'help'");
        System.out.print(">");
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            String[] str = line.trim().split("\\s+");
            while (str.length == 0 || str.length > 2) {
                System.out.println("Неверный формат ввода команды!");
                line = sc.nextLine().trim();
                str = line.trim().split("\\s+");

            }
            isCommandArg = false;
            if (str.length == 2) {
                commandArg = str[1].trim();
                isCommandArg = true;
            }
            try {
                commandManager.executeCommand(str[0]);
                System.out.print(">");
            } catch (NullPointerException e) {
                System.out.println("Команда " + str[0] + " не найдена!");
                System.out.print(">");
            }

        }
    }

    public static boolean getIsCommandArg() {
        return isCommandArg;
    }

    public static void setIsCommandArg(boolean isCommandArg) {
        ConsoleManager.isCommandArg = isCommandArg;
    }


    public static String getCommandArg() {
        return commandArg;
    }

    public static void setCommandArg(String commandArg) {
        ConsoleManager.commandArg = commandArg;
    }
}
