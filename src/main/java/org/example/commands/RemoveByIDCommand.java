package org.example.commands;

import org.example.command_support.Command;
import org.example.command_support.CommandWithIdArgument;
import org.example.controller.ConsoleManager;
import org.example.controller.ReqWriter;
import org.example.dao.CollectionManager;
import org.example.service.Request;

public class RemoveByIDCommand extends Command implements CommandWithIdArgument {
    @Override
    public void execute() {
        if (!Request.isCommandArg()) {
            ReqWriter.write("У команды должен быть аргумент!");
        } else {
            try {
                CollectionManager collectionManager = this.app.getCollectionManager();
                if (collectionManager.getSize() == 0) {
                    ReqWriter.write("Коллекция пустая");
                } else {
                    long findId = Request.getArgId();
                    if (!collectionManager.isIdExists(findId)) System.out.println("Такого id не существует!");
                    else {
                        app.getCollectionManager().removeById(findId);
                        ReqWriter.write("✓Продукт с id: " + findId + " был удален");
                    }
                }
            } catch (NumberFormatException e) {
                ReqWriter.write("Неверный формат ввода аргумента!");
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
