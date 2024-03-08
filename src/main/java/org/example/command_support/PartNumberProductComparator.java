package org.example.command_support;

import org.example.model.Product;

import java.util.Comparator;

public class PartNumberProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return p1.getPartNumber().compareTo(p2.getPartNumber());
    }
}
