package com.designPatterns;

import com.designPatterns.memento.Editor;
import com.designPatterns.memento.History;

public class Main {

    public static void main(String[] args) {
        playWithMementoPattern();
    }

    private static void playWithMementoPattern(){
        Editor editor = new Editor();
        History history = new History();

        editor.setContent("first step");
        history.addSnapshot(editor.createSnapshot());

        editor.setContent("Second step");
        history.addSnapshot(editor.createSnapshot());

        editor.setContent("Third step");

        editor.restoreSnapshot(history.undo());
        System.out.println(editor.getContent());

        editor.restoreSnapshot(history.undo());
        System.out.println(editor.getContent());

        editor.restoreSnapshot(history.undo());
        System.out.println(editor.getContent());
    }
}
