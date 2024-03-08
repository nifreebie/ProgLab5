package org.example;

import org.example.command_support.CommandManager;
import org.example.command_support.ProductComparator;
import org.example.controller.ConsoleManager;
import org.example.controller.ValidReader;
import org.example.dao.CollectionManager;
import org.example.dao.Storage;
import org.example.model.Product;
import org.example.service.AppContainer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        initAppContainer();
        initCollection(args);
        ConsoleManager consoleManager = new ConsoleManager();
        consoleManager.run();

    }

    private static void initAppContainer() {
        AppContainer app = AppContainer.getInstance();
        CommandManager commandManager = new CommandManager();
        app.setCommandManager(commandManager);
    }

    private static void initCollection(String[] args) {
        Set<Product> productCollection;
        long newLastId = 0;
        if (args.length > 0) {
            try {
                String fileName = args[0];
                productCollection = Storage.read(fileName);
                List<Product> list = new ArrayList<>(productCollection);
                newLastId = list.get(list.size() - 1).getId();
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла!");
                productCollection = new LinkedHashSet<>();

            }


        } else {
            productCollection = new LinkedHashSet<>();
        }
        CollectionManager collectionManager = new CollectionManager(productCollection);
        AppContainer.getInstance().setCollectionManager(collectionManager);
        AppContainer.getInstance().getCollectionManager().setLastId(newLastId);
        ProductComparator productComparator = new ProductComparator();
        collectionManager.sort(productComparator);
    }
}