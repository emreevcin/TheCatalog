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
    TreeItem<Type> rootNode = new TreeItem<Type>();

    @FXML
    private TreeView<String> treeView;

    @FXML
    private TextField typeTF;

    @FXML
    private Button typeCB;

    @FXML
    void createType() {
        if (typeTF.getText().length() != 0) {
            Type type = new Type(typeTF.getText());
            types.add(type);
            TreeItem<Type> newType = new TreeItem<>(type);
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
    void selectItem() {
        TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
        if (item != null) {
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rootNode.setExpanded(true);

//        treeView.setRoot(rootNode);
    }
}