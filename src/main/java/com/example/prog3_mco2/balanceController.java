package com.example.prog3_mco2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;

import java.io.IOException;

public class balanceController
{

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Spinner spn1;

    @FXML
    private Spinner spn2;

    @FXML
    private Spinner spn3;

    @FXML
    private Spinner spn4;

    @FXML
    private Spinner spn5;

    @FXML
    private Spinner spn6;

    @FXML
    private Spinner spn7;

    @FXML
    private Spinner spn8;

    @FXML
    private Spinner spn9;

    public void exit(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("maintenance.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
