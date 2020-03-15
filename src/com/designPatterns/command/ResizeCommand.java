package com.designPatterns.command;

import com.designPatterns.command.framework.Command;

public class ResizeCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Resize command");
    }
}
