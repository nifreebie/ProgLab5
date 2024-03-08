package org.example.commands;

import org.example.command_support.Command;
import org.example.command_support.CommandWithIdArgument;
import org.example.controller.ConsoleManager;
import org.example.dao.CollectionManager;

public class RemoveByIDCommand extends Command implements CommandWithIdArgument {
    @Override
    public void execute() {
        if (!ConsoleManager.getIsCommandArg()) {
            System.out.println("У команды должен быть аргумент!");
        } else {
            if (checkArgForId(ConsoleManager.getCommandArg())) {
                CollectionManager collectionManager = this.app.getCollectionManager();
                if (collectionManager.getSize() == 0) {
                    System.out.println("Коллекция пустая");
                } else {
                    long findId = Long.parseLong(ConsoleManager.getCommandArg());
                    if (!collectionManager.isIdExists(findId)) System.out.println("Такого id не существует!");
                    else {
                        app.getCollectionManager().removeById(findId);
                        System.out.println("✓Продукт с id: " + findId + " был удален");
                    }
                }
            } else {
                System.out.println("Неверный формат ввода аргумента!");
            }
        }
    }

    @Override
    public String getDescription() {
        return "удалить элемент из коллекции по его id";
    }

    @Override
    public String getName() {
        return "remove_by_id";
    }
}
