package com.designPatterns.memento;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<EditorSnapshot> snapshots = new ArrayList<>();

    public void addSnapshot(EditorSnapshot snapshot){
        snapshots.add(snapshot);
    }

    public EditorSnapshot undo(){
        if (snapshots.isEmpty())
            return new EditorSnapshot("");

        int lastIndex = snapshots.size() - 1;
        EditorSnapshot lastState = snapshots.get(lastIndex);
        snapshots.remove(lastIndex);

        return lastState;
    }
}
