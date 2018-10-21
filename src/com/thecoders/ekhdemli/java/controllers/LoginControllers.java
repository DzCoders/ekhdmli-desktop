package com.thecoders.ekhdemli.java.controllers;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

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
        toastMsg = new JFXSnackbar(root);
    }

    @FXML
    private void onForgetPassword() {

    }

    @FXML
    private void onSignIn() {
        toastMsg.show("", 3000);
    }
}
