package com.designPatterns.command;

import com.designPatterns.command.framework.Command;

import java.util.ArrayList;
import java.util.List;

public class CompositeCommand implements Command {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command){
        commands.add(command);
    }

    @Override
    public void execute() {
        for (Command command: commands) {
            command.execute();
        }
    }
}
