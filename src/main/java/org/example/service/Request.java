package org.example.service;

import lombok.Getter;

public class Request {
    private static String line;
    @Getter
    private static String commandName;
    @Getter
    private static boolean isCommandArg;
    @Getter
    private static String commandArg;

    public static void setLine(String line) {
        Request.line = line;
        String[] str = Request.line.trim().split("\\s+");
        if (str.length == 0 || str.length > 2) {
            throw new NotValidRequestException();
        }
        isCommandArg = false;
        commandName = str[0];
        if (str.length == 2) {
            isCommandArg = true;
            commandArg = str[1];
        }

    }

    public static long getArgId() throws NumberFormatException {
        return Long.parseLong(commandArg);
    }

}
