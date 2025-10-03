package com.github.ASE.Prototype.Report;

import java.io.PrintStream;
import java.util.List;

import com.github.ASE.Prototype.BaseDocument;

public class Document extends BaseDocument {
    private String title;
    private String author;
    private List<String> sections;
    private String footnotes;

    public Document(String title, String author, List<String> sections, String footnotes) {
        this.title = title;
        this.author = author;
        this.sections = sections;
        this.footnotes = footnotes;
    }

    @Override
    public void render(PrintStream ps) {
        ps.println("== Report ==");
        ps.println("Title: " + title);
        ps.println("Author: " + author);
        for (int i = 0; i < sections.size(); ++i) {
            ps.println("Section " + String.valueOf(i + 1) + ": " + sections.get(i));
        }
        ps.println("Content: " + getContent());
        ps.println("Footnotes: " + footnotes);
    }

    @Override
    public Document clone() {
        return new Document(this.title, this.author, this.sections, this.footnotes);
    }
}
