package com.github.ASE.Composite;

public class App {

    public static void main(String[] args) {
        Task task1 = new SimpleTask("Design UI", 200.0);
        Task task2 = new SimpleTask("Write Backend", 300.0);
        Task task3 = new SimpleTask("Test App", 150.0);

        CompositeTask frontendTeam = new CompositeTask("Frontend Team");
        frontendTeam.addTask(new SimpleTask("Create Wireframes", 100.0));
        frontendTeam.addTask(new SimpleTask("Implement Components", 250.0));

        CompositeTask backendTeam = new CompositeTask("Backend Team");
        backendTeam.addTask(new SimpleTask("Design API", 200.0));
        backendTeam.addTask(new SimpleTask("Implement Authentication", 180.0));

        CompositeTask project = new CompositeTask("Project: Build Mobile App");
        project.addTask(task1);
        project.addTask(task2);
        project.addTask(task3);
        project.addTask(frontendTeam);
        project.addTask(backendTeam);

        System.out.println("Starting Project Execution:\n");
        project.execute();

        System.out.println("\nTotal Project Cost: $" + project.getCost());
    }

}
