package com.ce216group1.thecatalog;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Button deleteButton;

    @FXML
    private TreeView<String> treeView;

    ArrayList<Type> types = new ArrayList<>();
    ArrayList<Item> items = new ArrayList<>();
    @FXML
    void selectItem() {
        TreeItem item = treeView.getSelectionModel().getSelectedItem();
        if (item != null) {
        }
    }
    @FXML
    void delete(ActionEvent e) {
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
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
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}