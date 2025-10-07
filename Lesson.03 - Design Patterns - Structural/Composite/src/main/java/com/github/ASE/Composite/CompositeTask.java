package com.github.ASE.Composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeTask implements Task {
    private final String name;
    private final List<Task> tasks = new ArrayList<>();

    public CompositeTask(String name) {
        this.name = name;
    }

    @Override
    public void execute() {
        System.out.println("Composite Task: " + name);
        for (Task task : tasks) {
            task.execute();
        }
    }

    @Override
    public double getCost() {
        return tasks.stream().mapToDouble(Task::getCost).sum();
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public void removeTask(Task task) {
        tasks.remove(task);
    }

    @Override
    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

}
