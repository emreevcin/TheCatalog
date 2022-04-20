package com.ce216group1.thecatalog;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Item {
    private SimpleStringProperty name;
    private ArrayList<SimpleStringProperty > tags;
    private ArrayList<SimpleStringProperty > descriptions;

    public Item(SimpleStringProperty name, ArrayList<SimpleStringProperty> tags, ArrayList<SimpleStringProperty> descriptions) {
        this.name = name;
        this.tags = tags;
        this.descriptions = descriptions;
    }

    public Item() {
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

    public ArrayList<SimpleStringProperty> getTags() {
        return tags;
    }

    public void setTags(ArrayList<SimpleStringProperty> tags) {
        this.tags = tags;
    }

    public ArrayList<SimpleStringProperty> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(ArrayList<SimpleStringProperty> descriptions) {
        this.descriptions = descriptions;
    }
}
