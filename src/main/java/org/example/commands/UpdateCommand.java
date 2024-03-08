package org.example.commands;

import org.example.command_support.Command;
import org.example.command_support.CommandWithIdArgument;
import org.example.controller.ConsoleManager;
import org.example.dao.CollectionManager;
import org.example.model.ProductDTO;

import java.sql.SQLOutput;

public class UpdateCommand extends Command implements CommandWithIdArgument {
    @Override
    public void execute() {
        if (!ConsoleManager.getIsCommandArg()) {
            System.out.println("У команды должен быть аргумент!");
        } else {
            CollectionManager collectionManager = this.app.getCollectionManager();
            if (collectionManager.getSize() == 0) {
                System.out.println("Коллекция пустая");
            } else {
                if (checkArgForId(ConsoleManager.getCommandArg())) {
                    long updateid = Long.parseLong(ConsoleManager.getCommandArg());
                    if (collectionManager.isIdExists(updateid)) {
                        System.out.println("Такого id не существует!");
                    } else {
                        ProductCreator productCreator = new ProductCreator();
                        ProductDTO productDTO = productCreator.createNewProduct();
                        collectionManager.updateById(updateid, productDTO);
                        System.out.println("✓Продукт с id: " + updateid + " был обновлен");
                    }
                } else {
                    System.out.println("Неверный формат ввола аргумента!");
                }
            }
        }
    }

    @Override
    public String getDescription() {
        return "обновить значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public String getName() {
        return "update";
    }
}
