package com.designPatterns.state;

public class SelectionTool implements Tool {
    @Override
    public void mouseUp() {
        System.out.println("Mouse up on SELECTION Tool");
    }

    @Override
    public void mouseDown() {
        System.out.println("Mouse down on SELECTION Tool");
    }
}
