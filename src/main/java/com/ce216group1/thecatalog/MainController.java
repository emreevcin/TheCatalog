package com.ce216group1.thecatalog;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


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
    private TextField typeTF;

    @FXML
    private TextField itemTF;

    @FXML
    private Button typeCB;

    @FXML
    private Button itemCB;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rootNode.setExpanded(true);

        treeView.setRoot(rootNode);
    }
}