package org.example.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.command_support.CommandManager;
import org.example.controller.BufferedLineReader;
import org.example.controller.ValidReader;
import org.example.dao.CollectionManager;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

@Getter
@Setter
public class AppContainer {
    private static AppContainer instance;

    private CollectionManager collectionManager;
    private CommandManager commandManager;
    private BufferedLineReader bufferedLineReader;
    private final Deque<File> scriptsStack = new ArrayDeque<>();

    private AppContainer() {
    }

    public static AppContainer getInstance() {
        if (instance == null) {
            instance = new AppContainer();
        }
        return instance;
    }

    public File getCurrentScript() {
        if (scriptsStack.isEmpty()) {
            return null;
        }
        return scriptsStack.getLast();
    }

    public boolean isInteractiveMode() {
        return !scriptsStack.isEmpty();
    }


}
