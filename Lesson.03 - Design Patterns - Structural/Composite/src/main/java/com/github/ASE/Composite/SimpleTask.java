package com.github.ASE.Composite;

import java.util.Collections;
import java.util.List;

public class SimpleTask implements Task {
    private final String name;
    private final double cost;

    public SimpleTask(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public void execute() {
        System.out.println("Executing task: " + name + " ($" + cost + ")");
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public void addTask(Task task) {
        throw new UnsupportedOperationException("Cannot add subtasks to a simple task.");
    }

    @Override
    public void removeTask(Task task) {
        throw new UnsupportedOperationException("Cannot remove subtasks from a simple task.");
    }

    @Override
    public List<Task> getTasks() {
        return Collections.emptyList();
    }
}
