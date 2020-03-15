package com.designPatterns.state;

public class BrushTool implements Tool {
    @Override
    public void mouseUp() {
        System.out.println("Mouse up on BRUSH Tool");
    }

    @Override
    public void mouseDown() {
        System.out.println("Mouse down on BRUSH Tool");
    }
}
