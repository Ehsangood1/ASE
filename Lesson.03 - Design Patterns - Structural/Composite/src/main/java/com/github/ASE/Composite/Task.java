package com.github.ASE.Composite;

import java.util.List;

public interface Task {
    void execute();

    double getCost();

    void addTask(Task task);

    void removeTask(Task task);

    List<Task> getTasks();
}
