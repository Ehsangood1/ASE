package com.github.ASE.Visitor;

import java.util.ArrayList;
import java.util.List;

import com.github.ASE.Visitor.Elements.Book;
import com.github.ASE.Visitor.Elements.Electronics;
import com.github.ASE.Visitor.Elements.Food;
import com.github.ASE.Visitor.Elements.Luxury;
import com.github.ASE.Visitor.Visitors.Holiday;
import com.github.ASE.Visitor.Visitors.Standard;

public class App {

    public static void main(String[] args) {
        List<Taxable> cart = new ArrayList<>();
        cart.add(new Book("Design Patterns", 49.99));
        cart.add(new Food("Organic Apples", 10.00));
        cart.add(new Electronics("Smartphone", 899.99));
        cart.add(new Luxury("Designer Watch", 1200.00));

        // Apply standard tax
        TaxVisitor standardVisitor = new Standard();
        double standardTax = calculateTax(cart, standardVisitor);
        System.out.println("Total Standard Tax: $" + standardTax + "\n");

        // Apply holiday tax
        TaxVisitor holidayVisitor = new Holiday();
        double holidayTax = calculateTax(cart, holidayVisitor);
        System.out.println("Total Holiday Tax: $" + holidayTax);
    }

    private static double calculateTax(List<Taxable> items, TaxVisitor visitor) {
        double total = 0;
        for (Taxable item : items) {
            total += item.accept(visitor);
        }
        return total;
    }
}
