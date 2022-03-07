package com.amdocs.amdd.extractviewer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.EventListener;

public class NewController {

    @FXML
    private JFXCheckBox createMasterDbId;

    @FXML
    private TextField guiVersionId;

    @FXML
    private Label labelRemoteId;

    @FXML
    private TextField envDetailsId;

    @FXML
    private TextField logFileNameId;

    @FXML
    private TextField portId;

    @FXML
    private JFXCheckBox tunnelingCheckBoxId;

    @FXML
    private TextField tunnelingUserPassInstId;

    @FXML
    private TextField userPassInstanceId;

    @FXML
    private Label welcomeTextId;

    @FXML
    private JFXComboBox<?> comboBoxId;

    @FXML
    private JFXButton doneButtonId;

    @FXML
    void initialize()
    {
        if(!createMasterDbId.isSelected())
        {
            userPassInstanceId.setDisable(true);
            guiVersionId.setDisable(true);
            comboBoxId.setDisable(false);
        }

        createMasterDbId.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if(!createMasterDbId.isSelected())
                {
                    userPassInstanceId.setDisable(true);
                    guiVersionId.setDisable(true);
                    comboBoxId.setDisable(false);
                }else
                {
                    userPassInstanceId.setDisable(false);
                    guiVersionId.setDisable(false);
                    comboBoxId.setDisable(true);
                }
            }
        });
        if(!tunnelingCheckBoxId.isSelected()){
            tunnelingUserPassInstId.setDisable(true);
            portId.setDisable(true);
        }
        tunnelingCheckBoxId.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if(!tunnelingCheckBoxId.isSelected()){
                    tunnelingUserPassInstId.setDisable(true);
                    portId.setDisable(true);
                }else
                {
                    tunnelingUserPassInstId.setDisable(false);
                    portId.setDisable(false);
                }
            }
        });
        doneButtonId.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try
                {

                    Process process = Runtime.getRuntime().exec("find . -name "+ logFileNameId.getText()); // for Linux
                    process.waitFor();
                    System.out.println(process.getOutputStream());

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });



    }

}