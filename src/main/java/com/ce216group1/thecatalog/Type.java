package com.ce216group1.thecatalog;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Type {
    private SimpleStringProperty name;
    private ArrayList<Item> items;
    private ArrayList<SimpleStringProperty > attributes;

    public Type(SimpleStringProperty name) {
        this.name = name;
        items = new ArrayList<>();
        attributes = new ArrayList<>();
    }

    public Type(SimpleStringProperty name,ArrayList<Item> items, ArrayList<SimpleStringProperty > attributes) {
        this.name = name;
        this.items = items;
        this.attributes = attributes;
    }

    public Type() {
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<SimpleStringProperty> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<SimpleStringProperty> attributes) {
        this.attributes = attributes;
    }
}
