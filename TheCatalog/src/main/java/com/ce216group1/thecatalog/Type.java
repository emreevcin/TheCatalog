package com.ce216group1.thecatalog;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Type {
    private String name;
    private ArrayList<Item> items;
    private ArrayList<String> attributes;

    public Type(String name) {
        this.name = name;
        items = new ArrayList<>();
        attributes = new ArrayList<String>();
    }

    public Type(String name,ArrayList<Item> items, ArrayList<String > attributes) {
        this.name = name;
        this.items = items;
        this.attributes = attributes;
    }

    public Type() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<String> attributes) {
        this.attributes = attributes;
    }
}