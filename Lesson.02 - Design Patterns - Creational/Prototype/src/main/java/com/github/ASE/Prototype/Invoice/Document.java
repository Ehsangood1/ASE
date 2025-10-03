package com.github.ASE.Prototype.Invoice;

import java.io.PrintStream;

import com.github.ASE.Prototype.BaseDocument;

public class Document extends BaseDocument {
    private String invoiceNumber;
    private String clientName;
    private double total;

    public Document(String invoiceNumber, String clientName, double total) {
        this.invoiceNumber = invoiceNumber;
        this.clientName = clientName;
        this.total = total;
    }

    @Override
    public void render(PrintStream ps) {
        ps.println("== Invoice ==");
        ps.println("Invoice #: " + invoiceNumber);
        ps.println("Client: " + clientName);
        ps.println("Total: $" + total);
        ps.println("Content: " + getContent());
    }

    @Override
    public Document clone() {
        return new Document(this.invoiceNumber, this.clientName, this.total);
    }
}
