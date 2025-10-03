package com.github.ASE.Prototype;

public class App {
    public static void main(String[] args) {
        Registry.initializePrototypes();

        Document invoice1 = Registry.getDocument("invoice-template");
        invoice1.setContent("Custom Invoice Content - Project X");
        invoice1.render(System.out);
        System.out.println();

        Document resume1 = Registry.getDocument("resume-template");
        resume1.setContent("Custom Resume Content - Senior Developer");
        resume1.render(System.out);
        System.out.println();

        Document report1 = Registry.getDocument("report-template");
        report1.setContent("Custom Report Content - 2024 Q1");
        report1.render(System.out);
    }
}