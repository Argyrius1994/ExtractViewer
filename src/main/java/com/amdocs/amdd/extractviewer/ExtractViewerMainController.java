package com.amdocs.amdd.extractviewer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


public class ExtractViewerMainController {

    @FXML
    private JFXRadioButton existingConnBulletId;

    @FXML
    private JFXRadioButton localBulletId;

    @FXML
    private JFXRadioButton newConnBulletId;

    @FXML
    private JFXRadioButton remoteBulletId;

    @FXML
    private JFXButton startButtonId;

    @FXML
    private Label pleaseSelectId;

    private String isRemote="Connection to Remote Server";
    private String isLocal="Connection to Local Server";
    private String isNewConn="New ";
    private String isExistingConn="Existing ";

    @FXML
    void initialize(){

        ToggleGroup radioGroup= new ToggleGroup();

        remoteBulletId.setToggleGroup(radioGroup);
        localBulletId.setToggleGroup(radioGroup);

        localBulletId.setSelected(true);

        ToggleGroup checkGroup = new ToggleGroup();

        newConnBulletId.setToggleGroup(checkGroup);
        existingConnBulletId.setToggleGroup(checkGroup);

        existingConnBulletId.setSelected(true);

        pleaseSelectId = new Label();

        startButtonId.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(remoteBulletId.isSelected())
                {
                    if(existingConnBulletId.isSelected())
                    {
                        startButtonId.getScene().getWindow().hide();
                        try
                        {
                            loadNewScene("/com/amdocs/amdd/extractviewer/existingPage.fxml",isExistingConn+isRemote);

                        }catch (Exception e){
                            System.out.println("The new Scene didn't load!");
                            e.printStackTrace();
                        }
                    }else if (newConnBulletId.isSelected())
                    {
                        startButtonId.getScene().getWindow().hide();
                        try
                        {
                            loadNewScene("/com/amdocs/amdd/extractviewer/newPage.fxml",isNewConn+isRemote);

                        }catch (Exception e){
                            System.out.println("The new Scene didn't load!");
                            e.printStackTrace();
                        }
                    }
                }else if (localBulletId.isSelected())
                {
                    if(existingConnBulletId.isSelected())
                    {
                        startButtonId.getScene().getWindow().hide();
                        try
                        {
                            loadNewScene("/com/amdocs/amdd/extractviewer/existingPage.fxml",isExistingConn+isLocal);


                        }catch (Exception e){
                            System.out.println("The new Scene didn't load!");
                            e.printStackTrace();
                        }
                    }else if (newConnBulletId.isSelected())
                    {
                        startButtonId.getScene().getWindow().hide();
                        try
                        {
                            loadNewScene("/com/amdocs/amdd/extractviewer/newPage.fxml", isNewConn+isLocal);
                        }catch (Exception e){
                            System.out.println("The new Scene didn't load!");
                            e.printStackTrace();
                        }
                    }
                }

            }
        });

    }

    private void loadNewScene(String fxml, String title) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(fxml));
        fxmlLoader.load();
        Parent root = fxmlLoader.getRoot();
        Stage stage = new Stage();

                Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/com/amdocs/amdd/extractviewer/icon.png"))));
        stage.setTitle(title);
        stage.show();
        //stage.setResizable(false);

        if(title.contains("New"))
        {
            NewController newController=fxmlLoader.getController();
            newController.initialize();
        }else
        {
            ExistingController existingController=fxmlLoader.getController();
            existingController.createMenuBar();
        }
    }

}