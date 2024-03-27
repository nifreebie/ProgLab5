package org.example.controller;

import org.example.service.AppContainer;

import java.io.File;

public class ReqWriter {
    public static void write(String str) {
        AppContainer app = AppContainer.getInstance();
        if (app.isInteractiveMode()) {
            System.out.print("[script] ");
        }
        for (File script : app.getScriptsStack()) {
            System.out.print(script.getName() + " > ");
        }
        System.out.println(str);
    }

}
