package com.designPatterns;

import com.designPatterns.command.*;
import com.designPatterns.command.editor.BoldCommand;
import com.designPatterns.command.editor.HtmlDocument;
import com.designPatterns.command.editor.UndoCommand;
import com.designPatterns.command.framework.Button;
import com.designPatterns.command.framework.Command;
import com.designPatterns.iterator.BrowseHistory;
import com.designPatterns.iterator.Iterator;
import com.designPatterns.memento.Editor;
import com.designPatterns.memento.History;
import com.designPatterns.observer.Chart;
import com.designPatterns.observer.DataSource;
import com.designPatterns.observer.SpreadSheet;
import com.designPatterns.state.BrushTool;
import com.designPatterns.state.Canvas;
import com.designPatterns.state.SelectionTool;
import com.designPatterns.strategy.BlackAndWhiteFilter;
import com.designPatterns.strategy.ImageStorage;
import com.designPatterns.strategy.JpegCompressor;
import com.designPatterns.strategy.PngCompressor;
import com.designPatterns.templateMethod.GenerateReportTask;
import com.designPatterns.templateMethod.TransferMoneyTask;

public class Main {

    public static void main(String[] args) {
        playWithObserverPattern();
    }

    private static void playWithObserverPattern(){
        DataSource dataSource = new DataSource();
        SpreadSheet spreadSheet = new SpreadSheet();
        Chart chart = new Chart();
        dataSource.addObserver(spreadSheet);
        dataSource.addObserver(chart);

        dataSource.setValue(2);
    }

    private static void playWithCommandPattern(){
        CustomerService service = new CustomerService();
        Command command = new AddCustomerCommand(service);
        Button button = new Button(command);
        button.click();

        CompositeCommand compositeCommand = new CompositeCommand();
        compositeCommand.addCommand(new ResizeCommand());
        compositeCommand.addCommand(new BlackAndWhiteCommand());
        compositeCommand.execute();
        compositeCommand.execute();

        com.designPatterns.command.editor.History history = new com.designPatterns.command.editor.History();
        HtmlDocument document = new HtmlDocument();
        document.setContent("Hello World");

        BoldCommand boldCommand = new BoldCommand(document, history);
        boldCommand.execute();
        System.out.println(document.getContent());

        UndoCommand undoCommand = new UndoCommand(history);
        undoCommand.execute();
        System.out.println(document.getContent());
    }

    private static void playWithTemplateMethodPattern(){
        TransferMoneyTask transferMoneyTask = new TransferMoneyTask();
        transferMoneyTask.execute();

        GenerateReportTask generateReportTask = new GenerateReportTask();
        generateReportTask.execute();
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
