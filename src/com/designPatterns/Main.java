package com.designPatterns;

import com.designPatterns.iterator.BrowseHistory;
import com.designPatterns.iterator.Iterator;
import com.designPatterns.memento.Editor;
import com.designPatterns.memento.History;
import com.designPatterns.state.BrushTool;
import com.designPatterns.state.Canvas;
import com.designPatterns.state.SelectionTool;
import com.designPatterns.strategy.BlackAndWhiteFilter;
import com.designPatterns.strategy.ImageStorage;
import com.designPatterns.strategy.JpegCompressor;
import com.designPatterns.strategy.PngCompressor;

public class Main {

    public static void main(String[] args) {
        playWithStrategyPattern();
    }

    private static void playWithStrategyPattern(){
        ImageStorage imageStorage = new ImageStorage();
        imageStorage.store("a", new JpegCompressor(), new BlackAndWhiteFilter());
        imageStorage.store("b", new PngCompressor(), new BlackAndWhiteFilter());
    }

    private static void playWithIteratorPattern(){
        BrowseHistory history = new BrowseHistory();
        history.push("a");
        history.push("b");
        history.push("c");

        Iterator iterator = history.createIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.current());
            iterator.Next();
        }
    }

    private static void playWithStatePattern(){
        Canvas canvas = new Canvas();

        canvas.setCurrentTool(new SelectionTool());
        canvas.mouseUp();
        canvas.mouseDown();

        canvas.setCurrentTool(new BrushTool());
        canvas.mouseUp();
        canvas.mouseDown();
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
