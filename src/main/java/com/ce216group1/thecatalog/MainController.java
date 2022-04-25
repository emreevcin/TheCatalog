package com.ce216group1.thecatalog;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController extends TreeCell<String> implements Initializable {

    ArrayList<Type> types = new ArrayList<>();
    ArrayList<Item> items = new ArrayList<>();
    TreeItem<String> rootNode = new TreeItem<String>("My Collection");

    @FXML
    private TreeView<String> treeView;

    @FXML
    private TableView<Item> tableView;

    @FXML
    private TableView<Item> editView;

    @FXML
    private TextField typeTF;

    @FXML
    private TextField itemTF;

    @FXML
    private TextField keyTF;

    @FXML
    private TextField valueTF;

    @FXML
    private TextField tagTF;

    @FXML
    private TextField textField;


    ObservableList<Item> list = FXCollections.observableArrayList();
    int keyCounter=1;
    int currentKey=2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rootNode.setExpanded(true);

        for (Item item : list) {
            TreeItem<String> itemLeaf = new TreeItem<>(item.getName());
            boolean found = false;
            for (TreeItem<String> typeNode : rootNode.getChildren()) {
                if (typeNode.getValue().contentEquals(typeTF.getText())) {
                    typeNode.getChildren().add(itemLeaf);
                    found = true;
                    break;
                }
            }
            if (!found) {
                TreeItem<String> typeNode = new TreeItem<String>(typeTF.getText());
                rootNode.getChildren().add(typeNode);
                typeNode.getChildren().add(itemLeaf);
            }
        }
        treeView.setRoot(rootNode);
        treeView.setEditable(true);

        tableView.setEditable(true);


        TableColumn type = new TableColumn("Type");
        TableColumn name = new TableColumn("Item");

        tableView.getColumns().addAll(type, name);
        editView.getColumns().addAll(type, name);


        type.setCellValueFactory(new PropertyValueFactory<Item, String>("Type"));
        name.setCellValueFactory(new PropertyValueFactory<Item, String>("Name"));


        tableView.setItems(list);
        editView.setItems(list);

    }


    @FXML
    void createType() {
        if (typeTF.getText().length() != 0) {
            Type type = new Type(typeTF.getText());
            types.add(type);
            TreeItem<String> newType = new TreeItem<>(typeTF.getText());
            rootNode.getChildren().add(newType);
            typeTF.setText("");
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMATION!");
            alert.setHeaderText("Something went wrong:/");
            alert.setContentText("Please enter something.");
            alert.showAndWait();
        }
    }


    @FXML
    void createItem() {
        if (itemTF.getText().length() != 0) {
            TreeItem<String> newItem = new TreeItem<>(itemTF.getText());
            TreeItem<String> itemNode = treeView.getSelectionModel().getSelectedItem();
            if (itemNode != null && itemNode != rootNode) {
                Item item = new Item(itemTF.getText(),newItem,itemNode.getValue());
                items.add(item);
                itemNode.getChildren().add(newItem);


            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Item Creation");
                alert.setHeaderText("You must select which type you want to add the item to!");
                alert.setContentText("Please try again by selecting the type you want to add the item to.");
                alert.showAndWait();
            }
            itemTF.setText("");
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMATION!");
            alert.setHeaderText("Something went wrong:/");
            alert.setContentText("Please enter something.");
            alert.showAndWait();
        }
    }

    @FXML
    void selectItem() {
        TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
        if (item != null) {
            for(int i=0;i<items.size();i++) {
                if(items.get(i).getTreeItem().equals(item)) {
                    list.clear();
                    list.add(items.get(i));
                    break;
                }
            }
        }
    }

    @FXML
    void delete(ActionEvent e) {
        TreeItem c = (TreeItem) treeView.getSelectionModel().getSelectedItem();
        if (c == null) {
            return;
        }
        if (c.getParent() != null) {
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "You are about to delete an element!",
                    ButtonType.YES,
                    ButtonType.NO
            );
            alert.setTitle("WARNING!");
            alert.setHeaderText("Do you want to delete the element named  " + c.getValue() + "  ?");
            alert.setContentText("It may have data members inside it");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                boolean var3 = c.getParent().getChildren().remove(c);
            }
            if (alert.getResult() == ButtonType.NO) {
                alert.close();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR!");
            alert.setHeaderText("Something went wrong");
            alert.setContentText("You cannot delete the root!");
            alert.showAndWait();
        }

    }

    @FXML
    void editTypeAndItem() {
        TreeItem<String> currentNode = treeView.getSelectionModel().getSelectedItem();
        if (currentNode == null) {
            return;
        }
        if (currentNode.getParent() != null) {
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "You are about edit an element!",
                    ButtonType.YES,
                    ButtonType.NO
            );
            alert.setTitle("WARNING!");
            alert.setHeaderText("Do you want to rename the element named " + currentNode.getValue() + " into " + textField.getText() + " ?");
            alert.setContentText("This element might be valuable");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                currentNode.setValue(textField.getText());
                currentNode.getChildren().clear();
            }
            if (alert.getResult() == ButtonType.NO) {
                alert.close();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR!");
            alert.setHeaderText("Something went wrong");
            alert.setContentText("You cannot edit/rename the root!");
            alert.showAndWait();
        }



    }

    @FXML
    void createKey() {
        TreeItem<String> type = treeView.getSelectionModel().getSelectedItem();
        if(type.getParent()==rootNode) {
            for (int i = 0; i < types.size(); i++) {
                if (types.get(i).getName().equals(type)) {
                 types.get(i).getAttributes().add(keyTF.getText());
                }
            }
            TableColumn key = new TableColumn(keyTF.getText());
            tableView.getColumns().add(key);
            editView.getColumns().add(key);
            keyTF.setText("");
            keyCounter++;
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR!");
            alert.setHeaderText("Something went wrong:/");
            alert.setContentText("You need to select a type from main menu!");
            alert.showAndWait();
        }
    }

    @FXML
    void createValue() {
        TreeItem<String> selectedItem = treeView.getSelectionModel().getSelectedItem();
        if(selectedItem.getParent()!=rootNode && selectedItem!=null) {
            for(int i=0;i<items.size();i++) {
                if(items.get(i).getTreeItem().equals(selectedItem)) {
                    items.get(i).getDescriptions().add(valueTF.getText());
                }
            }
        }

    }

    @FXML
    void createTag() {
        TreeItem<String> selectedItem = treeView.getSelectionModel().getSelectedItem();
        if(selectedItem.getParent()!=rootNode && selectedItem!=null) {
            for (int i = 0; i < items.size(); i++) {
                if(items.get(i).getTreeItem().equals(selectedItem)) {
                    items.get(i).getTags().add(tagTF.getText());
                    selectedItem.setValue(selectedItem.getValue()+" "+tagTF.getText());
                    items.get(i).getTags().clear();
                    tagTF.clear();
                }
            }
        }
    }

}

