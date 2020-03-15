package com.designPatterns.command;

import com.designPatterns.command.framework.Command;

public class BlackAndWhiteCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Black and white command");
    }
}
