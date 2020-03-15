package com.designPatterns.memento;

public class Editor {
    private String content;

    public EditorSnapshot createSnapshot(){
        return new EditorSnapshot(content);
    }

    public void restoreSnapshot(EditorSnapshot state){
        content = state.getContent();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
