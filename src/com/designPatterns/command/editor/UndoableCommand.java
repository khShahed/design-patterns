package com.designPatterns.command.editor;

public interface UndoableCommand extends Command {
    void unexecute();
}
