package com.github.ASE.Prototype.Resume;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.github.ASE.Prototype.BaseDocument;

public class Document extends BaseDocument {
    private String name;
    private List<String> skills;
    private String education;

    public Document(String name, List<String> skills, String education) {
        this.name = name;
        this.skills = new ArrayList<>(skills);
        this.education = education;
    }

    @Override
    public void render(PrintStream ps) {
        ps.println("== Resume ==");
        ps.println("Name: " + name);
        ps.println("Content: " + getContent());
        ps.println("Skills: " + String.join(", ", skills));
        ps.println("Education: " + education);
    }

    @Override
    public Document clone() {
        return new Document(this.name, this.skills, this.education);
    }
}
