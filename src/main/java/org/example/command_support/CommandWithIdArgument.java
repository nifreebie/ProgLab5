package org.example.command_support;

public interface CommandWithIdArgument {
    default boolean checkArgForId(String arg){
        try{
            Long.parseLong(arg);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
