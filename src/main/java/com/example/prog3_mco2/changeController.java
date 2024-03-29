package com.example.prog3_mco2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class changeController implements Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;

    private RegularVendingMachine vm;

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;

    @FXML
    private TextField txt3;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Label lbl4;

    @FXML
    private Label lbl5;

    @FXML
    private ChoiceBox<String> choiceBox;

    public changeController(RegularVendingMachine vm)
    {
        this.vm = vm;
    }

    public void changePrice(ActionEvent event) throws IOException
    {
        String name = choiceBox.getValue();

        try
        {
            int price = Integer.parseInt(txt1.getText());

            for (int i = 0; i < vm.getSlotList().size(); i++)
            {
                if (choiceBox.getItems().get(i).equals(name))
                {
                    if (!vm.getSlotList().get(i).changeItemPrice(price))
                        throw new Exception();
                    choiceList();
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Input Error!");
            alert.setContentText("Please try again");
            alert.show();
        }

    }

    public void changeCalories(ActionEvent event) throws IOException
    {
        String name = choiceBox.getValue();

        try
        {
            int calories = Integer.parseInt(txt2.getText());

            for (int i = 0; i < vm.getSlotList().size(); i++)
            {
                if (choiceBox.getItems().get(i).equals(name))
                {
                    if (!vm.getSlotList().get(i).changeItemCalories(calories))
                        throw new Exception();
                    choiceList();
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Input Error!");
            alert.setContentText("Please try again");
            alert.show();
        }

    }

    public void changeDescription(ActionEvent event) throws IOException
    {
        String name = choiceBox.getValue();

        try
        {
            for (int i = 0; i < vm.getSlotList().size(); i++)
            {
                if (choiceBox.getItems().get(i).equals(name))
                {
                    vm.getSlotList().get(i).changeItemDescription(txt3.getText());
                    choiceList();
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Input Error!");
            alert.setContentText("Please try again");
            alert.show();
        }

    }

    public void list(ActionEvent event) throws IOException
    {
        choiceList();
    }

    public void choiceList()
    {
        String name = choiceBox.getValue();

        for (int i = 0; i < vm.getSlotList().size(); i++) {
            if (choiceBox.getItems().get(i).equals(name))
            {
                lbl1.setText(vm.getSlotList().get(i).getName());
                lbl2.setText(Integer.toString(vm.getSlotList().get(i).getItemPrice()));
                lbl3.setText(Integer.toString(vm.getSlotList().get(i).getItemCalories()));
                lbl5.setText(vm.getSlotList().get(i).getItemDescription());
            }
        }
    }

    public void exit(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("maintenance.fxml"));
        loader.setControllerFactory(controllerClass -> new maintenanceController(vm));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        for (int i = 0; i < vm.getSlotList().size(); i++)
            choiceBox.getItems().add(vm.getSlotList().get(i).toString());

        choiceBox.getSelectionModel().selectFirst();
        choiceList();

    }

}
