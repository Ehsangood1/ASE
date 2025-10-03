package com.github.ASE.FactoryMethod;

public abstract class DocumentGenerator {
    public abstract Header createHeader();

    public abstract Paragraph createParagraph();

    public abstract Table createTable();

    public abstract Footer createFooter();

    // Template method that uses factory methods
    public Document generateDocument() {
        StringBuilder sb = new StringBuilder();

        sb.append(createHeader().getContent()).append("\n\n");
        sb.append(createParagraph().getContent()).append("\n\n");
        sb.append(createTable().getContent()).append("\n\n");
        sb.append(createFooter().getContent());

        return new Document() {
            @Override
            public String render() {
                return sb.toString();
            }
        };
    }
}