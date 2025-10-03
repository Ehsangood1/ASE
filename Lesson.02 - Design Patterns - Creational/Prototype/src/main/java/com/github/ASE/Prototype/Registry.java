package com.github.ASE.Prototype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Registry {
    private static final Map<String, Document> prototypes = new HashMap<>();

    public static void addPrototype(String key, Document prototype) {
        prototypes.put(key, prototype);
    }

    public static Document getDocument(String key) {
        Document prototype = prototypes.get(key);
        if (prototype == null) {
            throw new IllegalArgumentException("Prototype not found: " + key);
        }
        return prototype.clone();
    }

    public static void initializePrototypes() {
        addPrototype("invoice-template", new com.github.ASE.Prototype.Invoice.Document("INV-001", "Acme Inc.", 1000.0));
        addPrototype("resume-template", new com.github.ASE.Prototype.Resume.Document("John Doe",
                List.of("Java", "Spring"), "BSc Computer Science"));
        addPrototype("report-template", new com.github.ASE.Prototype.Report.Document("Annual Report", "Jane Smith",
                List.of("Summary", "Detail"), "Footnotes"));
    }
}
