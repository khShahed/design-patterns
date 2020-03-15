package com.designPatterns.memento;

public class EditorSnapshot {
    private final String content;

    public EditorSnapshot(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
