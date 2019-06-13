package com.lckdn.collections.ArrayList;

import java.util.List;
import java.util.ArrayList;

public class ArrayListTest {
    private List<String> toDoList = new ArrayList<>();

    public void addToList(String task) {
        toDoList.add(task);
    }

    public void addToListAtPosition(int position, String task) {
        toDoList.add(position, task);
    }

    public void printToDoList() {
        toDoList.stream()
                .forEach(e -> {
                    System.out.println(e);
                });
    }

    public void changeTask(int index, String newTask) {
        toDoList.set(index, newTask);
    }

    public void removeTask(String task) {
        toDoList.remove(task);
    }

    public int getPriority(String task) {
        return toDoList.indexOf(task);
    }
}
