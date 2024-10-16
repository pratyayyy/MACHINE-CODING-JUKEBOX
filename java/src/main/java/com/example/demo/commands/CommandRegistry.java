package com.example.demo.commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommandRegistry {
    private static final Map<String, ICommand> commands = new HashMap<>();

    public void registerCommand(String commandKeyword, ICommand command) {
        commands.put(commandKeyword, command);
    }

    
    public void invokeCommand(String input){
        List<String> tokens = Arrays.stream(input.split(" ")).collect(Collectors.toList());
        ICommand command = commands.get(tokens.get(0));

        command.execute(tokens);
        return;
    }

}
