package com.ce216group1.thecatalog;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    ArrayList<Type> types = new ArrayList<>();
    ArrayList<Item> items = new ArrayList<>();
    TreeItem<String> rootNode = new TreeItem<String>("My Collection");

    @FXML
    private TreeView<String> treeView;

    @FXML
    private TableView<Item> tableView;

    @FXML
    private TextField typeTF;

    @FXML
    private TextField itemTF;

    @FXML
    private TextField keyTF;

    @FXML
    private TextField taggedItemTF;

    private TextField tagTF;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        treeView=new TreeView<String>();
        tableView=new TableView<Item>();
        rootNode.setExpanded(true);
        treeView.setRoot(rootNode);
    }

    @FXML
    void createItem() {
        if (itemTF.getText().length() != 0) {
            TreeItem<String> newItem = new TreeItem<>(itemTF.getText());
            TreeItem<String> itemNode = treeView.getSelectionModel().getSelectedItem();
            Item item = new Item(itemTF.getText());
            items.add(item);
            itemNode.getChildren().add(newItem);
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
        }
    }

    @FXML
    void delete(ActionEvent e) {

        TreeItem c = (TreeItem) treeView.getSelectionModel().getSelectedItem();
        if (c == null) {
            return;
        }
        if (c.getParent() != null) {
            boolean remove = c.getParent().getChildren().remove(c);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR!");
            alert.setHeaderText("Something went wrong:/");
            alert.setContentText("You cannot delete the root!");
            alert.showAndWait();
        }
    }



    @FXML
    void createKey() {
        TableColumn key = new TableColumn(keyTF.getText());
        tableView.getColumns().add(key);
        keyTF.setText("");
        key.setCellValueFactory(new PropertyValueFactory<Item, String>(keyTF.getText()));
    }
}

//Doga