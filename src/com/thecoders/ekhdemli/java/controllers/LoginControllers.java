package com.thecoders.ekhdemli.java.controllers;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginControllers implements Initializable {
    @FXML
    private VBox root;
    @FXML
    private JFXTextField fieldEmail;
    @FXML
    private JFXPasswordField fieldPassword;
    @FXML
    private JFXCheckBox checkRememberMe;

    private JFXSnackbar toastMsg;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        root.addEventHandler(KeyEvent.KEY_PRESSED, e ->{
            System.out.println("Psssed !");
            if(e.getCode().equals(KeyCode.ENTER)) { onSignIn();
            }
        });

        toastMsg = new JFXSnackbar(root);
    }

    @FXML
    private void onForgetPassword() {
        VBox panePassRecovery = null;
        try {
            panePassRecovery = FXMLLoader.load(getClass().getResource("/com/thecoders/ekhdemli/resources/views/PasswordRecovery.fxml"));
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

        ((Stage) fieldEmail.getScene().getWindow()).setScene(new Scene(panePassRecovery));
    }

    @FXML
    private void onSignIn() {
        if(fieldEmail.getText() == null || fieldEmail.getText().trim().isEmpty()) {
            toastMsg.show("Email is Empty !", 1800);
            return;
        }
        if(!fieldEmail.getText().trim().toLowerCase().matches("^[a-z0-9_][a-z0-9_-]+@[a-z0-9_]{2,}\\.[a-z]{2,6}$")) {
            toastMsg.show("Invalid Email !", 1800);
            return;
        }
        if(fieldPassword.getText() == null) {
            toastMsg.show("Password is Empty !", 1800);
            return;
        }
        if(fieldEmail.getText().length() < 4) {
            toastMsg.show("Password is short !", 1800);
            return;
        }

        toastMsg.show("Email and/or password wrong !", 2000);
    }
}
