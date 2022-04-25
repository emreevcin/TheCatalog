package com.ce216group1.thecatalog;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TreeItem;

import java.util.ArrayList;

public class Item {
    private String name;
    private TreeItem<String> treeItem;
    private String type;
    private ArrayList<String > tags;
    private ArrayList<String > descriptions;

    public Item(String name,TreeItem<String> treeItem,String type, ArrayList<String> tags, ArrayList<String> descriptions) {
        this.name = name;
        this.treeItem=treeItem;
        this.type=type;
        this.tags = tags;
        this.descriptions = descriptions;
    }

    public Item(String name,TreeItem<String> treeItem,String type) {
        this.name = name;
        this.treeItem=treeItem;
        this.type=type;
        tags = new ArrayList<>();
        descriptions = new ArrayList<>();
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public ArrayList<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(ArrayList<String> descriptions) {
        this.descriptions = descriptions;
    }

    public TreeItem<String> getTreeItem() { return treeItem; }

    public void setTreeItem(TreeItem<String> treeItem) { this.treeItem = treeItem; }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
